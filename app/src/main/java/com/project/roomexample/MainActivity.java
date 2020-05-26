package com.project.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static StudentDatabase studentDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize fragment manager
        fragmentManager = getSupportFragmentManager();

        //initialize database
        //using allowMainThreadQueries for the demo purpose otherwise database cannot be access
        //on the main thread as it may lock the UI , need to use other API such as async task
        //to allow database operation on separate thread

        studentDatabase = Room.databaseBuilder(getApplicationContext(),
                StudentDatabase.class,"studentsDb").allowMainThreadQueries().build();

        //add homeFragment to the MainActivity
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}
