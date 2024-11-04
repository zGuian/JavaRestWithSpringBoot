package com.estudos.JavaRestWithSpringBoot.Models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Serial
    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "launch_date")
    private LocalDate launch_date;

    @Column(name = "price")
    private Double price;

    @Column(name = "title")
    private String title;

    public Book() { }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public LocalDate getLaunch_date() { return launch_date; }
    public void setLaunch_date(LocalDate launch_date) { this.launch_date = launch_date; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Book CreateNewBook(String author, LocalDate launch_date, Double price, String title) {
        Book nBook = new Book();
        nBook.author = author;
        nBook.launch_date = launch_date;
        nBook.price = price;
        nBook.title = title;
        return nBook;
    }
}
