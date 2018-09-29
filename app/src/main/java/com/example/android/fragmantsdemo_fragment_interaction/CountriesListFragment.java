package com.example.android.fragmantsdemo_fragment_interaction;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Objects;

import static com.example.android.fragmantsdemo_fragment_interaction.FragmentActionListener.ACTION_COUNTRY_CLIKED;
import static com.example.android.fragmantsdemo_fragment_interaction.FragmentActionListener.ACTION_KEY;
import static com.example.android.fragmantsdemo_fragment_interaction.FragmentActionListener.COUNTRY_NAME_KEY;

public class CountriesListFragment extends Fragment {

    public View rootView;
    public String[] countries;
    FragmentActionListener mCallBack;

    String countryName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_countries, container, false);


        countries = getResources().getStringArray(R.array.countries);


        ListView lv = rootView.findViewById(R.id.countriesList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                countries);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                countryName = countries[position];

                Bundle bundle = new Bundle();
                bundle.putInt(ACTION_KEY, ACTION_COUNTRY_CLIKED); // save the action undertaken
                bundle.putString(COUNTRY_NAME_KEY, countryName); // save the country that was clicked

                mCallBack.onActionPerformed(bundle);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getActivity()).setTitle("Select Country");
        }
        super.onResume();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentActionListener) {
            mCallBack = (FragmentActionListener) context;
        } else {
            throw new ClassCastException("WTF!");
        }
    }
}
