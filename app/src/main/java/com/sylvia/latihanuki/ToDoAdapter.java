package com.sylvia.latihanuki;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
    Context context;
    List<ToDo> toDos;

    public ToDoAdapter(Context context, List<ToDo> toDos) {
        this.context = context;
        this.toDos = toDos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titletodo.setText(toDos.get(position).getTitletodo());
        holder.desctodo.setText(toDos.get(position).getDesctodo());
        holder.datetodo.setText(toDos.get(position).getDatetodo());

        String getTitleTodo = toDos.get(position).getTitletodo();
        String getDescTodo = toDos.get(position).getDesctodo();
        String getDateTodo = toDos.get(position).getDatetodo();
        String getIdTodo = toDos.get(position).getIdtodo();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,EditTodo.class);
                i.putExtra("titletodo",getTitleTodo);
                i.putExtra("desctodo",getDescTodo);
                i.putExtra("datetodo",getDateTodo);
                i.putExtra("idtodo",getIdTodo);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titletodo, desctodo, datetodo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titletodo = (TextView)itemView.findViewById(R.id.tittletodo);
            desctodo = (TextView)itemView.findViewById(R.id.desctodo);
            datetodo = (TextView)itemView.findViewById(R.id.datetodo);
        }
    }
}
