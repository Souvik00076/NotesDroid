package com.example.notesdroid.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesdroid.MainActivity;
import com.example.notesdroid.R;
import com.example.notesdroid.models.Note;
import com.example.notesdroid.models.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainPage extends Fragment {

    private RecyclerView noteView;
    private NoteAdapter adapter;
    private ArrayList<Note> list;
    private FloatingActionButton addNotes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_page, container, false);
        init(root);
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.container,
                                new Page()).addToBackStack("Note Add")
                        .commit();
            }
        });
        return root;
    }

    private void init(View root) {
        list = new ArrayList<>();
        noteView = root.findViewById(R.id.notes_view);
        addNotes = root.findViewById(R.id.add_notes);

        adapter = new NoteAdapter(list);
        noteView.setAdapter(adapter);
        noteView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}