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

public class StudentDetailsActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        data = Model.instance().getAllStudents();

        Button edit_button = findViewById(R.id.editstudent_edit_btn);

        TextView name_text = findViewById(R.id.editstudent_name_et);
        TextView id_text = findViewById(R.id.editstudent_id_et);
        TextView address_text = findViewById(R.id.editstudent_address_et);
        TextView phone_text = findViewById(R.id.editstudent_phone_et);
        CheckBox checkBox_text = findViewById(R.id.editstudent_checkBox);
        ImageView avatar_text = findViewById(R.id.editstudent_avatar_img);

        Bundle extra = getIntent().getExtras();
        int i = extra.getInt("pos");

        Student st = data.get(i);

        name_text.setText(st.name);
        id_text.setText(st.id);
        address_text.setText(st.address);
        phone_text.setText(st.phone);
        checkBox_text.setChecked(st.cb);

        Intent intent = new Intent(this,EditActivity.class);
        intent.putExtra("pos",i);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


        name_text.setText(name_text.getText());
    }
}