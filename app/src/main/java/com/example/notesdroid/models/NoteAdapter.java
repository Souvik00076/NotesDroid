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
        NoteHolder holder = new NoteHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteHolder holder, int position) {
        String title = list.get(position).getTitle();
        String description = list.get(position).getDescription();
        holder.titleView.setText(title);
        holder.descriptionView.setText(description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        public TextView titleView, descriptionView;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title_id);
            descriptionView = itemView.findViewById(R.id.description_id);
        }
    }
}
