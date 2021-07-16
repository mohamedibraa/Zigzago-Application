package com.example.zigzago;

public class Item {
    private int imageRes;

    private String name;

    private String itemDescription;

    private String categorey;

    public float price;

    public int itemNumber=1;

    public Item() {
    }

    public Item(int imageRes, String name, float price ) {
        this.imageRes=imageRes;
        this.name = name;
        this.price = price;

    }

    public Item(int imageRes, String name, float price, String itemDescription, String categorey,int itemNumber) {
        this.imageRes = imageRes;
        this.name = name;
        this.itemDescription = itemDescription;
        this.categorey = categorey;
        this.price = price;
        this.itemNumber=itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorey() {
        return categorey;
    }

    public void setCategorey(String categorey) {
        this.categorey = categorey;
    }

    public float getPrice() {
        return price*itemNumber;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}
