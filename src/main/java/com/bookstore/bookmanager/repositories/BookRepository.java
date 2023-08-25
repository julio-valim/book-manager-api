package com.bookstore.bookmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookmanager.models.BookModel;

public interface BookRepository extends JpaRepository <BookModel, Long>{}
