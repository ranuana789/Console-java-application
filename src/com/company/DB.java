package com.company;

import java.sql.SQLException;
import java.sql.*;

import com.company.IDB;

public class DB implements IDB {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("opened ok");
        String connectionUrl = "jdbc:postgresql://localhost:54321/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "0000");
            return con;

        } catch (Exception e) {
            System.out.println(e);
            throw e;
      }


    }

}
