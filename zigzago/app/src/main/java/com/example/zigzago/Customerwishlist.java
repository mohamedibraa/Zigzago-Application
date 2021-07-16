package com.example.zigzago;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Customerwishlist extends AppCompatActivity {
    RecyclerView recyclerView;
    public static ExambleAdapter3 exambleAdapter3;
    public static List<Item> wishlist = new ArrayList<>();
   // public static List<Item> wishlist2 = new ArrayList<>();

    //  ArrayList<String> fav = new ArrayList<>();
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    fav_dishh fv = new fav_dishh(this);
    // Customerwishlist cl = new Customerwishlist();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerwishlist);
        recyclerView = findViewById(R.id.wishlistRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*
          wishlist.add(new Item(R.drawable.cheeseonionrings351,"cheese on ionrings",35f,"kkk","kkk",1));
          wishlist.add(new Item(R.drawable.cheesygarlicbread252,"cheesy garlic bread",25f,"kkk","kkk",1));
         wishlist.add(new Item(R.drawable.chickenwings323,"chicken wings",40f,"kkk","kkk",1));

         */
        // wishlist=Log_in.wishh;
        exambleAdapter3 = new ExambleAdapter3(wishlist, this);
        recyclerView.setAdapter(exambleAdapter3);

        Toolbar a = findViewById(R.id.tool);
        setSupportActionBar(a);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater f = getMenuInflater();
        f.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            edit = sp.edit();
            edit.clear();
            if (fv.get_fav_dish()) {
                fv.update_fav(wishlistitems());
            } else {
                fv.insert_fav_dish(wishlistitems());
            }
            Customerwishlist.wishlist.clear();
            Intent x = new Intent(Customerwishlist.this, Log_in.class);
            startActivity(x);
            finish();
        } else if (id == R.id.delete) {
            fv.f_Delete_account();
            DataBaseHelpe d = new DataBaseHelpe(getApplicationContext());
            d.Delete_account();
            sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            edit = sp.edit();
            edit.clear();
            edit.commit();
            Intent x = new Intent(Customerwishlist.this, Log_in.class);
            startActivity(x);
            finish();
        } else if (id == R.id.setting) {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);

        }
        return super.onOptionsItemSelected(item);
    }

    public static String wishlistitems() {
        String data = "";
        if (Customerwishlist.wishlist.size() == 0) {
            data = "0";
        } else {
            /*
            for (Item x : wishlist) {
               if(!wishlist2.contains(x))
               {
                wishlist2.add(x) ;
               }
            }

             */
            for (Item z:wishlist)
            {
                data += z.getName() + "@";
            }
        }
        return data;
    }

    public static boolean founded(String str) {
        boolean flag = true;
        for (Item x : wishlist) {
            if (x.getName().equals(str))
            {
                flag=true;
            }
            else
            {
                flag=false;
            }
        }
return flag;
    }
}