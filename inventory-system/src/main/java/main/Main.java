package main;

import java.sql.Connection;

import util.DBConnection;

public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Database Connected Successfully");
        } else {
            System.out.println("Database Connection Failed");
        }
    }
}
