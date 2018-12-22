package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@JsonFilter("myDynamicFilter"
public class Product {
    @Id //the id attribute can be identified
    @GeneratedValue //as an auto-generated key
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
