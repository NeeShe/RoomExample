package com.project.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button addButton, viewButton, updateButton, deleteButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);

        //add buttons and set onClickListeners in this context
        addButton = view.findViewById(R.id.addButton);
        viewButton = view.findViewById(R.id.viewButton);
        updateButton = view.findViewById(R.id.updateButton);
        deleteButton = view.findViewById(R.id.deleteButton);


        addButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.viewButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ViewAllFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.deleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.updateButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
