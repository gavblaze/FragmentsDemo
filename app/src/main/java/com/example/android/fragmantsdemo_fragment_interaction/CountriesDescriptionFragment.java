package com.example.android.fragmantsdemo_fragment_interaction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static com.example.android.fragmantsdemo_fragment_interaction.FragmentActionListener.COUNTRY_NAME_KEY;

public class CountriesDescriptionFragment extends Fragment {
    View rootView;
    TextView descriptionTextView;
    private static final String TAG = CountriesDescriptionFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_countries_description, container, false);
        descriptionTextView = rootView.findViewById(R.id.countriesDescription);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String country = null;
        if (getArguments() != null) {
            country = getArguments().getString(COUNTRY_NAME_KEY);
        }
        setDescription(country);
    }


    public void setDescription(String country) {

        switch (country) {
            case "Botswana":
                descriptionTextView.setText(R.string.Botswana);
                break;
            case "Lesotho":
                descriptionTextView.setText(R.string.Lesotho);
                break;
            case "Namibia":
                descriptionTextView.setText(R.string.Namibia);
                break;
            case "South Africa":
                descriptionTextView.setText(R.string.SouthAfrica);
                break;
            case "Swaziland":
                descriptionTextView.setText(R.string.Swaziland);
                break;
            case "Zimbabwe":
                descriptionTextView.setText(R.string.Zimbabwe);
                break;
            case "Angola":
                descriptionTextView.setText(R.string.Angola);
                break;
            default:
                descriptionTextView.setText(R.string.harare);

        }
    }
}
