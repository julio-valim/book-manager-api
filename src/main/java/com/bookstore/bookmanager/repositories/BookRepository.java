package com.bookstore.bookmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookmanager.models.Book;

public interface BookRepository extends JpaRepository <Book, Long>{}
