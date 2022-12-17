package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

public class AddNewStudent extends AppCompatActivity {

    Student student;
    public String name;
    public String id;
    public String address;
    public String phone;
    public String avatarUrl;
    public Boolean cb;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        Button save_button = findViewById(R.id.addstudent_save_btn);
        Button cancel_button = findViewById(R.id.addstudent_cancell_btn);

        EditText name_text = findViewById(R.id.addstudent_name_et);
        EditText id_text = findViewById(R.id.addstudent_id_et);
        EditText address_text = findViewById(R.id.addstudent_address_et);
        EditText phone_text = findViewById(R.id.addstudent_phone_et);
        CheckBox checkBox_text = findViewById(R.id.addstudent_checkBox);
        ImageView avatar_text = findViewById(R.id.addstudent_avatar_img);

        intent = new Intent(this, StudentRecyclerList.class);


        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = String.valueOf(name_text.getText());
                id = String.valueOf(id_text.getText());
                address = String.valueOf(address_text.getText());
                phone = String.valueOf(phone_text.getText());
                cb = checkBox_text.isChecked();
                avatarUrl = String.valueOf(avatar_text.getId());
                student = new Student(name,id,address,phone,avatarUrl,cb);
                Model.instance().addNewStudent(student);

                startActivity(intent);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}