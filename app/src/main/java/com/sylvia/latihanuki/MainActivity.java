package com.sylvia.latihanuki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ToDo>list=new ArrayList<ToDo>();
    ToDoAdapter toDoAdapter;
    DatabaseHelper myDb;
    RecyclerView rvToDo;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        list.addAll(myDb.getAllData());
        rvToDo = findViewById(R.id.rvTodo);
        rvToDo.setLayoutManager(new LinearLayoutManager(this));
        toDoAdapter = new ToDoAdapter(MainActivity.this,list);
        toDoAdapter.notifyDataSetChanged();
        rvToDo.setAdapter(toDoAdapter);
        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddTodo.class));
            }
        });
    }
}