package com.example.BookShop.controller;


import com.example.BookShop.entities.BookEntity;
import com.example.BookShop.entities.MyBooklist;
import com.example.BookShop.service.BookService;
import com.example.BookShop.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class controller {
        @Autowired
        private BookService service;
        @Autowired
        private MyBookService myBookservice;
    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/book_register")
    public String BookRegister() {

        return "BookRegister";
    }
    @GetMapping("/Available_books")
    public ModelAndView AvailableBooks(){
        List<BookEntity> list=service.getAllBook();
       // ModelAndView mv=new ModelAndView();
      //  mv.setViewName("booklist");
      //  mv.addObject("book",list);
        return new ModelAndView("booklist","book",list);

    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute BookEntity b){
        service.save(b);
        return "redirect:/Available_books";
    }
    @GetMapping("/my_books")
    public String mybooks(Model model){
        List<MyBooklist> list=myBookservice.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMylist(@PathVariable("id") int id ){
        BookEntity b=service.getBookById(id);
        MyBooklist mb= new MyBooklist(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookservice.saveMyBooks(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String bookedit(@PathVariable("id") int id,Model model){
        BookEntity b=service.getBookById(id);
        model.addAttribute("book",b);
        return "BookEdit";
    }
    @RequestMapping("/deleteBook{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/Available_books";

    }

}

