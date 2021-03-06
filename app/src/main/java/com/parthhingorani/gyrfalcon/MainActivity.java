package com.parthhingorani.gyrfalcon;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.parthhingorani.gyrfalcon.Bookings.BookingsFragment;
import com.parthhingorani.gyrfalcon.Flights.FlightsFragment;
import com.parthhingorani.gyrfalcon.Offers.OffersFragment;
import com.parthhingorani.gyrfalcon.Profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    //data structures
    BottomNavigationView navigation;

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            //load fragment on user's selection
            switch (item.getItemId()) {
                case R.id.navigation_flights:
                    fragment = new FlightsFragment();
                    break;

                case R.id.navigation_bookings:
                    fragment = new BookingsFragment();
                    break;

                case R.id.navigation_offers:
                    fragment = new OffersFragment();
                    break;

                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    break;
            }

            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new FlightsFragment());

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
