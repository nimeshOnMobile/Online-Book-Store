package service;

import model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
}
