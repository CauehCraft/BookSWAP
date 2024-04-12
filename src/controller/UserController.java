package controller;

import model.Book;
import model.User;

public class UserController {
    public void addBook(User user, Book book) {
        user.getBooks().add(book);
    }
    public void addLibraryBook(User user, Book book) {
        user.getBookExchangeRequest().add(book);
    }
}
