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
import androidx.viewpager.widget.ViewPager;

import com.example.zigzago.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    Log_in log = new Log_in();
    Button btn1;
    Button btn2;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
   // SharedPreferences spp;
  //  SharedPreferences.Editor editt;
    String wishliststring = "Null";
    public static List<Item> newwishlist = new ArrayList<>();
    Customerwishlist cl = new Customerwishlist();
    fav_dishh fv=new fav_dishh(this) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        fv=new fav_dishh(getApplicationContext());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
//read
       // spp=getSharedPreferences(MainActivity.tablename,MODE_PRIVATE);
/*
        editt=spp.edit();
        editt.clear();
        editt.commit();

 */

        //wishliststring = spp.getString("wish", "Null");
       // Toast.makeText(this, wishliststring, Toast.LENGTH_LONG).show();


        /*
        returnwishlist();
        Customerwishlist.wishlist = newwishlist;

         */

        /**
         FloatingActionButton fab = findViewById(R.id.fab);

         fab.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
        }
        });
         */

        btn1 = (Button) findViewById(R.id.checkout);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recycleview2.myorder.isEmpty()) {
                    Toast.makeText(MenuActivity.this, "Your Cart Is Empty, Add Items First", Toast.LENGTH_LONG).show();
                } else {
                    Intent x = new Intent(MenuActivity.this, recycleview2.class);
                    startActivity(x);
                }

            }
        });
        btn2 = (Button) findViewById(R.id.wishlist);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MenuActivity.this, Customerwishlist.class);
                startActivity(x);
                /*
                if (Customerwishlist.wishlist.size() == 0) {
                    Toast.makeText(MenuActivity.this, "Your WishList Is Empty, Add Items First", Toast.LENGTH_LONG).show();
                } //else{
                    // Toast.makeText(MenuActivity.this, Customerwishlist.wishlistitems(), Toast.LENGTH_LONG).show();

                }

                 */

            }
        });

        Toolbar a = findViewById(R.id.tool);
        setSupportActionBar(a);
    }
/*
    public void returnwishlist() {
        zigzagomenu.getzigzagomenu();
        String[] arrOfStr = wishliststring.split("@");

        if (wishliststring.equals("Null")) {
            newwishlist.clear();
        }

        for (String x : arrOfStr) {
            for (int i = 0; i < zigzagomenu.zigzagomenu.size(); i++) {
                if (zigzagomenu.zigzagomenu.get(i).equals(x)) {
                    newwishlist.add(zigzagomenu.zigzagomenu.get(i));
                }
            }
        }
    }

 */

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
            edit.commit();

            Intent x =new Intent(MenuActivity.this,Log_in.class);
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
            Intent x =new Intent(MenuActivity.this,Log_in.class);
            startActivity(x);
            finish();
        }
        else if(id== R.id.setting)
        {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //spp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        /*
        spp=getSharedPreferences(MainActivity.tablename,MODE_PRIVATE);
        editt=spp.edit();
        editt.putString("wish",Customerwishlist.wishlistitems());
        editt.commit();

         */
    }

}