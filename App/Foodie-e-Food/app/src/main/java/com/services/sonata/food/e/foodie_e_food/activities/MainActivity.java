package com.services.sonata.food.e.foodie_e_food.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.services.sonata.food.e.foodie_e_food.R;
import com.services.sonata.food.e.foodie_e_food.fragments.ActualOrdersFragment;
import com.services.sonata.food.e.foodie_e_food.fragments.HistoryFragment;
import com.services.sonata.food.e.foodie_e_food.fragments.SearchFragment;
import com.services.sonata.food.e.foodie_e_food.fragments.SettingsFragment;
import com.services.sonata.food.e.foodie_e_food.fragments.ShoppingCarFragment;
import com.services.sonata.food.e.foodie_e_food.variables.V;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar mToolbar;
    DrawerLayout mDrawer;
    NavigationView mNavigationView;
    FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        if (V.user != null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
            mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawer.setDrawerListener(toggle);
            toggle.syncState();

            mNavigationView = (NavigationView) findViewById(R.id.nav_view);
            mNavigationView.setNavigationItemSelectedListener(this);


            // Colocando datos de usuario
            View view = mNavigationView.getHeaderView(0);

            TextView txvVName = (TextView) view.findViewById(R.id.txv_user_name);
            txvVName.setText(V.user.getUsername());

            TextView txvMail = (TextView) view.findViewById(R.id.txv_user_mail);
            txvMail.setText(V.user.getEmail());

            ImageView imvUser = (ImageView) view.findViewById(R.id.imv_user_picture);
            imvUser.setImageDrawable(V.user.getPicture());

            init();
        } else {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void init() {
        mContainer = (FrameLayout) findViewById(R.id.frm_container);


        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frm_container, new SearchFragment());
        fragmentTransaction.commit();
        mNavigationView.getMenu().findItem(R.id.ite_buscar_comida).setChecked(true);
        mDrawer.closeDrawers();
        Toast.makeText(getApplicationContext(), "se crea", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentTransaction fragmentTransaction;
        switch (item.getItemId()) {
            case R.id.ite_buscar_comida:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frm_container, new SearchFragment());
                fragmentTransaction.commit();
                Toast.makeText(getApplicationContext(), "buscar comida", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ite_en_curso:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frm_container, new ActualOrdersFragment());
                fragmentTransaction.commit();
                Toast.makeText(getApplicationContext(), "en curso", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ite_historial:

                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frm_container, new HistoryFragment());
                fragmentTransaction.commit();
                Toast.makeText(getApplicationContext(), "historial", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ite_carrito_compras:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frm_container, new ShoppingCarFragment());
                fragmentTransaction.commit();

                Toast.makeText(getApplicationContext(), "carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ite_promociones:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frm_container, new ActualOrdersFragment());
                fragmentTransaction.commit();

                Toast.makeText(getApplicationContext(), "promociones", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ite_cuenta:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frm_container, new SettingsFragment());
                fragmentTransaction.commit();

                Toast.makeText(getApplicationContext(), "cuenta", Toast.LENGTH_SHORT).show();
                break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
