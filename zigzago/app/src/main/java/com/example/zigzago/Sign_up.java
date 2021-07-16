package com.example.zigzago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Sign_up extends AppCompatActivity {
    DataBaseHelpe cdb;
    EditText email, phone, user_name, pass;
    Button signn;
 public    Customer c = new Customer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

       /* Toolbar tt = findViewById(R.id.tool);
        setSupportActionBar(tt);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        onOptionsItemSelected(MenuItem item)*/

        //  getSupportActionBar().setTitle("sign up");
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button b =(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sign_up.this,Log_in.class);
                startActivity(i);
                finish();
            }
        });


        email = (EditText) findViewById(R.id.email_order);
        phone = (EditText) findViewById(R.id.address);
        pass = (EditText) findViewById(R.id.pass_order);
        user_name = (EditText) findViewById(R.id.u_name);
        signn = (Button) findViewById(R.id.join);
        cdb = new DataBaseHelpe(getApplicationContext());

        signn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@gmail"
                        + "(" + "."
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");
                Pattern PASSWORD_PATTERN=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$") ;

                boolean valid = true;
                //signn.setTextColor(Color.parseColor("#fff"));
               // signn.setBackgroundColor(Color.parseColor("#c01019"));
                if( !EMAIL_ADDRESS_PATTERN.matcher(email.getText().toString()).matches()){
                    //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                    valid=false;
                email.setError("Please Enter a Valid Gmail");
                }
                if( ! pass.getText().toString().matches("[a-zA-Z0-9]{8,16}")){
                    //Toast.makeText(getApplicationContext(), "Please Enter a Valid Password", Toast.LENGTH_LONG).show();
                    pass.setError("Please Enter a Valid Password of 8:16 characters ");
                    valid=false;

                }
                if (!phone.getText().toString().matches("[0-9]{11}")){
                    valid=false;
                 phone.setError("Please Enter a Valid Phone Number");
                }
                if(!cdb.Unique_username(user_name.getText().toString())){
                    valid=false;

                    user_name.setError("This username is used before \nPlease Enter Another username ");
                }


if (valid){
                c.setCust_mail(email.getText().toString());
                c.setCust_password(pass.getText().toString());
                c.setCust_UserName(user_name.getText().toString());
                c.setCustomerPhone(phone.getText().toString());
                cdb.createNewCustomer(c);
                    Toast.makeText(getApplicationContext(), "Signed Up Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Sign_up.this, Log_in.class);
                    startActivity(i);
                    finish();
                   }


            }


        });
    }
}