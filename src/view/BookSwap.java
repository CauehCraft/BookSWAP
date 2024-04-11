package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Library;
import controller.Book;
import controller.User;

public class BookSwap {
    public static boolean exitProgram = false;
    public static User loggedUser;
    public static int idBook = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        User user;
        Book book;
        Library library;

        user = new User(1, "Heitor", "h@gmail.com", "123");
        book = new Book(++idBook, "Dom Casmurro", "Machado de Assis", 2012);
        user.setLivros(book);

        users.add(user);

        user = new User(2, "Caueh", "c@gmail.com", "123");
        book = new Book(++idBook, "Duna", "Frank", 2017);
        user.setLivros(book);

        users.add(user);

        library = new Library(users);

        while (!exitProgram) {
            LoginSignUp.displayLoginSignUp(input, users, library);
            if (exitProgram) {
                break;
            }
            Menu.displayMenu(input, loggedUser, library);
        }

        input.close();
    }
}
