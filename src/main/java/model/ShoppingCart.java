package model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    // Properties: List<Book> items, addBook(), removeBook(), getTotal(), etc.
    List<Book> items;

    public ShoppingCart(){
        this.items = new ArrayList<>();
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

    public void addBook(Book book){
        items.add(book);
    }

    public void removeBook(Book book){
        items.remove(book);
    }

    public double getTotal(){
        double total = 0;
        for(int i=0;i<items.size();i++){
            total += (items.get(i)).getPrice();
        }

        return total;
    }
}