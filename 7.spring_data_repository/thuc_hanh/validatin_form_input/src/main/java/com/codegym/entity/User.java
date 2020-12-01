package com.codegym.entity;

public class User {

    @Not
    @Size(min = 2, max = 30)
    private String name;

    @Min(18)
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
