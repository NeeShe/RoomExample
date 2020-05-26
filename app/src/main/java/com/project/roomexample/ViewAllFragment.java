package com.project.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewAllFragment extends Fragment {

    private TextView txtInfo;

    public ViewAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_all, container, false);
        txtInfo = view.findViewById(R.id.txt_display_info);

        //reading from database
        List<Student> students = MainActivity.studentDatabase.studentDAO().getStudents();
        String info = "";

        //append each student info from the list to text view
        for(Student student:students){
            int id = student.getStudentID();
            String name = student.getStudentName();
            String email = student.getStudentEmail();
            info = info+"\n\n"+"Id:"+id+"\n Name: " + name+"\n"+"Email :"+email;
        }
        //check if there is atleast one student info in the table
        if (info.isEmpty()) {
            info = "No student info saved in the database so far!";
        }
        txtInfo.setText(info);
        return view;
    }
}
