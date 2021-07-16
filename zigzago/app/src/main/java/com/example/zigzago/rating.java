package com.example.zigzago;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        final Button r = (Button) findViewById(R.id.rate);
        final RatingBar rb = (RatingBar) findViewById(R.id.ratingbar);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rate = rb.getRating();
                if (rate != 0) {
                    Toast.makeText(getApplicationContext(), "Thank You For Rating", Toast.LENGTH_LONG).show();
                    NextActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Rate Application First", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void NextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(rating.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }
}

