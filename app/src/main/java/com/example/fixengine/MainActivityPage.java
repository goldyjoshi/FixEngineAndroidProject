package com.example.fixengine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fixengine.services.RestSignupLoginService;

/***
 * This class is to represent the main activity of application
 *and have instructions to be executed at the apps launch.
 * @author vijayshreejoshi
 */
public class MainActivityPage extends AppCompatActivity {
    private RestSignupLoginService restSignupLoginService;
    private ImageView imageView; //Variable to store the image view.

    /***
     * Method get called when activity starts.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_page );
        restSignupLoginService = new RestSignupLoginService();
        signupPage();
        loginPage();
    }

    /***This method is used to signup in the system and override its onclick method, it intent
    * activity and  open new activity.
    */
    private void signupPage() {
        Button signupButton = findViewById( R.id.signUpMainPagebutton );
        signupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent( MainActivityPage.this, SignupActivity.class);
                startActivity( mainActivityIntent );
            }

        } );
    }

    /***This method is used to get login details and override method of setOnClickListener
     * to authenticate loin details if all fields are right otherwise login fail message will notify to user.
     */
    private void loginPage() {
        Button loginButton = findViewById( R.id.loginButton );
        EditText emailEditText = findViewById( R.id.emailIdEditText);
        EditText passwordEditTest = findViewById( R.id.passwordEdittext);
        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailIdValue = emailEditText.getText().toString().trim();
                String passwordValue = passwordEditTest.getText().toString().trim();
                if(emailIdValue.isEmpty() || passwordValue.isEmpty()) {
                    Toast.makeText( MainActivityPage.this,
                            "One of required credential is empty.", Toast.LENGTH_LONG).show();
                } else {
                    String userInput = emailIdValue + ":" + passwordValue;
                    String authHeaderString = "Basic " + Base64.encodeToString( userInput.getBytes(), Base64.NO_WRAP );
                    restSignupLoginService.login( authHeaderString, MainActivityPage.this );
                }
            }
        } );
    }

}