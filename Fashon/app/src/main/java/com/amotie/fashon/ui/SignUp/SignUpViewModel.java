package com.amotie.fashon.ui.SignUp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {
    public boolean validateUsername(String username){
        if (username.matches("[a-zA-Z\\s]+")){
            return true;
        }
        else{
            return false;
        }
    }
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
    public boolean validatePasswordConfirm(String password,String confirmPassword){
        if (!confirmPassword.isEmpty()) {
            if (password.equals(confirmPassword)) {
                Log.i("SIGNUP","TRUE");
                return true;

            } else {
                Log.i("SIGNUP","FALSE");
                return false;
            }
        }
        else {
            Log.i("SIGNUP","FALSEALL");
            return false;
        }
    }
    public boolean validate(String username, String email, String password,String confirmPassword){
        if (validateUsername(username) &&  validateEmail(email)
                && validatePassword(password) && validatePasswordConfirm(password,confirmPassword)){
            return true;
        }
        else{
            return false;
        }

    }
}
