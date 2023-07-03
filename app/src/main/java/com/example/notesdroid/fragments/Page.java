package com.example.notesdroid.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.notesdroid.R;

public class Page extends Fragment {

    private EditText descriptEt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page, container, false);

        init(root);//profile change error resolved
        descriptEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    //update the firebase
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return root;
    }

    private void init(final View root) {
        descriptEt = root.findViewById(R.id.description_et);
    }

}