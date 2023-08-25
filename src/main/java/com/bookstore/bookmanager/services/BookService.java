package com.bookstore.bookmanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.bookmanager.models.Book;
import com.bookstore.bookmanager.repositories.BookRepository;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public Book findById(Long book_id){
    Optional<Book> book = this.bookRepository.findById(book_id);
    return book.orElseThrow(()-> new RuntimeException(
      "Book not found! Id:" + book_id
    ));
  }

  @Transactional
  public Book create(Book obj){
    obj.setBook_id(null);
    return this.bookRepository.save(obj);
  }

  @Transactional
  public Book update(Book obj){
    Book newObj = findById(obj.getBook_id());
    newObj.setTitle(obj.getTitle());
    newObj.setPrice(obj.getPrice());
    return this.bookRepository.save(newObj);
  }

  public void delete(Long id){
    try {
      this.bookRepository.deleteById(id);
    } catch (Exception e) {
      throw new RuntimeException("Can't delete object id " + id);
    }
  }
  
}
