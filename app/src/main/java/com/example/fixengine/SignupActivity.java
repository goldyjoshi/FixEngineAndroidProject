package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        signupButton = findViewById(R.id.signUPButton);

        signupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String traderId = ((EditText) findViewById(R.id.textTraderId)).getText().toString();
                String traderEmailId = ((EditText) findViewById(R.id.textEmailId)).getText().toString();
                String traderPassword = ((EditText) findViewById(R.id.textPassword)).getText().toString();

                TradeDetails tradeDetails = new TradeDetails(traderId, traderEmailId, traderPassword);
                restSignupLoginService.signup(tradeDetails);


            }
        } );
    }
}