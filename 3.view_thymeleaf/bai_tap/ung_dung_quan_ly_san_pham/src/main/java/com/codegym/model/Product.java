package com.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private String producer;
    private double price;

    public Product() {
    }

    public Product(int id, String nameProduct, String producer, double price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.producer = producer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
