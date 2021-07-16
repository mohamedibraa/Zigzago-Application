package com.example.zigzago;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
public class Bill extends AppCompatActivity {
    Button btn;
    TextView total;
    public  static EditText e1;
    public static EditText p1;
    public  EditText address1;
    public static  String PASSWORD;
    public static  String Email;
    String address2;
    Log_in l1 =new Log_in();
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    SharedPreferences spp;
    SharedPreferences.Editor editt;
    fav_dishh fv=new fav_dishh(this) ;
    Customerwishlist cl = new Customerwishlist();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        fv=new fav_dishh(getApplicationContext());
        Toolbar a = findViewById(R.id.tool);
        setSupportActionBar(a);
        // set price in text view
        total=(TextView)findViewById(R.id.totalprice);
        total.setText(recycleview2.totalprice()+" LE");
        //put data of order in array list
        recycleview2.data();
        //display data from array list to send it to mail
        // recycleview2.displaydata();
        address1=(EditText)findViewById(R.id.address);
        btn=(Button)findViewById(R.id.sendorder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recycleview2.totalprice().equals("0.0")) {
                    Toast.makeText(getApplicationContext(), "Please Create Your Order First", Toast.LENGTH_LONG).show();
                } else {
                    if (sendEmail()) {

                        Toast.makeText(getApplicationContext(), "Order Information Sent Successfully", Toast.LENGTH_SHORT).show();
                        recycleview2.myorder.clear();
                        recycleview2 f = new recycleview2();
                        f.finish();
                        Intent x = new Intent(Bill.this, rating.class);
                        startActivity(x);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Enter Order Address First", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean sendEmail() {
        boolean flag = true;
        if (address1.getText().length()==0) {
            flag=false;
        } else {
            address2 = address1.getText().toString();
            String mSubject = "Order Of " + l1.customer.getCust_UserName() + "'s";
            String mMessage = "Information of Customer and it's Order \n- Customer Name : " + l1.customer.getCust_UserName() + "\n" + "- Phone Number : " + l1.customer.getCustomerPhone() + "\n" + "- E-mail : " + l1.customer.getCust_mail() + "\n- Order Address : " + address2 + "\n- Order Details : \n" + recycleview2.displaydata() + "\n    - TOTAL PRICE : " + recycleview2.totalprice() + " LE\n";
            send_order s1 = new send_order(this, "zigzagorest@gmail.com", mSubject, mMessage);
            s1.execute();
            flag=true;
        }
        return flag;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater f = getMenuInflater();
        f.inflate(R.menu.menu,menu);
        return true; }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.logout)
        {
            if (fv.get_fav_dish()){
                fv.update_fav(cl.wishlistitems());
            }
            else{
                fv.insert_fav_dish(cl.wishlistitems());
            }
            Customerwishlist.wishlist.clear();
            sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            edit=sp.edit();
            edit.clear();
            edit.commit();
            /*
            spp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            editt=spp.edit();
            editt.putString(Log_in.customer.getCust_UserName(),Customerwishlist.wishlistitems());

             */
            Intent x =new Intent(Bill.this,Log_in.class);
            startActivity(x);
            finish();
        }
        else if(id== R.id.delete)
        {
            fv.f_Delete_account();
            DataBaseHelpe d = new DataBaseHelpe(getApplicationContext());
            d.Delete_account();
            sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            edit=sp.edit();
            edit.clear();
            edit.commit();
            Intent x =new Intent(Bill.this,Log_in.class);
            startActivity(x);
            finish();
        }
        else if(id== R.id.setting)
        {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);

        }
        return super.onOptionsItemSelected(item);
    }
}