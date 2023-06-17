package com.example.notesdroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.notesdroid.R;

public class Login extends Fragment{

    private EditText emailEditText;
    private EditText passwordEditText;
    ProgressBar progressBar;
    private TextView registerNow;
    CallBack callBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailEditText = view.findViewById(R.id.email_et);
        passwordEditText = view.findViewById(R.id.password_et);
        Button loginButton = view.findViewById(R.id.login_button);
        progressBar=view.findViewById(R.id.progressBar);
        registerNow = view.findViewById(R.id.registerNow);


        registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack != null){
                    callBack.changeFragment();
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }

    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }

}