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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class recycleview2 extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn;
    fav_dishh fv ;
    Customerwishlist cl = new Customerwishlist();
    public static ExambleAdapter1 exambleAdapter1;
    public static List<Item> myorder=new ArrayList<>();
    public static List<Orderdata> mydata=new ArrayList<>();
    private Toolbar a ;
    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview2);
        fv=new fav_dishh(getApplicationContext());
        recyclerView=findViewById(R.id.orderRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  myorder.add(new Item(R.drawable.cheeseonionrings351,"cheese on ionrings",35f,"kkk","kkk",1));
     //   myorder.add(new Item(R.drawable.cheesygarlicbread252,"cheesy garlic bread",25f,"kkk","kkk",1));
       // myorder.add(new Item(R.drawable.chickenwings323,"chicken wings",40f,"kkk","kkk",1));
        exambleAdapter1=new ExambleAdapter1(myorder,this ) ;
        recyclerView.setAdapter(exambleAdapter1);

        Toolbar a = findViewById(R.id.tool);
        setSupportActionBar(a);

        btn =(Button)findViewById(R.id.createorder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!totalprice().equals("0.0")) {
                    finish();
                    Intent intent = new Intent(recycleview2.this, Bill.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"ADD Items To Your Cart First",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater f = getMenuInflater();
        f.inflate(R.menu.menu,menu);
        return true;
    }
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
            Intent x =new Intent(recycleview2.this,Log_in.class);
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
            Intent x =new Intent(recycleview2.this,Log_in.class);
            startActivity(x);
            finish();
        }
        else if(id== R.id.setting)
        {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);

        }
        return super.onOptionsItemSelected(item);
    }
    public static String totalprice()
    {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        float total=0;
        float twoDigitsF=0;
        if(ExambleAdapter1.mexamblelist.size()==0)
        {
            total=0;
             twoDigitsF = Float.valueOf(decimalFormat.format(total));
        }
        else
        {
            for (Item x:ExambleAdapter1.mexamblelist)
            { total+=x.getPrice();
                 twoDigitsF = Float.valueOf(decimalFormat.format(total));
            }
        }
        return String.valueOf( twoDigitsF);
    }
    //fun that add data of order on  my dataa array list
    public static void data()
    {
        for (Item x:ExambleAdapter1.mexamblelist) {
            Orderdata obj=new Orderdata();
            obj.setItemname(x.getName());
            obj.setItemnu(String.valueOf(x.getItemNumber()));
            mydata.add(obj);
        }
    }
    //check string 0 or not
    public static String displaydata()
    {
        String data="";
        if(mydata.size()==0)
        {
            data="0";
        }
        else
        {
            for (Orderdata x : mydata)
            {
                data += x.getItemnu() + " " + x.getItemname() + "\n";
            }
        }
        return data;
    }

}