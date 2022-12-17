package com.example.studentlist.model;

public class Student {
    public String name;
    public String id;
    public String address;
    public String phone;
    public String avatarUrl;
    public Boolean cb;

    public Student(String name, String id, String address, String phone, String avatarUrl, Boolean cb) {
        this.name = name;
        this.id = id;
        this.address=address;
        this.phone=phone;
        this.avatarUrl = avatarUrl;
        this.cb = cb;
    }
}
