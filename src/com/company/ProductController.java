package com.company;

import java.util.List;
import com.company.Product;
import com.company.IProductRepository;

public class ProductController {
    private final IProductRepository repo;

    public ProductController(IProductRepository repo) {
        this.repo = repo;
    }
    public String  createProduct(String name, String details ){
//        boolean male = (gender.toLowerCase().equals("male"));
       Product product = new Product(name, details);

        boolean created = repo.createProduct(product);

        return (created ? "Product was created." : "Product Creation was failed!");
    }
    public String getProduct(int id){
        Product product = repo.getProduct(id);

        return(product == null ? "product was not found!" : product.toString());
    }
    public String getAllProducts() {
        List<Product> product = repo.getAllProducts();
        return product.toString();
    }
}
