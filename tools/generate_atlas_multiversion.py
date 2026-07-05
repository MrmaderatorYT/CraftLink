#!/usr/bin/env python3
"""
Multi-version Minecraft Item Texture Atlas Generator for CraftLink NDK Renderer.

Solves the dynamic item ID problem (1.8+) by:
1. Loading items.json for each supported protocol version
2. Building a universal dictionary: universal_id -> string_name
3. Generating item_index.bin: (protocol_version, dynamic_id) -> universal_id
4. Generating item_dict.bin and atlas_map.bin using universal_id

Supported protocol versions:
  47   (1.8), 340 (1.12.2), 498 (1.14), 754 (1.16.5),
  758 (1.18.2), 763 (1.20.1), 765 (1.20.4), 767 (1.21)

Usage:
    python3 generate_atlas_multiversion.py \
        --data-dir /path/to/minecraft-data/data/pc/ \
        --resource-pack /path/to/Nautilus3D/ \
        --output-dir app/src/main/assets/renderer/
"""

import os
import sys
import json
import struct
import argparse
from pathlib import Path
from PIL import Image


# ============================================================
#  Version mapping: protocol_version -> minecraft-data path
# ============================================================

PROTOCOL_VERSIONS = {
    47:   "1.8",
    340:  "1.12",
    498:  "1.14",
    754:  "1.16.2",
    758:  "1.18",
    763:  "1.20",
    765:  "1.20.3",
    767:  "1.21.1",
}


# ============================================================
#  SECTION 1: Load items.json for each version
# ============================================================

def load_items_json(path):
    """Load items.json from a version directory."""
    items_file = Path(path) / "items.json"
    if not items_file.exists():
        print(f"  WARNING: {items_file} not found, skipping")
        return []

    with open(items_file, 'r', encoding='utf-8') as f:
        raw = json.load(f)

    items = []
    if isinstance(raw, list):
        for entry in raw:
            item_id = entry.get('id')
            name = entry.get('name', '')
            if item_id is not None and name:
                items.append({'id': item_id, 'name': name})
    elif isinstance(raw, dict):
        for key, entry in raw.items():
            if not key.isdigit():
                continue
            item_id = int(key)
            name = entry.get('name', entry.get('displayName', ''))
            if name:
                items.append({'id': item_id, 'name': name})

    return items


def load_all_versions(data_dir):
    """Load items.json for all supported protocol versions.

    Returns:
        dict[protocol_version -> list[dict{id, name}]]
    """
    versions = {}
    data_path = Path(data_dir)

    for protocol, mc_version in PROTOCOL_VERSIONS.items():
        version_dir = data_path / mc_version
        print(f"  Loading protocol {protocol} ({mc_version}) from {version_dir}...")
        items = load_items_json(version_dir)
        if items:
            versions[protocol] = items
            print(f"    -> {len(items)} items")
        else:
            print(f"    -> SKIPPED (not found)")

    return versions


# ============================================================
#  SECTION 2: Build universal dictionary
# ============================================================

def build_universal_dictionary(all_versions):
    """
    Build universal_id -> string_name mapping.
    Each unique item name gets a unique universal_id.
    """
    name_to_universal = {}  # name -> universal_id
    universal_to_name = {}  # universal_id -> name
    next_id = 0

    # Collect all unique names across all versions
    for protocol, items in all_versions.items():
        for item in items:
            name = item['name']
            if name not in name_to_universal:
                name_to_universal[name] = next_id
                universal_to_name[next_id] = name
                next_id += 1

    print(f"  Universal dictionary: {len(name_to_universal)} unique items")
    return name_to_universal, universal_to_name


# ============================================================
#  SECTION 3: Build version index
# ============================================================

