package Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.services.sonata.food.e.efoodfoodie.R;

import Fragments.SearchFragment;
import Library.Systems;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Systems systems = new Systems(this);
        //Anadiendo ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_open);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new SearchFragment());
        fragmentTransaction.commit();
        //getSupportActionBar().setTitle(R.string.travel_fragment);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case 1:
                        //getTravelFragment();
                        break;

                    case 2:
                        //getTravelsFragment();
                        break;

                    case 3:
                        ///getPathsFragment();
                        break;

                    case 4:
                        //getHelpFragment();
                        break;
                }
                return true;
            }
        });
//
//        View v = navigationView.getHeaderView(0);
//        //Colocando nombre de usuario y correo
//        TextView nick = (TextView) v.findViewById(R.id.txv_nickname);
//        nick.setText(V.usuario.getNickname());
//        TextView email = (TextView) v.findViewById(R.id.txv_email);
//        email.setText(V.usuario.getEmail());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }
}
