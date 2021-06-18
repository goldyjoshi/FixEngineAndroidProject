package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityPage extends AppCompatActivity {
    private Button signupButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_page );
        signupPage();
        loginPage();
    }

    private  void signupPage() {
        signupButton = findViewById( R.id.signUpMainPagebutton );
        signupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mainActivityIntent = new Intent( MainActivityPage.this, SignupActivity.class);
//                startActivity( mainActivityIntent );
                Intent mainActivityIntent = new Intent( MainActivityPage.this, SubmitOrderActivity.class);
                startActivity( mainActivityIntent );
            }

        } );
    }

    private void loginPage() {
        loginButton = findViewById( R.id.loginButton );
        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivityPage.this,TradeOptionStatusPortofolioActivity.class);
                startActivity( loginIntent );
            }
        } );
    }
}