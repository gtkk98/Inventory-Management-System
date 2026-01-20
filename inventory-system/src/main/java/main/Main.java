package main;

import java.sql.Connection;

import util.DBConnection;

import dao.ProductDAO;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Database Connected Successfully");
        } else {
            System.out.println("Database Connection Failed");
        }

        Scanner sc = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();

        int choice;

        do {
            // Display menu
            System.out.println("\n===== MINI ERP - INVENTORY SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    addProduct(sc, productDAO);
                    break;
                case 2:
                    viewAllProducts(productDAO);
                    break;
                case 3:
                    updateProduct(sc, productDAO);
                    break;
                case 4:
                    deleteProduct(sc, productDAO);
                    break;
                case 0:
                    System.out.println("Exiting system..");
                    break;
                default:
                    System.out.println("Inavlid choice!");
            }

        } while (choice !=0);
    }

    //Add Product
    private static void addProduct(Scanner sc, ProductDAO dao) {
        // Consume leftover newline
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        
        System.out.print("Enter Price:");
        double price = sc.nextDouble();

        System.out.print("Enter Quantitiy: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Minimum Stock Level: ");
        int minStock = sc.nextInt();

        //Create Product Object
        Product p = new Product(name, category, price, quantity, minStock);

        // Send to DAO
        dao.addProduct(p);

    }

    // View All Products
    private static void viewAllProducts(ProductDAO dao) {
        List<Product> products = dao.getAllProducts();

        System.out.println("\n----- Product List -----");
        for (Product p : products) {
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Category: " + p.getCategory());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Min Stock Level: " + p.getMinStockLevel());
            System.out.println("-----------------------");
        }
    }

    //Update Product
    private static void updateProduct(Scanner sc, ProductDAO dao) {
        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();

        // Consume leftover newline
        sc.nextLine();

        System.out.print("Enter New Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Category: ");
        String category = sc.nextLine();
        
        System.out.print("Enter New Price:");
        double price = sc.nextDouble();

        System.out.print("Enter New Quantitiy: ");
        int quantity = sc.nextInt();

        System.out.print("Enter New Minimum Stock Level: ");
        int minStock = sc.nextInt();

        //Create Product Object
        Product p = new Product(name, category, price, quantity, minStock);
        p.setId(id); // Set the ID for update

        // Send to DAO
        dao.updateProduct(p);
    }

    // Delete product
    private static void deleteProduct(Scanner sc, ProductDAO dao) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        dao.deleteProduct(id);
    }
}
