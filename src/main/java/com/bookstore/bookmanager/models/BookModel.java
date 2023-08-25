package com.bookstore.bookmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = BookModel.TABLE_NAME)
public class BookModel {
  public static final String TABLE_NAME = "books";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id", unique = true)
  private Long book_id;

  @Column(name = "title", length = 100, nullable = false)
  @NotNull
  @NotEmpty
  @Size(max = 100)
  private String title;

  @Column(name = "price", precision = 2)
  private Double price;


  public BookModel() {}

  public BookModel(Long book_id, String title, Double price) {
    this.book_id = book_id;
    this.title = title;
    this.price = price;
  }

  public Long getBook_id() {
    return this.book_id;
  }

  public void setBook_id(Long book_id) {
    this.book_id = book_id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
