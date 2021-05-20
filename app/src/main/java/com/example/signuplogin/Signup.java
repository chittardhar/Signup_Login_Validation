package com.example.signuplogin;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Signup extends Fragment {
    EditText editTextEmail,editTextPassword,editTextRptPassword,editTextUserName;
    View view;
    Context context;
    CheckBox checkBoxAccept;
    Button signup;
    TextView terms;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_signup,container,false);
        init(this.view);
        return view;
    }
    void init(View view){
        editTextEmail = view.findViewById(R.id.signupTextEmail);
        editTextPassword= view.findViewById(R.id.signupTextPassword);
        editTextRptPassword = view.findViewById(R.id.signupTextRptPassword);
        checkBoxAccept = view.findViewById(R.id.checkbox_accept);
        editTextUserName = view.findViewById(R.id.signupTextUser);
        context = view.getContext();
        terms = view.findViewById(R.id.term_and_condition);
        signup = view.findViewById(R.id.buttonSignUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String passwrod = editTextPassword.getText().toString();
                String userName = editTextUserName.getText().toString();
                if(email.isEmpty() || passwrod.isEmpty() || userName.isEmpty() || !checkBoxAccept.isChecked()){
                    Toast.makeText(context,"Please Complete all input fields",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"Available Soon.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Available soon",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void signUp(View view){

    }

}