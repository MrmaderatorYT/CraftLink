#!/usr/bin/env python3
"""
Minecraft Item/Block Texture Atlas Generator for CraftLink NDK Renderer.

Usage:
    python3 generate_atlas.py \
        --items-json path/to/items.json \
        --resource-pack path/to/Nautilus3D/ \
        --output-dir path/to/app/src/main/assets/renderer/

This script:
1. Loads items.json from PrismarineJS/minecraft-data (versions 1.8-1.21)
2. Builds a binary dictionary: (protocol_id, item_id) -> string_name
3. Parses Nautilus3D resource pack for textures/models
4. Packs all textures into a Texture Atlas (.png)
5. Generates atlas_map.bin with UV coordinates per item
"""

import os
import sys
import json
import struct
import hashlib
import argparse
from pathlib import Path
from PIL import Image
import numpy as np

# ============================================================
#  SECTION 1: Items.json loader (PrismarineJS minecraft-data)
# ============================================================

def load_items_json(path):
    """Load items.json from PrismarineJS minecraft-data format."""
    with open(path, 'r', encoding='utf-8') as f:
        raw = json.load(f)

    if isinstance(raw, list):
        return raw

    items = []
    for key, entry in raw.items():
        item_id = int(key) if key.isdigit() else None
        if item_id is None:
            continue
        name = entry.get('name', entry.get('displayName', ''))
        if not name:
            continue
        entry['id'] = item_id
        entry['name'] = name
        items.append(entry)
    return items


def build_item_dictionary(items):
    """
    Build dictionary: item_id -> string_name.
    Returns dict[int, str].
    """
    d = {}
    for item in items:
        item_id = item.get('id')
        name = item.get('name', '')
        if item_id is not None and name:
            d[item_id] = name
    return d


# ============================================================
#  SECTION 2: Resource Pack Parser (Nautilus3D / vanilla)
# ============================================================

RESOURCE_PACK_DIRS = ['assets', 'resourcepacks']

TEXTURE_EXTS = {'.png'}
MODEL_EXTS = {'.json'}
BLOCKSTATE_EXTS = {'.json'}


def find_textures(pack_path):
    """
    Recursively find all .png textures in the resource pack.
    Returns dict[str, str] where key=relative_path, value=abs_path.
    """
    textures = {}
    pack = Path(pack_path)
    for root, dirs, files in os.walk(pack):
        for f in files:
            if f.endswith('.png'):
                full = os.path.join(root, f)
                rel = os.path.relpath(full, pack)
                textures[rel] = full
    return textures


def parse_model_textures(pack_path):
    """
    Parse models/blocks/*.json and models/items/*.json.
    Returns dict[string_name -> texture_rel_path].
    """
    mapping = {}
    pack = Path(pack_path)

    model_dirs = [
        pack / 'assets' / 'minecraft' / 'models' / 'block',
        pack / 'assets' / 'minecraft' / 'models' / 'blocks',
        pack / 'assets' / 'minecraft' / 'models' / 'item',
        pack / 'assets' / 'minecraft' / 'models' / 'items',
    ]

    for model_dir in model_dirs:
        if not model_dir.exists():
            continue
        for json_file in model_dir.rglob('*.json'):
            try:
                with open(json_file, 'r', encoding='utf-8') as f:
                    data = json.load(f)

                name = json_file.stem
                textures = data.get('textures', {})

                tex_key = textures.get('all', textures.get('texture', textures.get('layer0', '')))
                if tex_key and isinstance(tex_key, str) and tex_key.startswith('minecraft:'):
                    tex_key = tex_key.replace('minecraft:', '')

                if tex_key and tex_key not in mapping:
                    tex_path = find_texture_file(pack, tex_key)
                    if tex_path:
                        mapping[name] = tex_path

            except Exception:
                continue

    return mapping


def find_texture_file(pack_path, tex_key):
    """Find actual .png file for a texture key like 'blocks/dirt' or 'item/diamond_sword'."""
    pack = Path(pack_path)

    candidates = [
        pack / 'assets' / 'minecraft' / (tex_key + '.png'),
        pack / 'assets' / 'minecraft' / 'textures' / (tex_key + '.png'),
        pack / 'assets' / 'minecraft' / 'textures' / 'item' / (tex_key.split('/')[-1] + '.png'),
        pack / 'assets' / 'minecraft' / 'textures' / 'block' / (tex_key.split('/')[-1] + '.png'),
    ]

    for c in candidates:
        if c.exists():
            return str(c)

    # Search recursively for the filename
    fname = tex_key.split('/')[-1] + '.png'
    for f in pack.rglob(fname):
        return str(f)

    return None


