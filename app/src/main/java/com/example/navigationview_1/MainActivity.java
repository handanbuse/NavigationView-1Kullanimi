package com.example.navigationview_1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mdrawer;
    private NavigationView mNav;
    private Toolbar mtoolbar;
    private ActionBarDrawerToggle mtoggle;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private PersonFragment personFragment;
    private ExitFragment exitFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdrawer = findViewById(R.id.mainActivity_drawerLayout);
        mNav = findViewById(R.id.mainActivity_navigationview);
        mtoolbar = findViewById(R.id.mainActivity_toolbar);

        setSupportActionBar(mtoolbar);

        homeFragment= new HomeFragment();
        searchFragment= new SearchFragment();
        personFragment= new PersonFragment();
        exitFragment= new ExitFragment();

        mNav.getMenu().findItem(R.id.navMenu_fragment1).setChecked(true);

        mtoggle = new ActionBarDrawerToggle(this, mdrawer, mtoolbar, R.string.nav_open, R.string.nav_close);
        mdrawer.addDrawerListener(mtoggle);
        mtoggle.syncState();

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navMenu_fragment1) {
                    setFragment(homeFragment);
                    mdrawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                else if (item.getItemId() == R.id.navMenu_fragment2) {
                    setFragment(personFragment);
                    mdrawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                else if (item.getItemId() == R.id.navMenu_fragment3) {
                    setFragment(searchFragment);

                    mdrawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                else if (item.getItemId() == R.id.navMenu_fragment4) {
                    setFragment(exitFragment);
                    mdrawer.closeDrawer(GravityCompat.START);
                    return true;
                }



                else return false;

            }
        });




    }
    private  void setFragment(Fragment fragment){
        // fragmentleri içerisine ekle
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainActivity_frame, fragment);
        transaction.commit();
    }

}