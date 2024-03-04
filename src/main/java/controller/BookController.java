package controller;

import model.Book;
import model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.BookService;

import java.util.List;

@Component
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ShoppingCart shoppingCart;

    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    public Book getBookById(int id){
        return bookService.getBookById(id);
    }

    public List<Book> getShoppingCart(){
        return shoppingCart.getItems();
    }

    public void addToCart(int id){
        Book bookToAdd = bookService.getBookById(id);

        if(bookToAdd != null){
            shoppingCart.addBook(bookToAdd);
        }
    }

    public void removeFromCart(int id){
        Book bookToRemove = bookService.getBookById(id);

        if(bookToRemove != null){
            shoppingCart.removeBook(bookToRemove);
        }
    }
}
