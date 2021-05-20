package com.example.signuplogin;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends Fragment {
    Context context;
    View view;
    EditText editTextSignInEmail , editTextSignInPwd;
    Button signin;
    TextView forgotpwd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signin, container, false);
        signin = view.findViewById(R.id.buttonSignIn);
        init(view);

        return view;
    }
    void init(View view){
        editTextSignInEmail = view.findViewById(R.id.signinTextEmail);
        editTextSignInPwd = view.findViewById(R.id.signinTextPassword);
        context= view.getContext();
        forgotpwd = view.findViewById(R.id.forgot_password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    System.out.println("check 1");

                    System.out.println("check 2");
                    String email = editTextSignInEmail.getText().toString();
                    String passwrod = editTextSignInPwd.getText().toString();
                    System.out.println("check 3");
                    if(email.isEmpty() || passwrod.isEmpty()){
                        Toast.makeText(context,"Please Enter both input fields",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context,"Available Soon",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        });

        forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Available Soon",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void signIn(View view){

    }
}