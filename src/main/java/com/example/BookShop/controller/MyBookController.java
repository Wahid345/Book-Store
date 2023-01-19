package com.example.BookShop.controller;

import com.example.BookShop.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {
    @Autowired
    private MyBookService service;
    @RequestMapping("/deleteMylist/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        service.DeleteId(id);
        return "redirect:/my_books";
    }
}
