package service;

import model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp1 implements BookService {

    private final List<Book> books;

    public BookServiceImp1(){
        // Initialize a hardcoded list of books
        this.books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 20.0));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", 18.0));
        books.add(new Book(3, "1984", "George Orwell", 15.5));

    }

    @Override
    public List<Book> getAllBooks(){
        return books;
    }

    @Override
    public Book getBookById(int id){
        for(int i=0;i< books.size();i++){
            Book x = books.get(i);
            if(x.getId() == id){
                return x;
            }
        }
        return null;
    }
}