def build_version_index(all_versions, name_to_universal):
    """
    Build mapping: protocol_version -> (dynamic_id -> universal_id).

    Returns:
        dict[protocol_version -> dict[dynamic_id -> universal_id]]
    """
    index = {}

    for protocol, items in all_versions.items():
        proto_map = {}
        for item in items:
            dynamic_id = item['id']
            name = item['name']
            universal_id = name_to_universal.get(name)
            if universal_id is not None:
                proto_map[dynamic_id] = universal_id
        index[protocol] = proto_map
        print(f"  Protocol {protocol}: {len(proto_map)} mappings")

    return index


# ============================================================
#  SECTION 4: Binary file generation
# ============================================================

def build_item_dict_bin(universal_to_name, output_dir):
    """
    item_dict.bin format:
      Header: "CITEM" (5 bytes) + version(uint32) + count(uint32)
      Per entry: universal_id(int32) + name_len(uint16) + name_bytes(utf8)
    """
    path = os.path.join(output_dir, 'item_dict.bin')
    with open(path, 'wb') as f:
        f.write(b'CITEM')
        f.write(struct.pack('<I', 2))  # version 2 (universal)
        f.write(struct.pack('<I', len(universal_to_name)))

        for uid in sorted(universal_to_name.keys()):
            name = universal_to_name[uid]
            name_bytes = name.encode('utf-8')
            f.write(struct.pack('<i', uid))
            f.write(struct.pack('<H', len(name_bytes)))
            f.write(name_bytes)

    print(f"  item_dict.bin: {len(universal_to_name)} entries, {os.path.getsize(path)} bytes")


def build_item_index_bin(protocol_index, output_dir):
    """
    item_index.bin format (v2 - cross-version):

    Header:
      magic "CIDX" (4 bytes)
      version uint32 = 2
      protocol_count uint32
      total_mapping_count uint32

    Protocol table (repeated for each protocol):
      protocol_version int32
      max_dynamic_id uint32
      mapping_count uint32

    Mapping arrays (repeated for each protocol):
      universal_id[max_dynamic_id + 1]
      (0 means no mapping for that dynamic_id)

    This allows O(1) lookup: protocol_index[protocol][dynamic_id] -> universal_id
    """
    path = os.path.join(output_dir, 'item_index.bin')

    # Calculate offsets
    protocols = sorted(protocol_index.keys())
    header_size = 4 + 4 + 4 + 4  # magic + version + protocol_count + total
    table_size = len(protocols) * (4 + 4 + 4)  # per protocol: version + max_id + count
    array_sizes = sum(p.max_dynamic_id + 1 for p in [
        type('obj', (object,), {'max_dynamic_id': max(proto_map.keys()) if proto_map else 0})
        for proto_map in protocol_index.values()
    ])

    with open(path, 'wb') as f:
        # Header
        f.write(b'CIDX')
        f.write(struct.pack('<I', 2))  # version 2
        f.write(struct.pack('<I', len(protocols)))

        total_mappings = sum(len(m) for m in protocol_index.values())
        f.write(struct.pack('<I', total_mappings))

        # Protocol table + arrays
        for protocol in protocols:
            proto_map = protocol_index[protocol]
            max_id = max(proto_map.keys()) if proto_map else 0
            count = len(proto_map)

            f.write(struct.pack('<i', protocol))
            f.write(struct.pack('<I', max_id))
            f.write(struct.pack('<I', count))

            # Write universal_id array (indexed by dynamic_id)
            arr = [0] * (max_id + 1)
            for dyn_id, uid in proto_map.items():
                if 0 <= dyn_id < len(arr):
                    arr[dyn_id] = uid
            f.write(struct.pack('<' + 'i' * len(arr), *arr))

    print(f"  item_index.bin: {len(protocols)} protocols, {total_mappings} mappings, {os.path.getsize(path)} bytes")


# ============================================================
#  SECTION 5: Texture atlas generation
# ============================================================

def find_texture_file(pack_path, tex_key):
    """Find actual .png file for a texture key."""
    pack = Path(pack_path)
    fname = tex_key.split('/')[-1] + '.png'

    candidates = [
        pack / 'assets' / 'minecraft' / (tex_key + '.png'),
        pack / 'assets' / 'minecraft' / 'textures' / (tex_key + '.png'),
        pack / 'assets' / 'minecraft' / 'textures' / 'item' / fname,
        pack / 'assets' / 'minecraft' / 'textures' / 'block' / fname,
    ]

    for c in candidates:
        if c.exists():
            return str(c)

    for f in pack.rglob(fname):
        return str(f)
    return None


