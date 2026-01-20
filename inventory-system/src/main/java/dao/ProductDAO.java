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
             PreparedStatement ps = con.prepareStatement(query)) 
             {

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

    // Retrieve all products from database
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    Product p = new Product();

                    //Reading data from DB and setting into object
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setCategory(rs.getString("category"));
                    p.setPrice(rs.getDouble("price"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setMinStockLevel(rs.getInt("min_stock_level"));

                    list.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                }
            return list;
    }

    // Update Products
    public void updateProduct(Product product) {
        String query = "UPDATE products SET name=?, category=?, price=?, quantity=?, min_stock_level=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement  ps = con.prepareStatement(query)) {
                ps.setString(1, product.getName());
                ps.setString(2, product.getCategory());
                ps.setDouble(3, product.getPrice());
                ps.setInt(4, product.getQuantity());
                ps.setInt(5, product.getMinStockLevel());
                ps.setInt(6, product.getId());

                ps.executeUpdate();
                System.out.println("Product Updated Successfully")
             } catch (Exception e) {
                e.printStackTrace();
             }
    }
}
