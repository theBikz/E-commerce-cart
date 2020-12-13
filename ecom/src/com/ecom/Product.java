package com.ecom;

public class Product implements AddProduct {
    private String title;
    private String brand;
    private double price;
    private double rating;

    // constructor
    public Product(String title, String brand, double price , double rating) {
        this.title= title;
                this.brand = brand;
                this.price = price;
                this.rating = rating ;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return  price;
    }

    public void setPrice( double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }



    //interface method
    @Override
    public void displayItem() {
        System.out.println(
                "Name: " + this.title
                        + ", Brand : " + this.brand
                        + ", Price : " + this.price
                        + ", Rating: " + this.rating

        );
    }

    @Override
    public void addProduct(String title, String brand, double price, double rating) {
        this.title= title;
        this.brand = brand;
        this.price = price;
        this.rating = rating ;
    }

}
