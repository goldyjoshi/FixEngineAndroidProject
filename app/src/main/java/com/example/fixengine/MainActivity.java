package com.example.fixengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textview;
    private ImageButton imageButton;
    ImageView imageView;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
//        imageButton = findViewById( R.id.imageButtonForMainPage );
//        imageButton.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent openMainPageIntent = new Intent( MainActivity.this, com.example.fixengine.MainActivityPage.class );
//                startActivity( openMainPageIntent );
//            }
//        } );
        fixEngineLogo();
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

    public void fixEngineLogo() {
        imageButton = findViewById( R.id.imageButtonForMainPage);
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainPageIntent = new Intent(MainActivity.this,com.example.fixengine.MainActivityPage.class);
                startActivity( mainPageIntent );
            }
        } );

    }
}