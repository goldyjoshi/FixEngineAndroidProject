package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fixengine.services.RestTradeService;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    private TextView textview;
    private ImageButton imageButton;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        imageButton = findViewById( R.id.imageButton );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMainPageIntent = new Intent( MainActivity.this, com.example.fixengine.MainActivityPage.class );
                startActivity( openMainPageIntent );
            }
        } );
////        textview = findViewById(R.id.tradeTextView );
//        RestTradeService restTradeService = new RestTradeService();
//        String status = restTradeService.submitTrade();
//        Toast.makeText(this, status,Toast.LENGTH_SHORT).show();
//        String trades = restTradeService.getTradeService();
////        textview.setText(trades);
//       Intent signupIntent = new Intent(this,SignupActivity.class);
//       startActivity(signupIntent);
//    }
    }
}