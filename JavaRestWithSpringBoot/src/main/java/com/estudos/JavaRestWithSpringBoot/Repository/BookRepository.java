package com.estudos.JavaRestWithSpringBoot.Repository;

import com.estudos.JavaRestWithSpringBoot.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
