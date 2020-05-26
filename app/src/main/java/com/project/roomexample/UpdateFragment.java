package com.project.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    EditText studId,studName,studEmail;
    Button btnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        studId=view.findViewById(R.id.edit_student_id);
        studName=view.findViewById(R.id.edit_student_name);
        studEmail=view.findViewById(R.id.edit_student_email);
        btnUpdate = view.findViewById(R.id.update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(studId.getText().toString());
                String name = studName.getText().toString();
                String email = studEmail.getText().toString();

                //create Student object
                Student student = new Student();
                student.setStudentID(id);
                student.setStudentName(name);
                student.setStudentEmail(email);


                //update student details
                int count = MainActivity.studentDatabase.studentDAO().updateStudent(student);
                if (count > 0) {
                    Toast.makeText(getActivity(), "Student ID:" + id + " info is updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "No Student with ID " + id + " in the database.", Toast.LENGTH_SHORT).show();
                }

                //clear edit text fields
                studId.setText("");
                studName.setText("");
                studEmail.setText("");
            }
        });
        return view;

    }
}
