package com.example.notesdroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesdroid.R;
import com.example.notesdroid.models.Note;
import com.example.notesdroid.models.NoteAdapter;

import java.util.ArrayList;

public class MainPage extends Fragment {

    private RecyclerView noteView;
    private NoteAdapter adapter;
    private ArrayList<Note> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_page, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        noteView = root.findViewById(R.id.notes_view);
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Note("sdhfksd", "jsdhfkjhsadkjfh", "kadsjhfkasdhf"));
        }
        adapter = new NoteAdapter(list);
        noteView.setAdapter(adapter);
        noteView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}