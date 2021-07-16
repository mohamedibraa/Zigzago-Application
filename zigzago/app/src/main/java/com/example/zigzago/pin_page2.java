package com.example.zigzago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pin_page2 extends AppCompatActivity {
    EditText Pin_cn;
    String confirm;
    Button enter;
    String Con_pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_page2);
        forget2 f = new forget2();
        Con_pin = f.getPinn();
        Pin_cn = (EditText) findViewById(R.id.confirmpin);

        enter = (Button) findViewById(R.id.check);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm = Pin_cn.getText().toString();

                if (confirm.equals(Con_pin)) {
                    Intent o = new Intent(pin_page2.this, ReSet1_pass2.class);
                    startActivity(o);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong PIN Please Check It And Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button b =(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(pin_page2.this,forget2.class);
                startActivity(i);
            }
        });
    }
}