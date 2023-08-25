package com.bookstore.bookmanager.controllers;

import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.bookmanager.models.Book;
import com.bookstore.bookmanager.services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/books/")
@Validated
public class BookController {
  
  @Autowired
  private BookService bookService;

  @GetMapping("/{bookId}")
  public ResponseEntity<Book> findById(@PathVariable Long bookId){
    Book obj = this.bookService.findById(bookId);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<Void> create(@Valid @RequestBody Book obj){
    this.bookService.create(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/bookId").buildAndExpand(obj.getBook_id()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{bookId}")
  public ResponseEntity<Void> update(@Valid @RequestBody Book obj, @PathVariable Long bookId){
    obj.setBook_id(bookId);
    this.bookService.update(obj);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{bookId}")
  public ResponseEntity<Void> delete(@PathVariable Long bookId){
    this.bookService.delete(bookId);
    return ResponseEntity.noContent().build();
  }

}
