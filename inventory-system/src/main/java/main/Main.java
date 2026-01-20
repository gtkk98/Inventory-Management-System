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
}
