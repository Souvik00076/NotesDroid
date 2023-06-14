package com.example.notesdroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesdroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Index extends Fragment {

    private RecyclerView contentView;
    private FloatingActionButton addNoteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_index, container, false);

        init(root);
        return root;
    }

    private void init(View root) {
        contentView = root.findViewById(R.id.note_recycler_view);
        addNoteButton = root.findViewById(R.id.addNotes);
    }
}