package com.example.zigzago.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zigzago.ExambleAdapter;
import com.example.zigzago.Item;
import com.example.zigzago.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }
    RecyclerView recyclerView;
    List<Item> menu=new ArrayList<>() ;
    ExambleAdapter mAdapter;
    Button b;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        /**
         View root = inflater.inflate(R.layout.fragment_menu, container, false);
         final TextView textView = root.findViewById(R.id.section_label);
         pageViewModel.getText().observe(this, new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
        textView.setText(s);
        }
        });
         return root;
         */
        if(getArguments().getInt(ARG_SECTION_NUMBER)==1)
        {
            View root = inflater.inflate(R.layout.fragment_all, container, false);

            recyclerView=root.findViewById(R.id.allRecycleView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            menu.clear();
            menu.add(new Item(R.drawable.fat,"Fat Forester Sandwich",65.50f,"two layers of fried chicken breast, lettuce, tomato,\n pickled cucumber, fresh mushroom, mushroom \n sauce with black pepper and mayonnaise","sandwiches",1));
            menu.add(new Item(R.drawable.martis,"Mozzarella Martis Sandwich",60.99f,"Lettuce, Tomato, Pickled Cucumber, Mayonnaise,\n Fried Chicken Breast Covered With Mozzarella\n And Mozzarella Sticks","sandwiches",1));
            menu.add(new Item(R.drawable.rancher,"The rancher Sandwich",48.50f,"fried chicken breast, lettuce, tomato, pickled\n cucumber, ranch sauce, mayonnaise sauce","sandwiches",1));
            menu.add(new Item(R.drawable.fries,"French Fries",15.00f,"Medium","apptizers",1));
            menu.add(new Item(R.drawable.steak,"SIRLOIN STEAK TIP ",45.50f,"","sandwiches",1));
            menu.add(new Item(R.drawable.philly,"Chicken Philly",45.00f,"","sandwiches",1));
            menu.add(new Item(R.drawable.kofta,"Kofta",75.00f,"Half kilo of Kofta with Tahini salad and Green salad","main dishes",1));
            menu.add(new Item(R.drawable.pizza,"Barbeque Chicken Pizza",80.00f,"Meduim","main dishes",1));
            menu.add(new Item(R.drawable.shrimpasta,"Creamy Shrimp ",77.50f,"","main dishes",1));
            menu.add(new Item(R.drawable.bread,"Cheesy Garlic Bread",25.00f,"","apptizers",1));
            menu.add(new Item(R.drawable.wings,"Chicken Wings",32.50f,"","apptizers",1));
            menu.add(new Item(R.drawable.mango,"Knafah with Manogo",40.00f,"","desserts",1));
            menu.add(new Item(R.drawable.cream,"Italian Cream Stuffed ",45.00f,"","desserts",1));
            menu.add(new Item(R.drawable.sandwich,"ITALIAN SANDWICH SLIDERS",65.00f,"","desserts",1));
            menu.add(new Item(R.drawable.kunafa,"Knafah Cupcakes",40.00f,"","desserts",1));
            menu.add(new Item(R.drawable.brownies,"Chocolate Mint Brownies",45.00f,"","desserts",1));
            menu.add(new Item(R.drawable.water,"Nestle Pure Life Water bottle",05.50f,"600 ml.","drinks",1));
            menu.add(new Item(R.drawable.pepsi,"Pepsi Can",09.00f,"330 ml.","drinks",1));
            mAdapter=new ExambleAdapter(menu,getActivity());

            recyclerView.setAdapter(mAdapter);


            /*
            mAdapter.setOnItemClickListener(new ExambleAdapter.OnItemClickListener() {
                @Override
                public void OnAddClick(int position) {
                    Toast.makeText(getContext(),"postion "+position,Toast.LENGTH_LONG).show();
                }
            });
            /*
             */
            editText1=(EditText)root.findViewById(R.id.searchtext1);
            editText1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
            });

            return root;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
        {
            View root = inflater.inflate(R.layout.fragment_sandwiches, container, false);
            recyclerView=root.findViewById(R.id.sandwichesRecycleview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            menu.clear();

            menu.add(new Item(R.drawable.fat,"Fat Forester Sandwich",65.50f,"two layers of fried chicken breast, lettuce, tomato,\n pickled cucumber, fresh mushroom, mushroom \n sauce with black pepper and mayonnaise","sandwiches",1));
            menu.add(new Item(R.drawable.martis,"Mozzarella Martis Sandwich",60.99f,"Lettuce, Tomato, Pickled Cucumber, Mayonnaise,\n Fried Chicken Breast Covered With Mozzarella\n And Mozzarella Sticks","sandwiches",1));
            menu.add(new Item(R.drawable.rancher,"The rancher Sandwich",48.50f,"fried chicken breast, lettuce, tomato, pickled\n cucumber, ranch sauce, mayonnaise sauce","sandwiches",1));
            menu.add(new Item(R.drawable.bite,"Classic Bite Sandwich",45.00f,"Fried Chicken Breast, Lettuce, Tomato,\n Cucumber, Mayonnaise, Cheddar Slice","sandwiches",1));
            menu.add(new Item(R.drawable.mocha,"Mocha Sandwich",50.00f,"hot dog, Alexandrian sausage, beef shawarma \n and mozzarella cheese","sandwiches",1));
            menu.add(new Item(R.drawable.shabah,"Shabah Sandwich",45.00f,"shish,chicken panne, strips, fries \nand mozzarella","sandwiches",1));
            menu.add(new Item(R.drawable.sarukh,"Al-Sarukh Sandwich",45.00f,"chicken panne, crispy, katyoucha, hot dog,\n burger, kofta, fries","sandwiches",1));
            menu.add(new Item(R.drawable.pane,"Chicken Panne Sandwich",35.00f,"chicken panne, crispy, katyouche, strips,\n shish, fries","sandwiches",1));
            menu.add(new Item(R.drawable.ranch,"Chicken Ranch Sandwich",50.55f,"Chicken Kofta, Chicken Burger, Chicken Pane,\n Chicken Sausage, Strips, Chicken Shawarma \n and Mozzarella Cheese","sandwiches",1));
            menu.add(new Item(R.drawable.zinger,"Zinger Supreme Sandwich",45.00f,"Strips, Smoked Turkey and Mozzarella","sandwiches",1));
            menu.add(new Item(R.drawable.cranchi,"Super Crunchy Sandwich",45.00f,"Crispy Pane, Salami and Mozzarella","sandwiches",1));
            menu.add(new Item(R.drawable.zahma,"Zahma Sandwich",35.45f,"shish, strips, sausage, cheddar cheese","sandwiches",1));
            menu.add(new Item(R.drawable.shatshot,"Shatshout Sandwich",55.75f,"sausage, salami, pastrami and mozzarella","sandwiches",1));
            menu.add(new Item(R.drawable.potato,"Potato Crepe",30.90f,"","sandwiches",1));
            menu.add(new Item(R.drawable.egg,"EGG AND CHEESE SANDWICH",35.00f,"","sandwiches",1));
            menu.add(new Item(R.drawable.steak,"SIRLOIN STEAK TIP SANDWICH",45.50f,"","sandwiches",1));
            menu.add(new Item(R.drawable.philly,"Chicken Philly",45.00f,"","sandwiches",1));

            //recyclerView.setAdapter(new ExambleAdapter(menu));
            mAdapter=new ExambleAdapter(menu,getActivity());
            recyclerView.setAdapter(mAdapter);


            editText2=(EditText)root.findViewById(R.id.searchtext2);
            editText2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
            });
            return root;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER)==3)
        {
            View root = inflater.inflate(R.layout.fragment_maindishes, container, false);
            recyclerView=root.findViewById(R.id.maindishesRecycleView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            menu.clear();

            menu.add(new Item(R.drawable.pizza,"Barbeque Chicken Pizza",80.00f,"Meduim","main dishes",1));
            menu.add(new Item(R.drawable.shrimpasta,"Creamy Shrimp & Mozzarella Pasta",77.50f,"","main dishes",1));
            menu.add(new Item(R.drawable.kofta,"Kofta",75.00f,"Half kilo of Kofta with Tahini salad and Green salad","main dishes",1));
            menu.add(new Item(R.drawable.avorice,"Rice with Avocado salad and Chicken",85.00f,"","main dishes",1));
            menu.add(new Item(R.drawable.pizza2,"Pepperoni Pizza",70.00f,"Medium","main dishes",1));
            menu.add(new Item(R.drawable.shrimrice,"Rice with Shrimp and Broccoli",65.99f,"","main dishes",1));
            menu.add(new Item(R.drawable.koshari,"Koshari",24.99f,"","main dishes",1));
            menu.add(new Item(R.drawable.pasta,"Baked Pasta with Bechamel Sauce",45.00f,"with Chicken Panne","main dishes",1));
            menu.add(new Item(R.drawable.vine,"Mahshi Vine Leaves",110.00f,"Family platter","apptizers",1));
            menu.add(new Item(R.drawable.mombar,"Mombar",99.90f,"Family platter","apptizers",1));
            menu.add(new Item(R.drawable.hawawshi,"Hawawshi",35.00f,"Meduim","main dishes",1));
            menu.add(new Item(R.drawable.sushi,"Sushi",55.00f,"Half kilo of Sushi with Sauce","main dishes",1));

            // recyclerView.setAdapter(new ExambleAdapter(menu));
            mAdapter=new ExambleAdapter(menu,getActivity());
            recyclerView.setAdapter(mAdapter);


            editText3=(EditText)root.findViewById(R.id.searchtext3);
            editText3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
            });
            return root;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER)==4)
        {
            View root = inflater.inflate(R.layout.fragment_desserts, container, false);

            recyclerView=root.findViewById(R.id.dessertsRecycleView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            menu.clear();

            menu.add(new Item(R.drawable.mcupcake,"Andes Mint Cupcake",25.00f,"","desserts",1));
            menu.add(new Item(R.drawable.apple,"Apple Turnovers",44.50f,"","desserts",1));
            menu.add(new Item(R.drawable.atayef,"Atayef",25.00f,"","desserts",1));
            menu.add(new Item(R.drawable.cookies,"Baileys Cookies and Cream Parfaits",65.00f,"","desserts",1));
            menu.add(new Item(R.drawable.waffel2,"Chocolate Malt Waffles",44.99f,"","desserts",1));
            menu.add(new Item(R.drawable.brownies,"Chocolate Mint Brownies",45.00f,"","desserts",1));
            menu.add(new Item(R.drawable.waffell,"CINNAMON ROLL WAFFLES",35.25f,"","desserts",1));
            menu.add(new Item(R.drawable.icecake1,"CHOCOLATE ICEBOX CAKE",45.00f,"","desserts",1));
            menu.add(new Item(R.drawable.hotchoc,"Italian Hot chocolate",24.50f,"","desserts",1));
            menu.add(new Item(R.drawable.icechoc,"Ice with chocolate",40.75f,"","desserts",1));
            menu.add(new Item(R.drawable.cream,"Italian Cream Stuffed Cannoncini",45.00f,"","desserts",1));
            menu.add(new Item(R.drawable.sandwich,"ITALIAN SANDWICH SLIDERS",65.00f,"","desserts",1));
            menu.add(new Item(R.drawable.kunafa,"Knafah Cupcakes",40.00f,"","desserts",1));
            menu.add(new Item(R.drawable.mcupcake,"Chocolate Cupcake",44.00f,"","desserts",1));
            menu.add(new Item(R.drawable.pudding,"Rice Pudding",23.50f,"Rice and Milk desserts","desserts",1));
            menu.add(new Item(R.drawable.kunafa2,"RICOTTA KUNAFA",43.00f,"","desserts",1));
            menu.add(new Item(R.drawable.waffel5,"Vanilla Bean & Blueberry Waffles",35.00f,"","desserts",1));
            menu.add(new Item(R.drawable.zlabias,"Mshabek",27.99f,"","desserts",1));
            menu.add(new Item(R.drawable.icecake2,"CHOCOLATE POKE CAKE",45.00f,"","desserts",1));
            menu.add(new Item(R.drawable.roses,"Dark Chocolate Roses Cupcake",25.00f,"","desserts",1));
            menu.add(new Item(R.drawable.cake,"Chocolate sweets",27.00f,"","desserts",1));
            menu.add(new Item(R.drawable.mango,"Knafah with Manogo",40.00f,"","desserts",1));
            menu.add(new Item(R.drawable.basbousa,"Basbousa",25.00f,"","desserts",1));
            menu.add(new Item(R.drawable.waffel,"Cake Mix Waffles",35.00f,"","desserts",1));
            menu.add(new Item(R.drawable.dounts,"Doughnuts",30.00f,"","desserts",1));





            // recyclerView.setAdapter(new ExambleAdapter(menu));
            mAdapter=new ExambleAdapter(menu,getActivity());
            recyclerView.setAdapter(mAdapter);


            editText4=(EditText)root.findViewById(R.id.searchtext4);
            editText4.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
            });

            return root;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER)==5)
        {
            View root = inflater.inflate(R.layout.fragment_appetizer, container, false);
            recyclerView=root.findViewById(R.id.appetizerRecycleView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            menu.clear();
            menu.add(new Item(R.drawable.bread,"Cheesy Garlic Bread",25.00f,"","apptizers",1));
            menu.add(new Item(R.drawable.wings,"Chicken Wings",32.50f,"","apptizers",1));
            menu.add(new Item(R.drawable.fries,"French Fries",15.00f,"Medium","apptizers",1));
            menu.add(new Item(R.drawable.sambosa,"Sambosa",50.00f,"Family platter","apptizers",1));
            menu.add(new Item(R.drawable.onion,"Cheese Onion Rings",35.00f,"","apptizers",1));

            // recyclerView.setAdapter(new ExambleAdapter(menu));
            mAdapter=new ExambleAdapter(menu,getActivity());
            recyclerView.setAdapter(mAdapter);

            editText5=(EditText)root.findViewById(R.id.searchtext5);
            editText5.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
            });
            return root;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER)==6)
        {
            View root = inflater.inflate(R.layout.fragment_drinks, container, false);
            recyclerView=root.findViewById(R.id.drinksRecycleView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            menu.clear();
            menu.add(new Item(R.drawable.coffee,"Coffee",15.00f,"","drinks",1));
            menu.add(new Item(R.drawable.water,"Nestle Pure Life Water bottle",05.50f,"600 ml.","drinks",1));
            menu.add(new Item(R.drawable.pepsi,"Pepsi Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.pepsid,"Pepsi Diet Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.cola,"Coca-Cola Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.sprite,"Sprite Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.sevenup,"7UP Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.lemon,"Fanta Ice Lemon Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.fanta,"Fanta Orange Can",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.mirinda,"Mirinda Orange",09.00f,"330 ml.","drinks",1));
            menu.add(new Item(R.drawable.lemonade,"Lemonade",25.00f,"","drinks",1));
            menu.add(new Item(R.drawable.peach,"Peach Fresh Juice",25.00f,"","drinks",1));
            menu.add(new Item(R.drawable.strawberry,"Strawberry Fresh Juice",25.00f,"","drinks",1));
            menu.add(new Item(R.drawable.watermelon,"Watermelon Fresh Juice",25.00f,"","drinks",1));

            mAdapter=new ExambleAdapter(menu,getActivity());
            recyclerView.setAdapter(mAdapter);


            editText6=(EditText)root.findViewById(R.id.searchtext6);
            editText6.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    filter(editable.toString());
                }
            });

            return root;
        }
        else
        {
            View root = inflater.inflate(R.layout.activity_menu, container, false);

            return root;
        }
    }
    private void filter(String text)
    {
        List<Item> filterlist=new ArrayList<>();
        for (Item x:menu) {
            if(x.getName().toLowerCase().contains(text.toLowerCase()))
            {
                filterlist.add(x);
            }
        }
        mAdapter.filterlist(filterlist);
    }
    /*
    private List<Item> returnData() {
        menu=new ArrayList<>();
        menu.add(new Item(R.drawable.cheeseonionrings351,"cheese on ionrings",35f));
        menu.add(new Item(R.drawable.cheesygarlicbread252,"cheesy garlic bread",25f));
        menu.add(new Item(R.drawable.chickenwings323,"chicken wings",40f));

        return menu;
    }

     */
}