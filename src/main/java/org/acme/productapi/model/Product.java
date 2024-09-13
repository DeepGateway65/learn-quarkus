package org.acme.productapi.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Product extends PanacheMongoEntity
{

//    private String id;
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +

                '}';
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
