package com.example.zigzago;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReSet1_pass2 extends AppCompatActivity {
    EditText Reset_password;
    Button btn;
    //String Re_Pass;
    DataBaseHelpe db;
    SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_set1_pass2);
        Reset_password= (EditText)findViewById(R.id.re);
        btn = (Button)findViewById(R.id.bbb);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( ! Reset_password.getText().toString().matches("[a-zA-Z0-9]{8,16}")){
                    //Toast.makeText(getApplicationContext(), "Please Enter a Valid Password", Toast.LENGTH_LONG).show();
                    Reset_password.setError("Please Enter a Valid Password of 8:16 characters ");

                }
                else {
                    String Re_Pass = Reset_password.getText().toString();
                    db = new DataBaseHelpe(getApplicationContext());
                    sql = db.getWritableDatabase();
                    db.resetpassword(Re_Pass, sql);
                    Toast.makeText(getApplicationContext(), "Password changed Successfully ", Toast.LENGTH_LONG).show();

                    Intent o = new Intent(ReSet1_pass2.this, Log_in.class);
                    forget2 f = new forget2();
                    f.finish();
                    pin_page2 p = new pin_page2();
                    p.finish();
                    startActivity(o);
                    finish();
                }

            }
        });
        Button b =(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        ReSet1_pass2.this,forget2.class);
                startActivity(i);
            }
        });

    }
}