def parse_blockstates(pack_path):
    """
    Parse blockstates/*.json for model paths.
    Returns dict[block_name -> model_rel_path].
    """
    mapping = {}
    bs_dir = Path(pack_path) / 'assets' / 'minecraft' / 'blockstates'
    if not bs_dir.exists():
        return mapping

    for json_file in bs_dir.glob('*.json'):
        try:
            with open(json_file, 'r', encoding='utf-8') as f:
                data = json.load(f)

            name = json_file.stem
            variants = data.get('variants', {})
            if variants:
                first_variant = list(variants.values())[0]
                if isinstance(first_variant, dict):
                    model = first_variant.get('model', '')
                    if model.startswith('minecraft:'):
                        model = model.replace('minecraft:', '')
                    mapping[name] = model
                elif isinstance(first_variant, list) and first_variant:
                    model = first_variant[0].get('model', '')
                    if model.startswith('minecraft:'):
                        model = model.replace('minecraft:', '')
                    mapping[name] = model
        except Exception:
            continue

    return mapping


# ============================================================
#  SECTION 3: Texture Atlas Generator
# ============================================================

DEFAULT_TEXTURE_SIZE = 16
ATLAS_MAX_SIZE = 4096


def load_texture(path, target_size=DEFAULT_TEXTURE_SIZE):
    """Load a PNG texture and resize to target_size x target_size."""
    try:
        img = Image.open(path).convert('RGBA')
        img = img.resize((target_size, target_size), Image.NEAREST)
        return img
    except Exception:
        return None


