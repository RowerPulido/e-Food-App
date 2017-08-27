package com.services.sonata.food.e.efoodfoodie.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.services.sonata.food.e.efoodfoodie.Fragments.ActualOrdersFragment;
import com.services.sonata.food.e.efoodfoodie.Fragments.HistoricalFragment;
import com.services.sonata.food.e.efoodfoodie.Fragments.SearchFragment;
import com.services.sonata.food.e.efoodfoodie.Fragments.ShoppingCarFragment;
import com.services.sonata.food.e.efoodfoodie.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    FragmentTransaction mFragmentTransaction;
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init propierties
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        //mActionBarDrawerToggle.syncState();

        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.main_container, new SearchFragment());
        mFragmentTransaction.commit();

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        mNavigationView.getMenu().getItem(0).setChecked(true);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ite_search_food:
                        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        mFragmentTransaction.replace(R.id.main_container, new SearchFragment());
                        mFragmentTransaction.commit();
                        mNavigationView.getMenu().findItem(R.id.ite_search_food);
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.ite_on_course:
                        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        mFragmentTransaction.replace(R.id.main_container, new ActualOrdersFragment());
                        mFragmentTransaction.commit();
                        mNavigationView.getMenu().findItem(R.id.ite_on_course);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.ite_historical:
                        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        mFragmentTransaction.replace(R.id.main_container, new HistoricalFragment());
                        mFragmentTransaction.commit();
                        mNavigationView.getMenu().findItem(R.id.ite_historical);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.ite_shopping_cart:
                        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        mFragmentTransaction.replace(R.id.main_container, new ShoppingCarFragment());
                        mFragmentTransaction.commit();
                        mNavigationView.getMenu().findItem(R.id.ite_shopping_cart);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.ite_promos:

                        break;
                    case R.id.ite_account:

                        break;
                }

                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

}
