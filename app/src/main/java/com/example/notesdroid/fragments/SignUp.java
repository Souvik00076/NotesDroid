package com.example.notesdroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesdroid.R;

public class SignUp extends Fragment {
    //TODO 1 : DEFINE THE XML ELEMENTS HERE.
    //TODO 2 : DEFINE THE ON CLICK LISTENER INSIDE ONCREATEVIEW.
    //TODO 3: DEFINE A FUNCTION CALLED VALIDITY CHECK THAT TAKES EMAIL,PASSWORD, AND CONFIRM PASSWORD AND CHECK WHETHER THEY ARE VALID OR NOT
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }
}