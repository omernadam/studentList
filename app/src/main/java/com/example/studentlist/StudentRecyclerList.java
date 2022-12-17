package com.example.studentlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        data = Model.instance().getAllStudents();
        FloatingActionButton addButton = findViewById(R.id.addStudentButton);



        RecyclerView list = findViewById(R.id.studentrecycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = new Intent(this, AddNewStudent.class);
        Intent intent_student = new Intent(this, StudentDetailsActivity.class);



        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListner(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                intent_student.putExtra("pos", pos); //send position student data
                startActivity(intent_student);

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView idTv;

        CheckBox cb;
        public StudentViewHolder(@NonNull View itemView, OnItemClickListener listner) {
            super(itemView);

           nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
           idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
           cb = itemView.findViewById(R.id.studentlistrow_cb);
           CheckBox cb = itemView.findViewById(R.id.studentlistrow_cb);
           cb.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   int pos = (int)cb.getTag();
                   Student st = data.get(pos);
                   st.cb=cb.isChecked();
               }
           });

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   int pos = getAdapterPosition();
                   listner.onItemClick(pos);
               }
           });

        }

        public void bind(Student st, int pos) {
            nameTv.setText(st.name);
            idTv.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(pos);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder>{
        OnItemClickListener listener;
        void setOnItemClickListner(OnItemClickListener listener){
            this.listener=listener;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
                return new StudentViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
                Student st = data.get(position);
                holder.bind(st, position);
         }

        @Override
        public int getItemCount() {
            return data.size();
        }

    }

}