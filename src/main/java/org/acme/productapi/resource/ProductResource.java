package org.acme.productapi.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.productapi.model.Product;
import org.acme.productapi.service.ProductService;
import org.bson.types.ObjectId;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") ObjectId id){

        Product product = productService.getProductById(id);


        if(product == null){
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

        return  Response.ok(product).build();

    }

    @POST

    public Response addProduct(Product product){
        Product createdProduct = productService.addProduct(product.getName(),product.getPrice());
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();

    }

    @PUT
    @Path("/{id}")

    public  Response updateProduct(@PathParam("id") ObjectId id, Product product){
        Product updatedProduct = productService.updateProduct(id,product.getName(),product.getPrice());
        if(updatedProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return  Response.ok(updatedProduct).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") ObjectId id){

        boolean deleted = productService.deleteProduct(id);

        if(deleted){
            return  Response.noContent().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }


}
