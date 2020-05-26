package com.project.roomexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
    Creating table (students_info) with three columns (id, name and email)
 */
@Entity (tableName = "students_info")
public class Student {
    @PrimaryKey
    @ColumnInfo (name= "student_id")
    private int studentID;

    @ColumnInfo (name= "name")
    private String studentName;

    @ColumnInfo (name= "email")
    private String studentEmail;


    //getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    //setter methods
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
