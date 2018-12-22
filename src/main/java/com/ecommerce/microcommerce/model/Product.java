package com.ecommerce.microcommerce.model;

public class Product {
    private int id;
    private String name;
    private int price;

    //Default constructor
    public Product() {
    }

    //Constructor made for tests
    public Product(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
