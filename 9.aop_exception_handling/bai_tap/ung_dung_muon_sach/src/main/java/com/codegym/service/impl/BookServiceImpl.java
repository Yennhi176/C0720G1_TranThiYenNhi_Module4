package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.Card;
import com.codegym.repository.BookRepository;
import com.codegym.repository.CardRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public String borrowBooks(Integer id) throws Exception {
        Book book = findById(id);
        if (book.getAmount() == 0) {
            throw new Exception("Hết sách này !");
        } else {
            book.setAmount(book.getAmount() - 1);
            Card card = new Card();
            card.setId((int) (Math.random() * 100));
            card.setBookNumber((int) ((Math.random() * 99999) + 10000));
            this.cardRepository.save(card);
            return String.valueOf(card.getBookNumber());
        }
    }

    @Override
    public String giveBookBack(Integer id, Integer bookNumber) {
        List<Card> cardList = cardRepository.findAll();
        boolean check = false;
        for (Card card : cardList) {
            if (card.getBookNumber().equals(bookNumber)) {
                check = true;
                Book book = findById(id);
                book.setAmount(book.getAmount() + 1);
                this.cardRepository.delete(card);
                break;
            }

        }
        if (check) {
            return "Give Complete !";
        } else {
            return "No Book";
        }


    }
}
