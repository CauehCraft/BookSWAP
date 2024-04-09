package models;

import java.util.ArrayList;
import interfaces.Observer;

public class User implements Observer{
    private int id;
    private boolean signIn;
    private String name;
    private String email;
    private String password;
    private ArrayList<Book> books;
    private ArrayList<Book> bookExchangeRequest; // stores the books for exchange
    private ArrayList<String> mailbox;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.signIn = false;

        books = new ArrayList<>();
        bookExchangeRequest = new ArrayList<>();
        mailbox = new ArrayList<>();
    }

    public ArrayList<String> getMailbox() {
        return mailbox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setLivros(Book book) {
        this.books.add(book);
    }

    public ArrayList<Book> getBookExchangeRequest() {
        return bookExchangeRequest;
    }

    public void setLibraryBooks(Book libraryBook) {
        this.bookExchangeRequest.add(libraryBook);
    }

    /* 
    public void setMailbox(String message) {
        this.mailbox.add(message);
    } 
    */

    @Override
    public void update(String message) {
        this.mailbox.add(message);
    }

    @Override
    public String toString() {
        return "id: " + id + ", nome: " + name + ", email: " + email;
    }

}
