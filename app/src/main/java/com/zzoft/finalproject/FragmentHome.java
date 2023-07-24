package com.zzoft.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    ImageSlider imageSlider;
    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_home, container, false);
     imageSlider = view.findViewById(R.id.slide);
        ArrayList<SlideModel> slideModels= new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.harry));
        slideModels.add(new SlideModel(R.drawable.harry_azkabanz));
        imageSlider.setImageList(slideModels,false );

        return view;
    }
}