package com.example.notesdroid.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesdroid.R;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private ArrayList<Note> list;

    public NoteAdapter(ArrayList<Note> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NoteAdapter.NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_note, parent, false);
        return new NoteHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteHolder holder, int position) {

        String description = list.get(position).getDescription();
        //long time = Long.parseLong(list.get(position).getTime());
        holder.descriptionView.setText(description);
        holder.timeView.setText("7.12.12");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        public TextView descriptionView, timeView;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            descriptionView = itemView.findViewById(R.id.descript_tv);
            timeView = itemView.findViewById(R.id.time_tv);
        }
    }
}
