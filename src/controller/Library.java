package controller;

import controller.interfaces.ExchangeBooks;
import controller.interfaces.Observer;
import controller.interfaces.Subject;

import java.util.ArrayList;

public class Library implements ExchangeBooks, Subject {
    private final ArrayList<User> users;
    private final ArrayList<Observer> observers = new ArrayList<>();

    public Library(ArrayList<User> users) {
        this.users = users;
    }

    public void showAvailableBooks(User loggedUser) {
        for (User user : users) {
            if (!user.getName().equals(loggedUser.getName())) {
                for (Book livro : user.getBooks()) {
                    if (livro.isAvailable()) {
                        System.out.println(livro);
                    }
                }

                System.out.println();
            }
        }
    }

    public Book searchBook(int id) {
        for (User user : users) {
            for (Book book : user.getBooks()) {
                if (book.getId() == id) {
                    return book;
                }
            }
        }

        return null;
    }

    public void requestExchange(int idNormalUserBook, int idLoggedUserBook, User usuarioLogged) {
        Book normalUserBook = searchBook(idNormalUserBook);
        if (normalUserBook == null) {
            System.out.println("\nlivro não encontrado!\n");

            return;
        }

        Book loggedUserBook = searchBook(idLoggedUserBook);
        if (loggedUserBook == null) {
            System.out.println("\nVocê não possui este livro!\n");

            return;
        }

        for (User normalUser : users) {
            if (normalUser.getBooks().contains(normalUserBook)) {
                normalUser.update(
                        usuarioLogged.getName() + " deseja trocar o livro " + loggedUserBook.getTitle()
                                + " com o seu livro " + normalUserBook.getTitle());

                normalUser.setLibraryBooks(normalUserBook);
                normalUser.setLibraryBooks(loggedUserBook);

                notifyObserver(normalUser, "\nSua mensagem de solicitação foi enviada para " + normalUser.getName()
                        + ". Aguarde pela confirmação!\n");

                break;
            }
        }
    }

    public void showRequestExchanges(User normalUser) {
        int count = 0;
        for (int i = 0; i < normalUser.getBookExchangeRequest().size(); i++) {
            count = i;

            if (i % 2 == 0) {
                System.out.print((count + 1) + ". ");
                System.out.print(normalUser.getBookExchangeRequest().get(i).getTitle());
            } else {
                System.out.print("<->");
                System.out.println(normalUser.getBookExchangeRequest().get(i).getTitle());

            }
        }
    }

    public void exchangeBook(User loggedUser, int chosenBook) {
        Book loggedUserBook = loggedUser.getBookExchangeRequest().get(chosenBook - 1);
        Book normalUserBook = loggedUser.getBookExchangeRequest().get(chosenBook);

        for (User normalUser : users) {
            if (normalUser.getBooks().contains(normalUserBook)) {
                normalUserBook.setAvailable(false);
                loggedUserBook.setAvailable(false);

                loggedUser.setLivros(normalUserBook);
                removeBook(loggedUser, loggedUserBook);

                normalUser.setLivros(loggedUserBook);
                removeBook(normalUser, normalUserBook);

                break;
            }
        }

        System.out.println("Sua troca de livro foi confirmada!\n");
    }

    public void removeBook(User user, Book book) {
        int index;

        if (user.isSignIn()) {
            while (user.getBookExchangeRequest().remove(book)) {
                index = user.getBookExchangeRequest().indexOf(book);

                user.getBookExchangeRequest().remove(index + 1);
            }
        }
        user.getBooks().remove(book);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Observer observer, String message) {
        observer.update(message);
    }

}
