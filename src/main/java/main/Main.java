package main;

import config.ProjectConfig;
import controller.BookController;
import model.Book;
import model.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        BookController bookController = context.getBean(BookController.class);
        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);

        while (true){
            displayMenu();
            int choice = getUserChoice();

            switch (choice){
                case 1:
                    displayAllBooks(bookController);
                    break;
                case 2:
                    displayBookDetails(bookController);
                    break;
                case 3:
                    addToCart(bookController, shoppingCart);
                    break;
                case 4:
                    removeFromCart(bookController, shoppingCart);
                    break;
                case 5:
                    displayShoppingCart(shoppingCart);
                    break;
                case 0:
                    System.out.println("Exiting the application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu(){
        System.out.println("\n ---Online BookStore");
        System.out.println("1. Display all books");
        System.out.println("2. Display book details");
        System.out.println("3. Add book to cart");
        System.out.println("4. Remove book from cart");
        System.out.println("5. Display shopping cart");
        System.out.println("0. Exit");
    }

    private static int getUserChoice(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        return inp.nextInt();
    }

    private static void displayAllBooks(BookController bookController){
        List<Book> books = bookController.getAllBooks();
        System.out.println("\n---All Books---");
        for(var i = 0; i<books.size(); i++){
            Book x = books.get(i);
            System.out.println(x.getId() + ". " + x.getTitle());
        }
    }

    private static void displayBookDetails(BookController bookController){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter book ID:");
        int bookId = inp.nextInt();

        Book book = bookController.getBookById(bookId);
        if(book != null){
            System.out.println("\n---Book Details---");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: " + book.getPrice());
        }
        else{
            System.out.println("Book not found");
        }
    }

    private static void addToCart(BookController bookController, ShoppingCart shoppingCart){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Book ID to add to cart: ");
        int bookId = inp.nextInt();
        bookController.addToCart(bookId);
        System.out.println("Book added to the shopping cart");
    }

    private static void removeFromCart(BookController bookController, ShoppingCart shoppingCart){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Book ID to remove from cart: ");
        int bookId = inp.nextInt();
        bookController.removeFromCart(bookId);
        System.out.println("Book removed from the shopping cart");
    }

    private static void displayShoppingCart(ShoppingCart shoppingCart){
        List<Book> cart = shoppingCart.getItems();
        System.out.println("\n---Shopping Cart---");
        for(int i=0;i< cart.size();i++){
            Book x = cart.get(i);
            System.out.println(x.getTitle() + " - $" + x.getPrice());
        }
        System.out.println("Total: $" + shoppingCart.getTotal());
    }
}