package model;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private int minStockLevel;

    // Default Constructor
    public Product() {

    }
    // parameter Constructor (used when inserting data)
    public Product(String name, String Category, double price, int quantity, int minStockLevel) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.minStockLevel = minStockLevel;
    }

    // getter and setter
    // used to read/write private variables safely

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getMinStockLevel(){
        return minStockLevel;
    }
    public void setMinStockLevel(int minStockLevel){
        this.minStockLevel = minStockLevel;
    }
}