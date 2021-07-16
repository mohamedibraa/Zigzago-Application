package com.example.zigzago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExambleAdapter3  extends RecyclerView.Adapter<com.example.zigzago.ExambleAdapter3.ExampleViewHolder> {

    public static List<Item> mywishlist;
    public Context contextt;

    public ExambleAdapter3(List<Item> mywishlist, Context context) {

        this.mywishlist = mywishlist;
        this.contextt = context;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView myTextView1;
        public TextView myTextView2;
        public Button delete;


        public ExampleViewHolder(View itemView) {
            super(itemView);
            myTextView1 = itemView.findViewById(R.id.wishlistitemname);
            myTextView2 = itemView.findViewById(R.id.wishlistitemprice);
            delete = itemView.findViewById(R.id.wishlistdeletebtn);

        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem3, parent, false);
        com.example.zigzago.ExambleAdapter3.ExampleViewHolder evh = new com.example.zigzago.ExambleAdapter3.ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, final int position) {
        final Item currentitem = mywishlist.get(position);
        holder.myTextView1.setText(currentitem.getName());
        holder.myTextView2.setText(String.valueOf(currentitem.getPrice()) + " LE");
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mywishlist.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mywishlist.size();
    }


}
