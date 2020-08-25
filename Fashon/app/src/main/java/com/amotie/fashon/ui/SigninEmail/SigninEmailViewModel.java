package com.amotie.fashon.ui.SigninEmail;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class SigninEmailViewModel extends ViewModel {

    public boolean validateEmail(String email){

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //Email Matches
            Log.i("LoginViewModel","Done");
            return true;
        }
        else{
            //Email is Wrong

            Log.i("LoginViewModel","fleid");
            return false;
        }
    }
    public boolean validatePassword(String password){
        String passwordRagax= "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).{8,}";
        if (password.matches(passwordRagax)){
            //Password Matches
            return true;
        }
        else {
            //Password is Wrong
            return false;
        }
    }
    public boolean validate(String email,String password){
        if (validateEmail(email) && validatePassword(password)){
            return true;
        }
        return false;
    }
}
