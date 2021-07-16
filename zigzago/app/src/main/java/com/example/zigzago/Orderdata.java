package com.example.zigzago;

public class Orderdata {
    private String Itemname;
    private String itemnu;

    public Orderdata(String itemname, String itemnu) {
        this.Itemname = itemname;
        this.itemnu = itemnu;
    }

    public Orderdata() {
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String itemname) {
        Itemname = itemname;
    }

    public String getItemnu() {
        return itemnu;
    }

    public void setItemnu(String itemnu) {
        this.itemnu = itemnu;
    }
}
