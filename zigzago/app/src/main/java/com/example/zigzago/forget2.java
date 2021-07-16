package com.example.zigzago;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forget2 extends AppCompatActivity {
    private EditText email;
    private Button send;
    DataBaseHelpe dbh;
    SQLiteDatabase sql;
    public static String Pinn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget2);

        email = findViewById(R.id.gmail);
        send = findViewById(R.id.sendmail);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if( sendEmail()==true) {
                   Toast.makeText(getApplicationContext(), "Please Check Your Inbox", Toast.LENGTH_LONG).show();
                   Intent kk = new Intent(forget2.this, pin_page2.class);
                   startActivity(kk);
                   finish();

               }
               else
               {
                   Toast.makeText(getApplicationContext(), " Wrong Email ", Toast.LENGTH_LONG).show();
               }

            }
        });
        Button b =(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(forget2.this,Log_in.class);
                startActivity(i);
            }
        });

    }


    public static String getPinn() {
        return Pinn;
    }

    private boolean sendEmail() {

        String mEmail = email.getText().toString();
        dbh = new DataBaseHelpe(getApplicationContext());
        sql = dbh.getReadableDatabase();
        boolean flag =dbh.send_pin(mEmail, sql);

        if (flag==true) {
            //Pinn = cc.getString(3);
            String mSubject = "Reset Your Password";
            String mMessage = "The 4-digit Number to reset your password is  " + getPinn();
            JavaMailApi javaMailApi = new JavaMailApi(this, mEmail, mSubject, mMessage);
            javaMailApi.execute();

        }else
        {
            flag=false;
        }
     return flag;
    }
}







