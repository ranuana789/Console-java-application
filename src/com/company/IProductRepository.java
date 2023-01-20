package com.company;
import com.company.Product;
import java.util.List;
public interface IProductRepository {
    boolean createProduct(Product product);
//    Product gender(int id);
    List<Product> getAllProducts();

    Product getProduct(int id);
}
