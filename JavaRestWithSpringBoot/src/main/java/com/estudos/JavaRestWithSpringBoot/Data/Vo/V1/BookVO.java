package com.estudos.JavaRestWithSpringBoot.Data.Vo.V1;

import com.estudos.JavaRestWithSpringBoot.Models.Book;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class BookVO implements Serializable {
    @Serial
    private static  final long serialVersionUID = 1L;
    private int id;
    private String author;
    private LocalDate launch_date;
    private Double price;
    private String title;

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

    public BookVO CreateNewBook(String author, LocalDate launch_date, Double price, String title) {
        BookVO nBookVO = new BookVO();
        nBookVO.author = author;
        nBookVO.launch_date = launch_date;
        nBookVO.price = price;
        nBookVO.title = title;
        return nBookVO;
    }
}