def parse_model_textures(pack_path):
    """Parse models to find texture references."""
    mapping = {}
    pack = Path(pack_path)

    for subdir in ['block', 'blocks', 'item', 'items']:
        model_dir = pack / 'assets' / 'minecraft' / 'models' / subdir
        if not model_dir.exists():
            continue
        for json_file in model_dir.rglob('*.json'):
            try:
                with open(json_file, 'r', encoding='utf-8') as f:
                    data = json.load(f)
                name = json_file.stem
                textures = data.get('textures', {})
                tex_key = textures.get('all', textures.get('texture', textures.get('layer0', '')))
                if tex_key and isinstance(tex_key, str):
                    if tex_key.startswith('minecraft:'):
                        tex_key = tex_key.replace('minecraft:', '')
                    if tex_key and name not in mapping:
                        tex_path = find_texture_file(pack, tex_key)
                        if tex_path:
                            mapping[name] = tex_path
            except Exception:
                continue
    return mapping


def find_textures_recursive(pack_path):
    """Find all .png textures recursively."""
    textures = {}
    for root, _, files in os.walk(Path(pack_path)):
        for f in files:
            if f.endswith('.png'):
                full = os.path.join(root, f)
                rel = os.path.relpath(full, pack_path)
                textures[rel] = full
    return textures


