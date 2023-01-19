package com.example.BookShop.service;

import com.example.BookShop.entities.MyBooklist;
import com.example.BookShop.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository mybook;

    public void saveMyBooks(MyBooklist book){
        mybook.save(book);
    }
    public List<MyBooklist> getAllMyBooks(){
        return mybook.findAll();
    }
    public void DeleteId(int id){
        mybook.deleteById(id);
    }
}
