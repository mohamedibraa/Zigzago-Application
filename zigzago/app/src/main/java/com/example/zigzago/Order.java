package com.example.zigzago;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    public ArrayList<Item> meals =new ArrayList<Item>();

    private static int code=0;
//counter y7sb time
    private Time orderTime;

    private String deliveryAddress;
// counter
    private Time deliveryTime;

    public Order(ArrayList<Item> meals, int code, Date orderDate, String deliveryAddress, Date deliveryDate, Time deliveryTime) {
        this.meals = meals;
        this.code = code;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTime = deliveryTime;
        code++;
    }

    public float totalPriceofOrder()
    {
        float totalprice=0;
        for (Item x: meals) {
            totalprice+=x.getPrice();
        }
        return totalprice;
    }

    public ArrayList<Item> getMeal() {
        return meals;
    }

    public void setMeal(ArrayList<Item> meal) {
        this.meals = meal;
    }

    public int getCode() {
        return code;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Time getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
