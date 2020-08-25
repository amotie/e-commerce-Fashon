package com.amotie.fashon.ui.SigninEmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.amotie.fashon.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class SigninEmailActivity extends AppCompatActivity implements TextView.OnEditorActionListener{
    SigninEmailViewModel signinEmailViewModel;
    TextInputLayout email,password;
    TextInputEditText emailEditText,passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_email);
        getSupportActionBar().hide();
        signinEmailViewModel = ViewModelProviders.of(this).get(SigninEmailViewModel.class);
        email=(TextInputLayout)findViewById(R.id.emailLayout);
        password=(TextInputLayout)findViewById(R.id.passwordlayout);
        emailEditText=(TextInputEditText)findViewById(R.id.emailEditText);
        passwordEditText=(TextInputEditText)findViewById(R.id.passwordEdit);
        emailEditText.setOnEditorActionListener(this);
        passwordEditText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()){
            case R.id.emailEditText:
                Log.i("main","email");
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    if (signinEmailViewModel.validateEmail(emailEditText.getText().toString())){
                        email.setErrorEnabled(false);
                    }
                    else{
                        email.setError(getText(R.string.EmailisNotValid));
                    }

                }

            case R.id.passwordEdit:
                Log.i("main","password");
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (signinEmailViewModel.validatePassword(passwordEditText.getText().toString())){
                        password.setErrorEnabled(false);
                        Login(v);
                    }
                    else{
                        password.setError(getText(R.string.PasswordisNotValid));
                    }

                }

    }
        return false;
    }
    public void Login(View view){
        if (signinEmailViewModel.validate(emailEditText.getText().toString(),passwordEditText.getText().toString())){
            email.setErrorEnabled(false);
            password.setErrorEnabled(false);
//            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(intent);
        }
        else{
            if (signinEmailViewModel.validateEmail(emailEditText.getText().toString())){
                email.setErrorEnabled(false);
            }
            else{
                email.setError(getText(R.string.EmailisNotValid));
            }
            if (signinEmailViewModel.validatePassword(passwordEditText.getText().toString())){
                password.setErrorEnabled(false);

            }
            else{
                password.setError(getText(R.string.PasswordisNotValid));
            }
        }
    }

}