package dao;

import model.Product;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO = Data Access Object
 * This class handles ALL database operations related to Product.
 * Insert, Read, Update, Delete = CRUD
 */

public class ProductDAO {
    // Insert product into database
    public void addProduct(Product product){
        String query = "INSERT INTO products (name, category, price, quantity, min_stock_level) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

                //Set value into SQL Query
                ps.setString(1, product.getName());
                ps.setString(2, product.getCategory());
                ps.setDouble(3, product.getPrice());
                ps.setInt(4, product.getQuantity());
                ps.setInt(5, product.getMinStockLevel());

                ps.executeUpdate();
                System.out.println("Product added Successfully!");
                
             } catch (Exception e) {
                e.printStackTrace();
             }
    }
}
