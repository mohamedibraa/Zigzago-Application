package com.example.zigzago;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    DataBaseHelpe dd=new DataBaseHelpe(this);
    public static String tablename;
    fav_dishh fv = new fav_dishh(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String USERNAME=sp.getString("username","Null");
        String PASSWORD=sp.getString("password","Null");


        if(!USERNAME.equals("Null")&& !PASSWORD.equals("Null"))
        {
            Toast.makeText(getApplicationContext(), "Welcome "+USERNAME , Toast.LENGTH_LONG).show();
            dd.isloginvalid(USERNAME,PASSWORD);
            /*
            if (fv.get_fav_dish()) {
                String wish = fv.customer_favorite_dish.getString(0);
                String[] list_name = wish.split("@");
                for (String x : list_name) {
                    Toast.makeText(getApplicationContext(),x,Toast.LENGTH_LONG).show();
                    for (int i = 0; i < zigzagomenu.zigzagomenu.size(); i++) {
                        if (zigzagomenu.zigzagomenu.get(i).getName().equals(x)) {
                            Customerwishlist.wishlist.add(zigzagomenu.zigzagomenu.get(i));
                        }
                    }
                }
            }

             */
            Log_in.customer.setCust_UserName(USERNAME);
           // tablename=USERNAME;

            Log_in.customer.setCust_password(PASSWORD);
            String phone = dd.login_cursor.getString(1);
            String cmail = dd.login_cursor.getString(0);
            Log_in.customer.setCustomerPhone(phone);
            Log_in.customer.setCust_mail(cmail);
            NextActivity1();
        }
        else {
            NextActivity();
        }
/*
        RelativeLayout r = (RelativeLayout)findViewById(R.id.father);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

 */

    }
    public void NextActivity()
    {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this,Log_in.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }
    public void NextActivity1()
    {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }
}