package org.acme.productapi.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.productapi.model.Product;
import  io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public  class ProductRepository implements  PanacheMongoRepository<Product>{

}