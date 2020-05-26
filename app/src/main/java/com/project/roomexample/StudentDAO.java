package com.project.roomexample;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
    Data Access Object Interface - for all database operations
 */
@Dao
public interface StudentDAO {
    // Insert data
    @Insert
    public void addStudent(Student student);

    //read all data
    @Query("select * from students_info")
    public List<Student> getStudents();

    @Query("select COUNT(*) from students_info")
    int countStudents();

    /**delete an entity from table
     It uses the primary keys to find the entities to delete.
     can use return type int to get number of rows deleted
     */
    @Delete
    public int deleteStudent(Student student);

    /**update an entity in the table
    It uses a query that matches against the primary key of each entity.
     */
    @Update
    public int updateStudent(Student student);

    //search by Name
    @Query("select * from students_info where name LIKE  :Name")
    public List<Student> findByName(String Name);

    /** Returning subsets of columns as POJO -Plain old Java-based objects
     *
     */
    @Query("select name from students_info")
    public List<Name> loadOnlyName();

    /** You can also define this class in a separate file, as long as you add the
     "public" access modifier.
     */
    public class Name {
        @ColumnInfo(name = "name")
        public String name;
    }

}
