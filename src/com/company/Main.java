package com.company;

import java.sql.*;
import java.sql.Connection;
import com.company.IDB;
import com.company.ProductRepository;
import com.company.IProductRepository;
public class Main {
    public static void main(String[] args) {


        IDB db = new DB();
        IProductRepository repo = new ProductRepository(db);
        MyApplication app = new MyApplication(repo);
        app.start();



    }

}
