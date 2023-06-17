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
import android.widget.Toast;

import com.example.notesdroid.R;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends Fragment {
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    TextView loginNow;

    //TODO 1 : DEFINE THE XML ELEMENTS HERE.-> Done
    //TODO 2 : DEFINE THE ON CLICK LISTENER INSIDE ONCREATEVIEW. -> Done
    //TODO 3: DEFINE A FUNCTION CALLED VALIDITY CHECK THAT TAKES EMAIL,PASSWORD, AND CONFIRM PASSWORD AND CHECK WHETHER THEY ARE VALID OR NOT
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // Initialize the views and Firebase instances
        emailEditText = view.findViewById(R.id.email_et);
        passwordEditText = view.findViewById(R.id.password_et);
        confirmPasswordEditText = view.findViewById(R.id.password_confirm);
        Button signupButton = view.findViewById(R.id.signUp_button);
        mAuth = FirebaseAuth.getInstance();
        progressBar = view.findViewById(R.id.progressBar);
        loginNow = view.findViewById(R.id.loginNow);


        loginNow.setOnClickListener(view1 -> {

        });


        // Set onClickListener for the signup button
        signupButton.setOnClickListener(v -> {
            // Get the email, password, and confirm password values from input fields
            progressBar.setVisibility(View.VISIBLE);
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            // Perform validation checks on the input fields
            if (email.isEmpty()) {
                emailEditText.setError("Email cannot be empty");
                return;
            }

            if (password.isEmpty()) {
                passwordEditText.setError("Password cannot be empty");
                return;
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordEditText.setError("Confirm password cannot be empty");
                return;
            }

            if (!password.equals(confirmPassword)) {
                confirmPasswordEditText.setError("Passwords do not match");
                return;
            }


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(requireContext(), "Account created.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(requireContext(), "Authentication Failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
        return view;
    }
}