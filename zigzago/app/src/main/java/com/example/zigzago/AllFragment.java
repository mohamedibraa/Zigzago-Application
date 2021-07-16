package com.example.zigzago;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AllFragment extends Fragment {
/*
    private RecyclerView mRecyclerView;
    private ExambleAdapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

 */

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AllFragment newInstance(String param1, String param2) {
        AllFragment fragment = new AllFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false);

        /*
        View v= inflater.inflate(R.layout.fragment_all, container, false);
        ArrayList<Item> menu =new ArrayList<>();
       menu.add(new Item(R.drawable.cheeseonionrings351,"cheese on ionrings",35f));
       menu.add(new Item(R.drawable.cheesygarlicbread252,"cheesy garlic bread",25f));
       menu.add(new Item(R.drawable.chickenwings323,"chicken wings",40f));


        mRecyclerView=(RecyclerView)v.findViewById(R.id.allRecycleView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter=new ExambleAdapter(menu,getActivity());
        mlayoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

         return  v;

         */

    }
    /*
    public void AddnewItem(int img,String name,float price )
    {
        Item examble =new Item();
        examble.setImageRes(img);
        examble.setName(name);
        examble.setPrice(price);
        mAdapter

    }

     */

}