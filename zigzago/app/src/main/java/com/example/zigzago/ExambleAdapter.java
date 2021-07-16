package com.example.zigzago;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExambleAdapter extends RecyclerView.Adapter<ExambleAdapter.ExampleViewHolder> {

    public  List<Item> mexamblelist;
    public Context contextt;
    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void OnAddClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }


    public ExambleAdapter(List<Item> examblelist,Context context) {

        this.mexamblelist=examblelist;
         this.contextt =context;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView myImageView;
        public ImageView myImageView2;
        public TextView myTextView1;
        public TextView myTextView2;
        public TextView myTextView3;
        public Button btn;
        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            myImageView =itemView.findViewById(R.id.imageview1);
            myTextView1= itemView.findViewById(R.id.sanswitchname);
            myTextView2= itemView.findViewById(R.id.sanswitchprice);
            myTextView3=itemView.findViewById(R.id.descriptiontext);
            btn=itemView.findViewById(R.id.addbutton);
            myImageView2=itemView.findViewById(R.id.imageView2);
            /*
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int postion=getAdapterPosition();
                        if(postion!=RecyclerView.NO_POSITION)
                        {
                            listener.OnAddClick(postion);
                        }
                    }

                }
            });

             */



        }
    }
/**
    public void additem(Item obj)
    {
        mexamblelist.add(obj);
        notifyDataSetChanged();
    }
 */



    @Override
    public ExampleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exambleitem1,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, final int position) {
        Item currentitem=mexamblelist.get(position);
        holder.myImageView.setImageResource(currentitem.getImageRes());
        holder.myTextView1.setText(currentitem.getName());
        holder.myTextView2.setText(String.valueOf(currentitem.getPrice())+" LE");
        holder.myTextView3.setText(currentitem.getItemDescription());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found =false;
                for (Item x : recycleview2.myorder)
                {
                    if (x.getName().equals(mexamblelist.get(position).getName()))
                    {
                        found=true;
                    }
                }
                if(found==false)
                {
                    recycleview2.myorder.add(mexamblelist.get(position));
                    holder.btn.setText("Added");
                    holder.btn.setTextColor(Color.DKGRAY);

                   // Toast.makeText(contextt,  mexamblelist.get(position).getName()+"Added To your order", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(contextt, mexamblelist.get(position).getName()+" already Exist In Your Order", Toast.LENGTH_SHORT).show();

                }
            }

        });
        holder.myImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found =false;
                for (Item x :Customerwishlist.wishlist)
                {
                    if (x.getName().equals(mexamblelist.get(position).getName()))
                    {
                        found=true;
                    }
                }
                if(found==false)
                {
                    Customerwishlist.wishlist.add(mexamblelist.get(position));
                    holder.myImageView2.setColorFilter(Color.YELLOW);

                   // Toast.makeText(contextt,  mexamblelist.get(position).getName()+" Added To Your WishList", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Customerwishlist.wishlist.remove(mexamblelist.get(position));
                    holder.myImageView2.clearColorFilter();
                    Toast.makeText(contextt, mexamblelist.get(position).getName()+" Removed Done From Your WishList", Toast.LENGTH_SHORT).show();

                }
            }
        });
        /*
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null)
                {
                    int postion=getAdapterPosition();
                    if(postion!=RecyclerView.NO_POSITION)
                    {
                        listener.OnAddClick(postion);
                    }
                }
            }
        });

         */

    }

    @Override
    public int getItemCount() {
        return mexamblelist.size();
    }
    public void filterlist(List<Item> filterlist)
    {
        mexamblelist=filterlist;
        notifyDataSetChanged();
    }
}
