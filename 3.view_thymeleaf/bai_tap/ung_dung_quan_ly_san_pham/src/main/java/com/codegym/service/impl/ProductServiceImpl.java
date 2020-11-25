package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> productMap;
    static {
        productMap = new TreeMap<>();
        productMap.put(1,new Product(1,"dien thoai","Viet Nam",123));
        productMap.put(2,new Product(2,"dien thoai","Viet Nam",123));
        productMap.put(3,new Product(3,"dien thoai","Viet Nam",123));
        productMap.put(4,new Product(4,"dien thoai","Viet Nam",123));
        productMap.put(5,new Product(5,"dien thoai","Viet Nam",123));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
