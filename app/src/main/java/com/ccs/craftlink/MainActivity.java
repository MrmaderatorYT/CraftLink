package com.ccs.craftlink;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ccs.craftlink.fragment.ChatFragment;
import com.ccs.craftlink.fragment.InventoryFragment;
import com.ccs.craftlink.fragment.MovementFragment;
import com.ccs.craftlink.fragment.ServersFragment;
import com.ccs.craftlink.fragment.SettingsFragment;
import com.ccs.craftlink.render.NativeRender;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.ccs.craftlink.render.NativeRender.init(this);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        toolbar = findViewById(R.id.toolbar);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            loadFragment(new ServersFragment());
        }

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_servers) {
                fragment = new ServersFragment();
                toolbar.setTitle(R.string.nav_servers);
            } else if (itemId == R.id.nav_chat) {
                fragment = new ChatFragment();
                toolbar.setTitle(R.string.nav_chat);
            } else if (itemId == R.id.nav_inventory) {
                fragment = new InventoryFragment();
                toolbar.setTitle(R.string.nav_inventory);
            } else if (itemId == R.id.nav_movement) {
                fragment = new MovementFragment();
                toolbar.setTitle(R.string.nav_movement);
            } else if (itemId == R.id.nav_settings) {
                fragment = new SettingsFragment();
                toolbar.setTitle(R.string.nav_settings);
            }

            if (fragment != null) {
                loadFragment(fragment);
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
