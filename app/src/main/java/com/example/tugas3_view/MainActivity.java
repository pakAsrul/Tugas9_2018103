package com.example.tugas3_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.example.tugas3_view.databinding.FragmentHotelsBinding;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public void Balava (View view){
        Intent b = new Intent(MainActivity.this, Balava.class);
        startActivity(b);
    }
    public void solaris (View view){
        Intent b = new Intent(MainActivity.this, solaris.class);
        startActivity(b);
    }
    public void ijen (View view){
        Intent b = new Intent(MainActivity.this, ijen.class);
        startActivity(b);
    }


    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mengganti actionbar dengan toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //memanggil drawer_layout dari activity_main.xml
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =
                findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //membuat hamburger icon pada toolbar dan animasinya
        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //membuat default navigation menu select
        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HotelFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_hotels);
        }

    }
    //drawer menu fragment handler
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_hotels:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HotelFragment()).commit();
                break;
            case R.id.nav_whishlist:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WhishlistFragment()).commit();
                break;
            case R.id.nav_profile:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_notification:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NotifFragment()).commit();
                break;
            case R.id.nav_ItemManage:
                Intent i = new Intent(this,ManageItem.class);
                startActivity(i);
                break;
            case R.id.nav_nonton:
                Intent a = new Intent(this,MovieListActivity.class);
                startActivity(a);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }
    //on back press behavior
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


}

