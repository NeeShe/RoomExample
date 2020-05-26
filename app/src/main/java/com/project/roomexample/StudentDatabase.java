package com.project.roomexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/*
    Database abstract class extending RoomDatabase
 */
@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    // abstract method that returns object of StudentDAO
    public abstract StudentDAO studentDAO();
}
