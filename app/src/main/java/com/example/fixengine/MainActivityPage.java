package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fixengine.services.RestSignupLoginService;


public class MainActivityPage extends AppCompatActivity {
    private RestSignupLoginService restSignupLoginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_page );
        restSignupLoginService = new RestSignupLoginService();
        signupPage();
        loginPage();

    }

    private  void signupPage() {
        Button signupButton = findViewById( R.id.signUpMainPagebutton );
        signupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent( MainActivityPage.this, SignupActivity.class);
                startActivity( mainActivityIntent );
            }

        } );
    }

    private void loginPage() {
        Button loginButton = findViewById( R.id.loginButton );
        EditText emailEditText = findViewById( R.id.emailIdEditText);
        EditText passwordEditTest = findViewById( R.id.passwordEdittext);
        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailIdValue = emailEditText.getText().toString();
                String passwordValue = passwordEditTest.getText().toString();
                if(emailIdValue.isEmpty() || passwordValue.isEmpty()) {
                    Toast.makeText( MainActivityPage.this,
                            "please provide correct credentials.", Toast.LENGTH_LONG).show();
                } else {
                    String userInput = emailIdValue + ":" + passwordValue;
                    String authHeaderString = "Basic " + Base64.encodeToString( userInput.getBytes(), Base64.NO_WRAP );
                    restSignupLoginService.login( authHeaderString, MainActivityPage.this );
                }
            }
        } );
    }

}