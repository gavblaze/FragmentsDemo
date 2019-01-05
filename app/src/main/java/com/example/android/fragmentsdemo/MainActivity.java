package com.example.android.fragmentsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addCountryListFragment();
        }
    }


    /*This is the method from our interface
     * we pass a bundle rather than the specific position as this is reusable*/

    @Override
    public void onActionPerformed(Bundle bundle) {

        // get the action that was performed
        int actionPerformed = bundle.getInt(ACTION_KEY);  // get the action that was performed - a click of the listview in this case
        String countryName = bundle.getString(COUNTRY_NAME_KEY); // get the country that was clicked


        switch (actionPerformed) {
            case ACTION_COUNTRY_CLIKED:
                addCountryDescriptionFragment(countryName);
                break;
            default:
                break;
        }
    }


    public void addCountryListFragment() {
        CountriesListFragment countriesListFragment = new CountriesListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, countriesListFragment)
                .commit();
    }


    public void addCountryDescriptionFragment(String countryName) {

        CountriesDescriptionFragment countryDescriptionFragment = new CountriesDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putString(COUNTRY_NAME_KEY, countryName);
        countryDescriptionFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, countryDescriptionFragment)
                .addToBackStack(null)
                .commit();
    }
}
