package com.project.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFragment extends Fragment {
    private EditText studentId, studentName, studentEmail;
    private Button btnSave;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        studentId = view.findViewById(R.id.et_std_id);
        studentName = view.findViewById(R.id.et_name);
        studentEmail = view.findViewById(R.id.et_email);
        btnSave = view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(studentId.getText().toString());
                String name = studentName.getText().toString();
                String email = studentEmail.getText().toString();

                //creating Student object
                Student student = new Student();
                student.setStudentID(id);
                student.setStudentName(name);
                student.setStudentEmail(email);

                //data insertion to database
                MainActivity.studentDatabase.studentDAO().addStudent(student);

                Toast.makeText(getActivity(),"Student added successfully",Toast.LENGTH_SHORT).show();

                //clear edit text fields
                studentId.setText("");
                studentName.setText("");
                studentEmail.setText("");

            }
        });
        return view;
    }
}
