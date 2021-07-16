package com.example.zigzago;

import java.util.ArrayList;
import java.util.Random;

public class Customer {

    Order yourorder;
    private String cust_UserName;
    private String cust_password;
    private String cust_mail;
    //forget password by mail and update password
    private static int Pin;
    protected String customerReview;
    private String customerPhone;
    private static String wishliststring;

    int n;
    //forget password by mail and update password


    public static int getPin() {
        return Pin;
    }

    public Customer(){
        Random rand = new Random();
        n = rand.nextInt(5000);
        this.Pin= n;
    }

    /**
     * Array list that contain favorite items name for this customer
     */
    ArrayList<Item> wishList =new ArrayList<Item>();
    /**
     * Array list that contain orders for this customer because customer can has many orders
     */
    
    public Customer(String cust_UserName, String cust_password) {
        this.cust_UserName = cust_UserName;
        this.cust_password = cust_password;
    }

    public Customer( String cust_UserName, String cust_password,
             String customerPhone ,String mail) {
        this.cust_UserName = cust_UserName;
        this.cust_password = cust_password;
        this.customerPhone = customerPhone;
        this.cust_mail=mail;
        Random rand = new Random();
        int n = rand.nextInt(500000);
        this.Pin= n;

    }

    public static String getWishliststring() {
        return wishliststring;
    }

    public static void setWishliststring(String wishliststring) {
        Customer.wishliststring = wishliststring;
    }

    public String getCust_UserName() {
        return cust_UserName;
    }

    public void setCust_UserName(String cust_UserName) {
        this.cust_UserName = cust_UserName;
    }

    public String getCust_password() {
        return cust_password;
    }

    public void setCust_password(String cust_password) {
        this.cust_password = cust_password;
    }

    public String getCustomerReview() {
        return customerReview;
    }

    public void setCustomerReview(String customerReview) {
        this.customerReview = customerReview;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }


    public ArrayList<Item> getWishList() {
        return wishList;
    }

    public void AddtoWishList(Item i) {
        wishList.add(i);
    }

    public String getCust_mail() {
        return cust_mail;
    }

    public void setCust_mail(String cust_mail) {
        this.cust_mail = cust_mail;
    }
    //func split ll string

}
