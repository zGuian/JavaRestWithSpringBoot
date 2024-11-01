package com.estudos.JavaRestWithSpringBoot.Services;

import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.BookVO;
import com.estudos.JavaRestWithSpringBoot.Exceptions.ResourceNotFoundException;
import com.estudos.JavaRestWithSpringBoot.Mapper.DozerMapper;
import com.estudos.JavaRestWithSpringBoot.Models.Book;
import com.estudos.JavaRestWithSpringBoot.Repository.BookRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServices {
    private final Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
    private BookRepository repository;

    public List<BookVO> findAll() {
        logger.info("Find many books to database");
        List<Book> entity = repository.findAll();
        return DozerMapper.parseListObjects(entity, BookVO.class);
    }

    public BookVO findById(int id) {
        logger.info(String.format("find id %d to database", id));
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        return DozerMapper.parseObject(entity, BookVO.class);
    }

    public BookVO createBook(BookVO bookVO) {
        logger.info("create a book: " + bookVO.getTitle());
        var entity = DozerMapper.parseObject(bookVO, Book.class);
        repository.save(entity);
        return DozerMapper.parseObject(entity, BookVO.class);
    }

    public BookVO updateBook(BookVO bookVO) {
        logger.info("Updated book");
        var fBook = repository.findById(bookVO.getId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
        Book nBook = fBook.CreateNewBook(bookVO.getAuthor(), bookVO.getLaunch_date(), bookVO.getPrice(), bookVO.getTitle());
        repository.save(nBook);
        return DozerMapper.parseObject(nBook, BookVO.class);
    }

    public void deleteBook(int id) {
        logger.info("Deleted book for database");
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        repository.deleteById(id);
    }
}
