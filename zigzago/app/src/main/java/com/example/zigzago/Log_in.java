package com.example.zigzago;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Log_in extends AppCompatActivity {

  public static Customer customer= new Customer();
  SharedPreferences sp;
  SharedPreferences.Editor edit;
  String u1;
  String p1;
  String s2;
    fav_dishh fv = new fav_dishh(this);
    Customerwishlist cl = new Customerwishlist();
  DataBaseHelpe dd=new DataBaseHelpe(this);
  /*
    public static List<Item> wishh = new ArrayList<>();
    public static List<Item> wishh2 = new ArrayList<>();

   */

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView t = (TextView)findViewById(R.id.signuppp);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Log_in.this,Sign_up.class);
                startActivity(i);
            }
        });

        TextView tt = (TextView)findViewById(R.id.forget);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kk = new Intent(Log_in.this,forget2.class);
                pin_page2 p = new pin_page2();
                p.finish();
                ReSet1_pass2 r = new ReSet1_pass2();
                r.finish();
                startActivity(kk);


            }
        });
         Button b =(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Log_in.this,MainActivity.class);
                startActivity(i);
            }
        });

        final TextView un1 = (TextView) findViewById(R.id.uname);
        final TextView pa1 = (TextView) findViewById(R.id.pass);

         login =(Button)findViewById(R.id.login);
         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u1 = un1.getText().toString();
                p1 = pa1.getText().toString();
                s2 = "Welcome " + u1;

                if (dd.isloginvalid(u1,p1)) {
                    if (fv.get_fav_dish()) {
                        zigzagomenu.getzigzagomenu();

                        String wish = fv.customer_favorite_dish.getString(0);
                        String[] list_name = wish.split("@");
                        // Customerwishlist.wishlist.clear();
//                        ExambleAdapter.mexamblelist.clear();
                        for (String x : list_name) {
                            for (int i = 0; i < zigzagomenu.zigzagomenu.size(); i++) {
                                if (zigzagomenu.zigzagomenu.get(i).getName().equals(x)) {
                                    // if(Customerwishlist.founded(zigzagomenu.zigzagomenu.get(i))) {

                                        Customerwishlist.wishlist.add(zigzagomenu.zigzagomenu.get(i));

                                }
                            }

                        }

                    }
                    customer.setCust_UserName(u1);
                    customer.setCust_password(p1);
                    MainActivity.tablename=u1;
                    String phone = dd.login_cursor.getString(1);
                    String cmail = dd.login_cursor.getString(0);
                    customer.setCustomerPhone(phone);
                    customer.setCust_mail(cmail);
                    sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    edit=sp.edit();
                    edit.putString("username",u1);
                    edit.putString("password",p1);
                    edit.commit();
                  //  Customerwishlist.wishlist.clear();
                    Toast.makeText(getApplicationContext(), s2, Toast.LENGTH_LONG).show();
                    Intent x = new Intent(Log_in.this, MenuActivity.class);
                    forget2 f = new forget2();
                    f.finish();
                    pin_page2 p = new pin_page2();
                    p.finish();
                    ReSet1_pass2 r = new ReSet1_pass2();
                    r.finish();
                    startActivity(x);
                    finish();

                }
                else {
                    if (dd.valid_mail_and_pass(u1, p1)) {
                        Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "You Should Register First", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}