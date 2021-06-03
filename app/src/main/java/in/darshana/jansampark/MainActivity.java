package in.darshana.jansampark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import in.darshana.jansampark.fragments.AboutusFragment;
import in.darshana.jansampark.fragments.ComplaintFragment;
import in.darshana.jansampark.fragments.DashboardFragment;
import in.darshana.jansampark.fragments.ContactUsFragment;
import in.darshana.jansampark.fragments.GovSchemeFragment;
import in.darshana.jansampark.fragments.NewsFragment;
import in.darshana.jansampark.fragments.NotificationFragment;
import in.darshana.jansampark.fragments.ProfileFragment;
import in.darshana.jansampark.fragments.WorkFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    NavigationView mNavigationView;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    FrameLayout mFrameLayout;

    ImageView imageView;
    TextView textViewNavHeaderTitle,textViewNavHeaderSubtitle;
    View header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    private void init(){
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.home_drawerLayout);
        mNavigationView = findViewById(R.id.home_navigationView);
        mFrameLayout = findViewById(R.id.containerNew);

        //nav header code
        header = mNavigationView.inflateHeaderView(R.layout.nav_header_main);
        imageView = (ImageView) header.findViewById(R.id.imgProfile);
        textViewNavHeaderTitle = header.findViewById(R.id.nav_header_title);
        textViewNavHeaderSubtitle = header.findViewById(R.id.nav_header_subtitle);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        //original code starts
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //set default fragment
        loadDefaultFragment(new DashboardFragment());

        setNavigationDrawer();
    }

    private void loadDefaultFragment(Fragment fragment) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.containerNew,fragment);
        mFragmentTransaction.commit();
    }

    private void setNavigationDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                displaySelectedScreen(item.getItemId());
                return true;
            }
        });
    }

    private void displaySelectedScreen(int itemId) {
        Fragment mFragment = null;
        switch (itemId) {


                case R.id.nav_home:
                mFragment = new DashboardFragment();
                break;

                case R.id.nav_govSheme:
                mFragment = new GovSchemeFragment();
                break;

                case R.id.nav_complaint:
                mFragment = new ComplaintFragment();
                break;

                case R.id.nav_ourWork:
                mFragment = new WorkFragment();
                break;

                case R.id.nav_news:
                mFragment = new NewsFragment();
                break;

                case R.id.nav_aboutus:
                mFragment = new AboutusFragment();
                break;

                case R.id.nav_contactUs:
                mFragment = new ContactUsFragment();
                break;



        }
        //replacing the fragment
        if (mFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.containerNew, mFragment).addToBackStack("");
            ft.commit();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);


    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
          mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
        super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Fragment mFragment = null;
        int id = item.getItemId();

        switch (id){
            case R.id.action_notification:
                mFragment = new NotificationFragment();
                break;

            case R.id.action_profile:
                mFragment = new ProfileFragment();
                break;

        }

        if (mFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.containerNew, mFragment).addToBackStack("");
            ft.commit();
        }

        /*if (id == R.id.action_notification) {
            loadDefaultFragment(new NotificationFragment());
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}