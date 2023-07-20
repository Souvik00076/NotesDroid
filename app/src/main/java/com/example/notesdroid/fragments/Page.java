package com.example.notesdroid.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.notesdroid.R;
import com.example.notesdroid.models.Note;
import com.example.notesdroid.models.UserCred;
import com.google.android.gms.tasks.OnSuccessListener;

public class Page extends Fragment {

    private EditText descriptEt;
    private AppCompatImageView buttonBack, buttonCheck;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page, container, false);

        init(root);//profile change error resolved
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String description = descriptEt.getText().toString();
                Note note = new Note(description, System.currentTimeMillis() / 1000);
                UserCred user = UserCred.getInstance();
                user.getReference().setValue(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        requireActivity().getSupportFragmentManager()
                                .popBackStack();
                    }
                });
            }
        });
        return root;
    }

    private void init(final View root) {

        descriptEt = root.findViewById(R.id.description_et);
        buttonBack = root.findViewById(R.id.button_back);
        buttonCheck = root.findViewById(R.id.button_check);
    }

}