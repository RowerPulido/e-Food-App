package com.services.sonata.food.e.efoodfoodie.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.services.sonata.food.e.efoodfoodie.R;


public class SearchFragment extends Fragment {

    /**
     * Attributes
     */
    private AutoCompleteTextView actSearchBar;

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    public void onButtonPressed(Uri uri) {
    }

    private void init() {

    }
}
