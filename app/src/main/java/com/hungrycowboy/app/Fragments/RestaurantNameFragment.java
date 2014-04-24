package com.hungrycowboy.app.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hungrycowboy.app.R;

/**
 * Created by kylealanr on 4/23/14.
 */
public class RestaurantNameFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.category, container, false);
        return view;
    }
}
