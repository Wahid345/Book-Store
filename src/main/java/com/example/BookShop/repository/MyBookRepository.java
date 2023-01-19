package com.example.BookShop.repository;

import com.example.BookShop.entities.MyBooklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooklist,Integer> {

}
