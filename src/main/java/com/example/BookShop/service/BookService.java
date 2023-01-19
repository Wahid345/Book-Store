package com.example.BookShop.service;

import com.example.BookShop.entities.BookEntity;
import com.example.BookShop.repository.bookrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private bookrepo brepo;
    public void save(BookEntity b){
        brepo.save(b);
    }
    public List<BookEntity> getAllBook(){
        return brepo.findAll();
    }
    public BookEntity getBookById(int id){
        return brepo.findById(id).get();
    }
    public void deleteById(int id){
        brepo.deleteById(id);
    }
}
