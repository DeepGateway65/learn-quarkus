package org.acme.productapi.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.productapi.mapper.ProductMapper;
import org.acme.productapi.model.Product;
import org.acme.productapi.repository.ProductRepository;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;
    private  final List<Product> products = new ArrayList<>();
    ProductMapper mapper = new ProductMapper();


    public  List<Product> getAllProducts(){
        return productRepository.listAll();
    }

    public Product addProduct(String name, double price){
        Product product = mapper.toEntity(name,price);
        productRepository.persist(product);
        return  product;

    }

    public Product getProductById(ObjectId id){
        return  productRepository.findById(id);
    }

    public Product updateProduct(ObjectId id, String name, double price){
        Product existingProduct = productRepository.findById(id);

        if(existingProduct != null){
            existingProduct.setName(name);
            existingProduct.setPrice(price);
            productRepository.update(existingProduct);

            return  existingProduct;


        }
        return  null;
    }

    public boolean deleteProduct(ObjectId id){
        return  productRepository.deleteById(id);
    }



}
