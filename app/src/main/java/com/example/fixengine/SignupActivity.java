package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.fixengine.model.TradeDetails;
import com.example.fixengine.services.RestSignupLoginService;

public class SignupActivity extends AppCompatActivity {
    private Button signupButton;
    private RestSignupLoginService restSignupLoginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup );
        restSignupLoginService = new RestSignupLoginService();
        signupButton = findViewById( R.id.signUPButton );
        signupActivity();
        cancleSignup();
    }

    public void signupActivity() {
        signupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String traderId = ((EditText) findViewById( R.id.textTraderId )).getText().toString().trim();
                String traderEmailId = ((EditText) findViewById( R.id.textEmailId )).getText().toString().trim();
                String traderPassword = ((EditText) findViewById( R.id.textPassword )).getText().toString().trim();
                RadioButton brokerRadiobutton = findViewById(R.id.brokerRadioButton);
                RadioButton traderRadiobutton = findViewById(R.id.traderRadioButton);
                String loginRole = "";
                if (brokerRadiobutton.isChecked()) {
                    loginRole = "Broker";
                } else if (traderRadiobutton.isChecked()) {
                    loginRole = "Trader";
                }
                TradeDetails tradeDetails = new TradeDetails(traderId, traderEmailId,
                        traderPassword, loginRole);
                if (traderId.isEmpty() || traderEmailId.isEmpty() || traderPassword.isEmpty() ||
                        loginRole.isEmpty() || loginRole.isEmpty()) {
                    Toast.makeText( SignupActivity.this, "Please complete all fields " +
                            "for signup.", Toast.LENGTH_SHORT).show();
                } else {
                    restSignupLoginService.signup( tradeDetails, SignupActivity.this );
                }
            }
        } );
    }

    public void cancleSignup() {
        Button cancel = findViewById( R.id.cancelSignuputton );
        cancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancleSignupIntent = new Intent(SignupActivity.this, MainActivityPage.class);
                startActivity( cancleSignupIntent );
            }
        } );
    }

}