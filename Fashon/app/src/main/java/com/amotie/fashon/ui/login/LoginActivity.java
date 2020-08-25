package com.amotie.fashon.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amotie.fashon.R;
import com.amotie.fashon.ui.SignUp.SignUpActivity;
import com.amotie.fashon.ui.SigninEmail.SigninEmailActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }
    public void SignUpwithEamil(View view){
        Intent intent=new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }
    public void SignIn(View view){
        Intent intent=new Intent(getApplicationContext(), SigninEmailActivity.class);
        startActivity(intent);
    }
}