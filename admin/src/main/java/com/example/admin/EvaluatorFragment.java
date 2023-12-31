package com.example.admin;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EvaluatorFragment extends Fragment {

    CardView addEvaluator, viewEvaluator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evalator, container, false);
        addEvaluator = view.findViewById(R.id.addEvaluator);
        addEvaluator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new AddEvaluatorFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        viewEvaluator = view.findViewById(R.id.viewEvaluator);
        viewEvaluator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new ViewEvaluatorFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}