def generate_placeholder(size=16):
    """Generate a checkerboard placeholder texture."""
    from PIL import Image
    img = Image.new('RGBA', (size, size), (128, 128, 128, 255))
    for y in range(size):
        for x in range(size):
            if (x // 4 + y // 4) % 2 == 0:
                img.putpixel((x, y), (160, 160, 160, 255))
    return img


def build_texture_atlas(universal_to_name, texture_mapping, output_dir, atlas_size=4096):
    """Build texture atlas and atlas_map.bin using universal_ids."""
    from PIL import Image

    print(f"  Building atlas for {len(universal_to_name)} items...")
    placeholder = generate_placeholder()
    cell_size = 16
    cols = atlas_size // cell_size
    placed = 0
    atlas_coords = {}
    atlas_images = []

    for uid in sorted(universal_to_name.keys()):
        name = universal_to_name[uid]
        tex_path = texture_mapping.get(name)

        img = None
        has_texture = 0
        if tex_path:
            try:
                img = Image.open(tex_path).convert('RGBA').resize((cell_size, cell_size), Image.NEAREST)
                has_texture = 1
            except Exception:
                img = None

        if img is None:
            img = placeholder
            has_texture = 0

        row = placed // cols
        col = placed % cols
        u = col / cols
        v = row / cols
        size = 1.0 / cols

        atlas_coords[uid] = (u, v, size, has_texture)
        atlas_images.append((img, row, col))
        placed += 1

    rows_needed = (placed + cols - 1) // cols
    actual_h = rows_needed * cell_size
    actual_w = cols * cell_size

    atlas = Image.new('RGBA', (actual_w, actual_h), (0, 0, 0, 0))
    for img, row, col in atlas_images:
        atlas.paste(img, (col * cell_size, row * cell_size))

    os.makedirs(output_dir, exist_ok=True)
    atlas_path = os.path.join(output_dir, 'item_atlas.png')
    atlas.save(atlas_path)
    print(f"  item_atlas.png: {actual_w}x{actual_h}, {os.path.getsize(atlas_path)} bytes")

    # atlas_map.bin: universal_id -> UV coordinates
    map_path = os.path.join(output_dir, 'atlas_map.bin')
    with open(map_path, 'wb') as f:
        f.write(b'CLAT')
        f.write(struct.pack('<I', 2))  # version 2 (universal)
        f.write(struct.pack('<I', actual_w))
        f.write(struct.pack('<I', actual_h))
        f.write(struct.pack('<I', len(atlas_coords)))

        for uid in sorted(atlas_coords.keys()):
            u, v, sz, has_tex = atlas_coords[uid]
            f.write(struct.pack('<i', uid))
            f.write(struct.pack('<f', u))
            f.write(struct.pack('<f', v))
            f.write(struct.pack('<f', sz))
            f.write(struct.pack('<B', has_tex))

    print(f"  atlas_map.bin: {len(atlas_coords)} entries, {os.path.getsize(map_path)} bytes")


# ============================================================
#  MAIN
# ============================================================

def main():
    parser = argparse.ArgumentParser(description='Multi-version Minecraft Item Atlas Generator')
    parser.add_argument('--data-dir', required=True,
                        help='Path to minecraft-data/data/pc/ (contains per-version dirs)')
    parser.add_argument('--resource-pack', required=True,
                        help='Path to Nautilus3D resource pack')
    parser.add_argument('--output-dir', required=True,
                        help='Output directory for binary files and atlas')
    parser.add_argument('--atlas-size', type=int, default=4096)
    parser.add_argument('--versions', nargs='+', type=int,
                        help='Specific protocol versions (default: all)')
    args = parser.parse_args()

    print("=" * 60)
    print("  Multi-version Minecraft Item Atlas Generator")
    print("=" * 60)
    print(f"  Data dir:      {args.data_dir}")
    print(f"  Resource pack: {args.resource_pack}")
    print(f"  Output:        {args.output_dir}")
    print()

    # Step 1: Load all versions
    print("[1/6] Loading items.json for all versions...")
    all_versions = load_all_versions(args.data_dir)
    if not all_versions:
        print("ERROR: No versions loaded!")
        sys.exit(1)
    print()

    # Step 2: Build universal dictionary
    print("[2/6] Building universal dictionary...")
    name_to_universal, universal_to_name = build_universal_dictionary(all_versions)
    print()

    # Step 3: Build version index
    print("[3/6] Building version index...")
    protocol_index = build_version_index(all_versions, name_to_universal)
    print()

    # Step 4: Parse resource pack
    print("[4/6] Parsing resource pack...")
    pack = Path(args.resource_pack)
    all_textures = find_textures_recursive(pack)
    model_textures = parse_model_textures(pack)
    print(f"  {len(all_textures)} textures, {len(model_textures)} model mappings")

    # Build texture mapping: universal_name -> texture_path
    texture_mapping = {}
    for name in universal_to_name.values():
        if name in model_textures:
            texture_mapping[name] = model_textures[name]
            continue
        item_tex = pack / 'assets' / 'minecraft' / 'textures' / 'item' / (name + '.png')
        if item_tex.exists():
            texture_mapping[name] = str(item_tex)
            continue
        block_tex = pack / 'assets' / 'minecraft' / 'textures' / 'block' / (name + '.png')
        if block_tex.exists():
            texture_mapping[name] = str(block_tex)
            continue
        for rel, full in all_textures.items():
            if name in rel:
                texture_mapping[name] = full
                break
    print(f"  {len(texture_mapping)} item->texture mappings")
    print()

    # Step 5: Generate binary files
    os.makedirs(args.output_dir, exist_ok=True)

    print("[5/6] Generating binary files...")
    build_item_dict_bin(universal_to_name, args.output_dir)
    build_item_index_bin(protocol_index, args.output_dir)
    print()

    # Step 6: Build atlas
    print("[6/6] Building texture atlas...")
    build_texture_atlas(universal_to_name, texture_mapping, args.output_dir, args.atlas_size)
    print()

    # Summary
    print("=" * 60)
    print("  DONE!")
    print(f"  Universal items: {len(universal_to_name)}")
    print(f"  Protocol versions: {list(protocol_index.keys())}")
    print(f"  Textures mapped: {len(texture_mapping)}")
    print(f"  Output: {args.output_dir}")
    print("=" * 60)


if __name__ == '__main__':
    main()
