package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

import java.util.List;

public class EditActivity extends AppCompatActivity {

    Student student;
    public String name;
    public String id;
    public String address;
    public String phone;
    public String avatarUrl;
    public Boolean cb;
    Intent intent;

    List<Student> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Button save_button = findViewById(R.id.changestudent_save_btn);
        Button cancel_button = findViewById(R.id.changestudent_cancell_btn);
        Button delete_button = findViewById(R.id.changestudent_delete_btn);


        EditText name_text = findViewById(R.id.changestudent_name_et);
        EditText id_text = findViewById(R.id.changestudent_id_et);
        EditText address_text = findViewById(R.id.changestudent_address_et);
        EditText phone_text = findViewById(R.id.changestudent_phone_et);
        CheckBox checkBox_text = findViewById(R.id.changestudent_checkBox);
        ImageView avatar_text = findViewById(R.id.changestudent_avatar_img);


        data = Model.instance().getAllStudents();

        Bundle extra = getIntent().getExtras();
        int i = extra.getInt("pos");

        Student st = data.get(i);

        name_text.setText(st.name);
        id_text.setText(st.id);
        address_text.setText(st.address);
        phone_text.setText(st.phone);
        checkBox_text.setChecked(st.cb);

        intent = new Intent(this, StudentRecyclerList.class);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               st.name= name_text.getText().toString();
               st.id= id_text.getText().toString();
               st.address= address_text.getText().toString();
               st.phone= phone_text.getText().toString();
               st.cb=checkBox_text.isChecked();
               startActivity(intent);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               delete(i);
            }
        });

    }

    private void delete(int i) {
        data.remove(i);
        startActivity(intent);
    }


}