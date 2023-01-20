package com.company;

import com.company.IDB;
import com.company.Product;
import com.company.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final IDB db;

    public ProductRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createProduct(Product product) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "insert into product(name, details) values (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, product.getName());

            st.setString(2, product.getDetails());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public Product getProduct(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "Select id, name, details FROM product WHERE id =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                rs.getString("name"), rs.getString("details"));

                return product;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "Select id, name, details FROM product ";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Product> products = new LinkedList<>();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                rs.getString("name"), rs.getString("details"));

                    products.add(product);
            }
            return products;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}




