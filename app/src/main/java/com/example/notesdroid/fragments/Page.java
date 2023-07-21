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
import android.widget.Toast;

import com.example.notesdroid.R;
import com.example.notesdroid.models.Note;
import com.example.notesdroid.models.UserCred;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page extends Fragment {

    private EditText descriptEt;
    private AppCompatImageView buttonBack, buttonCheck;
    private DatabaseReference reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page, container, false);

        init(root);//profile change error resolved
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager()
                        .popBackStack();
            }
        });
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String description = descriptEt.getText().toString();
                if (description.isEmpty()) return;
                Note note = new Note(description);
                final String key = reference.push().getKey();
                reference.child(key).setValue(note).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) requireActivity().getSupportFragmentManager()
                                .popBackStack();
                        else
                            Toast.makeText(requireActivity(), "Something error happened", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return root;
    }

    private void init(final View root) {
        reference = FirebaseDatabase.getInstance().getReference
                (FirebaseAuth.getInstance().getCurrentUser().getEmail().replace(".", ""));
        descriptEt = root.findViewById(R.id.description_et);
        buttonBack = root.findViewById(R.id.button_back);
        buttonCheck = root.findViewById(R.id.button_check);
    }

}