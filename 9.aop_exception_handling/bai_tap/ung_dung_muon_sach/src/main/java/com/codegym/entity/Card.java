package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_borrwed",columnDefinition = "DATE")
    private String dateBorrowed;
    @Column(name = "pay_day",columnDefinition = "DATE")
    private String payDay;
    private Integer bookNumber;
//    @ManyToMany(mappedBy = "cardSet")
////    @JsonManagedReference
//    private Set<Book> bookSet;

    public Card() {
    }

    public Card(String dateBorrowed, String payDay) {
        this.dateBorrowed = dateBorrowed;
        this.payDay = payDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(String dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public String getPayDay() {
        return payDay;
    }

    public void setPayDay(String payDay) {
        this.payDay = payDay;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }
//    public Set<Book> getBookSet() {
//        return bookSet;
//    }
//
//    public void setBookSet(Set<Book> bookSet) {
//        this.bookSet = bookSet;
//    }
}