def generate_placeholder_texture(size=DEFAULT_TEXTURE_SIZE):
    """Generate a simple placeholder texture (checkerboard)."""
    img = Image.new('RGBA', (size, size), (128, 128, 128, 255))
    for y in range(size):
        for x in range(size):
            if (x // 4 + y // 4) % 2 == 0:
                img.putpixel((x, y), (160, 160, 160, 255))
    return img


def build_texture_atlas(item_dict, texture_mapping, output_dir, atlas_size=ATLAS_MAX_SIZE):
    """
    Build a texture atlas PNG and atlas_map.bin.

    atlas_map.bin format:
    - Header: magic "CLAT" (4 bytes), version uint32, item_count uint32
    - Per item: item_id int32, u float32, v float32, size float32, flags uint8
      (flags: 0=no texture, 1=has texture)

    Atlas layout: simple grid packing.
    """
    print(f"Building atlas for {len(item_dict)} items...")

    placeholder = generate_placeholder_texture()
    atlas_images = []
    atlas_coords = {}

    cell_size = 16
    cols = atlas_size // cell_size
    placed = 0

    items_sorted = sorted(item_dict.items())

    for item_id, name in items_sorted:
        tex_path = texture_mapping.get(name)
        if tex_path:
            img = load_texture(tex_path, cell_size)
        else:
            img = None

        if img is None:
            img = placeholder
            has_texture = 0
        else:
            has_texture = 1

        row = placed // cols
        col = placed % cols
        u = col / cols
        v = row / cols
        size = 1.0 / cols

        atlas_coords[item_id] = (u, v, size, has_texture)
        atlas_images.append((img, row, col))
        placed += 1

    # Build atlas image
    rows_needed = (placed + cols - 1) // cols
    actual_h = rows_needed * cell_size
    actual_w = cols * cell_size

    atlas = Image.new('RGBA', (actual_w, actual_h), (0, 0, 0, 0))

    for img, row, col in atlas_images:
        x = col * cell_size
        y = row * cell_size
        atlas.paste(img, (x, y))

    # Save atlas
    os.makedirs(output_dir, exist_ok=True)
    atlas_path = os.path.join(output_dir, 'item_atlas.png')
    atlas.save(atlas_path)
    print(f"Atlas saved: {atlas_path} ({actual_w}x{actual_h})")

    # Build atlas_map.bin
    bin_path = os.path.join(output_dir, 'atlas_map.bin')
    with open(bin_path, 'wb') as f:
        # Header: "CLAT" + version + atlas_w + atlas_h + item_count
        f.write(b'CLAT')
        f.write(struct.pack('<I', 1))  # version
        f.write(struct.pack('<I', actual_w))
        f.write(struct.pack('<I', actual_h))
        f.write(struct.pack('<I', len(atlas_coords)))

        for item_id in sorted(atlas_coords.keys()):
            u, v, size, has_tex = atlas_coords[item_id]
            f.write(struct.pack('<i', item_id))
            f.write(struct.pack('<f', u))
            f.write(struct.pack('<f', v))
            f.write(struct.pack('<f', size))
            f.write(struct.pack('<B', has_tex))

    print(f"atlas_map.bin saved: {bin_path} ({len(atlas_coords)} entries)")
    return atlas_coords


# ============================================================
#  SECTION 4: Binary Item Dictionary
# ============================================================

def build_item_binary(item_dict, output_dir):
    """
    Build item_dict.bin:
    - Header: magic "CITEM", version uint32, count uint32
    - Per entry: item_id int32, name_length uint16, name_bytes utf8
    """
    os.makedirs(output_dir, exist_ok=True)
    bin_path = os.path.join(output_dir, 'item_dict.bin')

    with open(bin_path, 'wb') as f:
        f.write(b'CITEM')
        f.write(struct.pack('<I', 1))  # version
        f.write(struct.pack('<I', len(item_dict)))

        for item_id in sorted(item_dict.keys()):
            name = item_dict[item_id]
            name_bytes = name.encode('utf-8')
            f.write(struct.pack('<i', item_id))
            f.write(struct.pack('<H', len(name_bytes)))
            f.write(name_bytes)

    print(f"item_dict.bin saved: {bin_path} ({len(item_dict)} entries)")

    # Also build index: item_id -> file_offset for O(1) lookup
    idx_path = os.path.join(output_dir, 'item_index.bin')
    with open(idx_path, 'wb') as f:
        f.write(b'CIDX')
        f.write(struct.pack('<I', 1))

        # Find max item_id for direct array indexing
        max_id = max(item_dict.keys()) if item_dict else 0
        f.write(struct.pack('<I', max_id + 1))

        # Write offset table (direct indexed by item_id)
        offsets = {}
        offset = 7  # header size
        for item_id in sorted(item_dict.keys()):
            offsets[item_id] = offset
            name_bytes = item_dict[item_id].encode('utf-8')
            offset += 4 + 2 + len(name_bytes)  # id + name_len + name

        for i in range(max_id + 1):
            off = offsets.get(i, 0)
            f.write(struct.pack('<I', off))

    print(f"item_index.bin saved: {idx_path}")


# ============================================================
#  SECTION 5: Main
# ============================================================

def main():
    parser = argparse.ArgumentParser(description='Minecraft Item Texture Atlas Generator')
    parser.add_argument('--items-json', required=True, help='Path to items.json from PrismarineJS/minecraft-data')
    parser.add_argument('--resource-pack', required=True, help='Path to Nautilus3D resource pack')
    parser.add_argument('--output-dir', required=True, help='Output directory for binary files and atlas')
    parser.add_argument('--atlas-size', type=int, default=4096, help='Atlas texture size (default: 4096)')
    args = parser.parse_args()

    print("=== Minecraft Item Texture Atlas Generator ===")
    print(f"Items JSON: {args.items_json}")
    print(f"Resource Pack: {args.resource_pack}")
    print(f"Output: {args.output_dir}")
    print()

    # Step 1: Load items
    print("[1/4] Loading items.json...")
    items = load_items_json(args.items_json)
    item_dict = build_item_dictionary(items)
    print(f"  -> {len(item_dict)} items loaded")

    # Step 2: Parse resource pack textures
    print("[2/4] Parsing resource pack textures...")
    textures = find_textures(args.resource_pack)
    print(f"  -> {len(textures)} textures found")

    print("[2b/4] Parsing models...")
    model_textures = parse_model_textures(args.resource_pack)
    print(f"  -> {len(model_textures)} model->texture mappings")

    # Merge: item_name -> texture_path
    # Try multiple strategies to find textures for each item
    texture_mapping = {}

    for item_id, name in item_dict.items():
        # Strategy 1: Check if model exists and has texture
        if name in model_textures:
            texture_mapping[name] = model_textures[name]
            continue

        # Strategy 2: Look for textures/item/<name>.png
        pack = Path(args.resource_pack)
        item_tex = pack / 'assets' / 'minecraft' / 'textures' / 'item' / (name + '.png')
        if item_tex.exists():
            texture_mapping[name] = str(item_tex)
            continue

        # Strategy 3: Look for textures/block/<name>.png
        block_tex = pack / 'assets' / 'minecraft' / 'textures' / 'block' / (name + '.png')
        if block_tex.exists():
            texture_mapping[name] = str(block_tex)
            continue

        # Strategy 4: Search recursively
        for rel, full in textures.items():
            if name in rel:
                texture_mapping[name] = full
                break

    print(f"  -> {len(texture_mapping)} item->texture mappings")

    # Step 3: Build item dictionary binary
    print("[3/4] Building item dictionary binary...")
    build_item_binary(item_dict, args.output_dir)

    # Step 4: Build texture atlas
    print("[4/4] Building texture atlas...")
    build_texture_atlas(item_dict, texture_mapping, args.output_dir, args.atlas_size)

    print()
    print("=== Done! ===")
    print(f"Output files in: {args.output_dir}")
    print("  - item_dict.bin  (item_id -> string_name)")
    print("  - item_index.bin (item_id -> offset for O(1) lookup)")
    print("  - item_atlas.png (texture atlas)")
    print("  - atlas_map.bin  (item_id -> UV coordinates)")


if __name__ == '__main__':
    main()
