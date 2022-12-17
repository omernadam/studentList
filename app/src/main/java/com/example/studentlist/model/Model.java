package com.example.studentlist.model;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }

    private Model(){
//        for(int i=0;i<20;i++){
//            addNewStudent(new Student("name " + i,""+i,"fff","ffff","test",false));
//        }
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addNewStudent(Student st){
        data.add(st);
    }


}
