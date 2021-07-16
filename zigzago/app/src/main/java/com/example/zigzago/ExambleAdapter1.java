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

public class ExambleAdapter1 extends RecyclerView.Adapter<ExambleAdapter1.ExampleViewHolder> {


    public static List<Item> mexamblelist;
    public Context contextt;
    public ExambleAdapter1(List<Item> examblelist,Context context)
    {
        this.mexamblelist=examblelist;
        this.contextt=context;
    }

    public void addNewItem(Item item ){
        mexamblelist.add(item);
        notifyDataSetChanged();
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView myTextView1;
        public TextView myTextView2;
        public TextView myTextView3;
        public Button increase;
        public Button decrease;
        public Button delete;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            myTextView1= itemView.findViewById(R.id.itemname);
            myTextView2= itemView.findViewById(R.id.itemprice);
            myTextView3=itemView.findViewById(R.id.itemnum);
            increase= itemView.findViewById(R.id.INbutton);
            decrease = itemView.findViewById(R.id.DCbutton);
            delete=itemView.findViewById(R.id.deletebtn);
            // btn=itemView.findViewById(R.id.addbutton);
        }
        public void deleteorder()
        {
            mexamblelist.clear();
        }

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExambleAdapter1.ExampleViewHolder evh=new ExambleAdapter1.ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {
        final Item currentitem = mexamblelist.get(position);
        holder.myTextView1.setText(currentitem.getName());
        holder.myTextView2.setText(String.valueOf(currentitem.getPrice()) + " EGP");
        holder.myTextView3.setText(String.valueOf(currentitem.getItemNumber()));

        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentitem.itemNumber++;
                holder.myTextView3.setText(String.valueOf(currentitem.getItemNumber()));
                holder.myTextView2.setText(String.valueOf(currentitem.getPrice()) + " LE");


            }
        });
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentitem.itemNumber > 1) {
                    currentitem.itemNumber--;
                    holder.myTextView3.setText(String.valueOf(currentitem.getItemNumber()));
                    holder.myTextView2.setText(String.valueOf(currentitem.getPrice()) + " LE");

                }
            }

        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mexamblelist.remove(position);
                notifyDataSetChanged();
            }
        });

    }


    @Override
    public int getItemCount() {
        return mexamblelist.size();
    }

    public static void deleteorder()
    {
        mexamblelist.clear();
    }
}
