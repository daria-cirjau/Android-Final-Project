package com.google.androidfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.androidfinalproject.MallFragments.AfiParkingFragment;
import com.google.androidfinalproject.MallFragments.BaneasaParkingFragment;
import com.google.androidfinalproject.MallFragments.MegaMallParkingFragment;
import com.google.androidfinalproject.MallFragments.SunPlazaParkingFragment;
import com.google.androidfinalproject.NavigationFragments.AboutUs;
import com.google.androidfinalproject.NavigationFragments.ContactSupport;
import com.google.androidfinalproject.NavigationFragments.MainPageFragment;
import com.google.androidfinalproject.NavigationFragments.ProfileFragment;
import com.google.androidfinalproject.RecyclerView.RecentDestinationsListFragment;
import com.google.androidfinalproject.room.CustomerSupportActivity;
import com.google.androidfinalproject.room.CustomerSupportActivity;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    public String mallName;

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String MALL_NAME = "mallName";
    String name;
    String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new MainPageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_travel);
        }


        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        email = intent.getStringExtra("Email");

        View headerView = navigationView.getHeaderView(0);
        TextView viewNume = (TextView) headerView.findViewById(R.id.textViewNume);
        viewNume.setText(name);
        TextView viewEmail = (TextView) headerView.findViewById(R.id.textViewEmailNav);
        viewEmail.setText(email);

    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_profile:
            {
                Bundle bundle = new Bundle();
                bundle.putString(NAME, name);
                bundle.putString(EMAIL, email);
                ProfileFragment profileFragment = new ProfileFragment();
                profileFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        profileFragment).commit();
            }
                break;
            case R.id.nav_travel:
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new MainPageFragment()).commit();
            break;
            case R.id.recent:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new RecentDestinationsListFragment()).commit();
                break;

            case R.id.nav_support:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new ContactSupport()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new AboutUs()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
    } else {
        super.onBackPressed();
    }
}

    public void openSunPlazaParkFragmentOnClick(View view) {
        mallName = "Sun Plaza";
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new SunPlazaParkingFragment()).commit();
    }

    public void openFragmentMegaMallOnClick(View view) {
        mallName = "Mega Mall";
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new MegaMallParkingFragment()).commit();
    }

    public void openFragmentAfiOnClick(View view) {
        mallName = "Afi";
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new AfiParkingFragment()).commit();
    }

    public void openBaneasaFragmentOnClick(View view) {
        mallName = "Baneasa";
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new BaneasaParkingFragment()).commit();
    }

    public void reserveOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, ReserveActivity.class);
        intent.putExtra(MALL_NAME,mallName);
        startActivity(intent);
    }

    public void reserveOnClickRed(View view) {
        Toast.makeText(this, "Please choose another parking spot!", Toast.LENGTH_LONG).show();
    }

    public void saveChangesOnClick(){
        Toast.makeText(this, "Saved changes", Toast.LENGTH_LONG).show();
    }

    public void sendProblemOnClick(){
        EditText editTextName = findViewById(R.id.editTextTextPersonName);
        EditText editTextEmail = findViewById(R.id.editTextTextPersonEmail);
        EditText editTextProblem = findViewById(R.id.editTextTextMultiLine);

        Intent intent = new Intent(MainActivity.this, CustomerSupportActivity.class);
        intent.putExtra("Name",editTextName.getText().toString());
        intent.putExtra("Email",editTextEmail.getText().toString());
        intent.putExtra("Problem",editTextProblem.getText().toString());
        startActivity(intent);
    }


}