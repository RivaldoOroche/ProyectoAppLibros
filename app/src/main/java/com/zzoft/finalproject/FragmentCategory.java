package com.zzoft.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCategory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    adapter_category adapter_categoryy;
    adapter_category adapter_category2;
    ArrayList<item_category> item_categoriess;
    ArrayList<item_category> item_categories2;


    FirebaseFirestore db;
    public FragmentCategory() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCategory.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCategory newInstance(String param1, String param2) {
        FragmentCategory fragment = new FragmentCategory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_category, container, false);




        recyclerView= view.findViewById(R.id.reiclerr);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        db=FirebaseFirestore.getInstance();
        item_categoriess = new ArrayList<>();
        adapter_categoryy= new adapter_category(getActivity(), item_categoriess);
        recyclerView.setAdapter(adapter_categoryy);

        EvenChangeListenet();


        recyclerView2= view.findViewById(R.id.reiclerr2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        item_categories2 = new ArrayList<>();
        adapter_category2= new adapter_category(getActivity(), item_categories2);

        recyclerView2.setAdapter(adapter_category2);

        EvenChangeListenet2();
        return view;
    }
    private void EvenChangeListenet(){
        db.collection("novela").orderBy("autor", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error  != null){
                    Log.e("error db",error.getMessage());
                    return;
                }
                for (DocumentChange dc:value.getDocumentChanges()) {
                    if (dc.getType()==DocumentChange.Type.ADDED){
                        item_categoriess.add(dc.getDocument().toObject(item_category.class));
                    }
                    adapter_categoryy.notifyDataSetChanged();
                }
            }
        });
    }
    private void EvenChangeListenet2(){
        db.collection("historia").orderBy("autor", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error  != null){
                    Log.e("error db",error.getMessage());
                    return;
                }
                for (DocumentChange dc:value.getDocumentChanges()) {
                    if (dc.getType()==DocumentChange.Type.ADDED){
                        item_categories2.add(dc.getDocument().toObject(item_category.class));
                    }
                    adapter_category2.notifyDataSetChanged();
                }
            }
        });
    }
}