package com.amotie.fashon.ui.SignUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.amotie.fashon.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity implements TextView.OnEditorActionListener {
    TextInputLayout usernameLayout,emailLayout,passwordLayout,confermPasswordLayout;
    TextInputEditText usernameEdit,emailEdit,passwordEdit,confermPasswordEdit;
    SignUpViewModel signUpViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        usernameLayout=(TextInputLayout) findViewById(R.id.usernamelayout);
        emailLayout=(TextInputLayout) findViewById(R.id.emailLayout);
        passwordLayout=(TextInputLayout) findViewById(R.id.passwordlayout);
        confermPasswordLayout=(TextInputLayout) findViewById(R.id.passwordConfermLayout);
        usernameEdit=(TextInputEditText)findViewById(R.id.usernameEditText);
        emailEdit=(TextInputEditText)findViewById(R.id.emailEditText);
        passwordEdit=(TextInputEditText)findViewById(R.id.passwordEdit);
        confermPasswordEdit=(TextInputEditText)findViewById(R.id.passwordConfermEdit);
        usernameEdit.setOnEditorActionListener(this);
        emailEdit.setOnEditorActionListener(this);
        passwordEdit.setOnEditorActionListener(this);
        confermPasswordEdit.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()){
            case R.id.usernameEditText:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.validateUsername(usernameEdit.getText().toString())){
                        usernameLayout.setErrorEnabled(false);
                    }
                    else {
                        usernameLayout.setError(getText(R.string.usernameNotValide));
                    }
                }
                break;
            case R.id.emailEditText:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.validateEmail(emailEdit.getText().toString())){
                        emailLayout.setErrorEnabled(false);
                    }
                    else {
                        emailLayout.setError(getText(R.string.EmailisNotValid));
                    }
                }
                break;
            case R.id.passwordEdit:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.validatePassword(passwordEdit.getText().toString())){
                        passwordLayout.setErrorEnabled(false);
                    }
                    else{
                        passwordLayout.setError(getText(R.string.passwordNotValide));
                    }
                    confermPasswordLayout.requestFocus();
                    break;
                }
            case R.id.passwordConfermEdit:
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    if (signUpViewModel.validatePasswordConfirm(passwordEdit.getText().toString(),confermPasswordEdit.getText().toString())){
                        confermPasswordLayout.setErrorEnabled(false);
                    }
                    else {
                        confermPasswordLayout.setError(getText(R.string.passwordNotValide));
                    }
                }
                break;

        }
        return false;
    }
    public void SignUp(View view) {
        if (signUpViewModel.validate(usernameEdit.getText().toString(),emailEdit.getText().toString()
        ,passwordEdit.getText().toString(),confermPasswordEdit.getText().toString())){

        }
        else{
            if ( signUpViewModel.validateUsername(usernameEdit.getText().toString())) {
                usernameLayout.setErrorEnabled(false);
            }else {
                usernameLayout.setError(getText(R.string.usernameNotValide));
            }
            if ( signUpViewModel.validateEmail(emailEdit.getText().toString())) {
                emailLayout.setErrorEnabled(false);
            }else {
                emailLayout.setError(getText(R.string.EmailisNotValid));
            }
            if ( signUpViewModel.validatePassword(passwordEdit.getText().toString())) {
                passwordLayout.setErrorEnabled(false);
            }else
            {
                passwordLayout.setError(getText(R.string.passwordNotValide));
            }
            if ( signUpViewModel.validatePasswordConfirm(passwordEdit.getText().toString(),confermPasswordEdit.getText().toString())) {
                confermPasswordLayout.setErrorEnabled(false);
            }else{
                confermPasswordLayout.setError(getText(R.string.passwordNotValide));
            }
        }
    }
}


