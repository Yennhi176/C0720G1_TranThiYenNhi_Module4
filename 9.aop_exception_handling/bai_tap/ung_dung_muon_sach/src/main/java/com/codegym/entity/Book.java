package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private Integer amount;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "card_book",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "card_id"))
////    @JsonManagedReference
//    private Set<Card> cardSet;

    public Book() {
    }

    public Book(String nameBook, Integer amount) {
        this.nameBook = nameBook;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

//    public Set<Card> getCardSet() {
//        return cardSet;
//    }
//
//    public void setCardSet(Set<Card> cardSet) {
//        this.cardSet = cardSet;
//    }
}
