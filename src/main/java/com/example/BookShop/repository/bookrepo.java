package com.example.BookShop.repository;


import com.example.BookShop.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookrepo extends JpaRepository<BookEntity,Integer> {
}
