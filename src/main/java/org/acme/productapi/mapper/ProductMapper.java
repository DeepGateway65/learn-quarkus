package org.acme.productapi.mapper;

import org.acme.productapi.model.Product;

public class ProductMapper {
//
//    public  Product toEntity(String id, String name, double price){
//        return  new Product(id,name,price);
//    }

    public  Product toEntity(String name, double price){
        return  new Product(name,price);
    }


    public  void updateEntity(Product existingProduct, String name, double price) {
        existingProduct.setName(name);
        existingProduct.setPrice(price);
    }
}
