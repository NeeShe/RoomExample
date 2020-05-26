package com.project.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteFragment extends Fragment {

    private EditText studentId;
    private Button deleteBtn;


    public DeleteFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete, container, false);

        studentId=view.findViewById(R.id.student_id);
        deleteBtn=view.findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(studentId.getText().toString());
                Student student = new Student();

                //setting the student id as this is the primary key defined for this table
                student.setStudentID(id);

                //deleting the particular student data count >0 if at least 1 row is deleted
                int count =MainActivity.studentDatabase.studentDAO().deleteStudent(student);

                if (count > 0) {
                    Toast.makeText(getActivity(), "Student with ID:  " + id + " is removed from table successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "No Student's id is " + id, Toast.LENGTH_SHORT).show();
                }
                studentId.setText("");
            }
        });
        return view;
    }
}
