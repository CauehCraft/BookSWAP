package controller;

import controller.observer.Observer;
import controller.observer.Subject;
import model.Book;
import model.Library;
import model.User;
import view.BookSwap;

public class LibraryController implements Subject {
    public void showAvailableBooks(Library library, User loggedUser) {
        for (User user : library.getUsers()) {
            if (!user.getName().equals(loggedUser.getName())) {
                for (Book book : user.getBooks()) {
                    if (book.isAvailable()) {
                        System.out.println(book);
                    }
                }

                System.out.println();
            }
        }
    }

    public Book searchBook(Library library, int id) {
        for (User user : library.getUsers()) {
            for (Book book : user.getBooks()) {
                if (book.getId() == id) {
                    return book;
                }
            }
        }

        return null;
    }

    public void requestExchange(Library library, int idNormalUserBook, int idLoggedUserBook, User loggedUser) {
        Book normalUserBook = searchBook(library, idNormalUserBook);
        if (normalUserBook == null) {
            System.out.println("\nlivro não encontrado!\n");

            return;
        }

        Book loggedUserBook = searchBook(library, idLoggedUserBook);
        if (loggedUserBook == null) {
            System.out.println("\nVocê não possui este livro!\n");

            return;
        }

        for (User normalUser : library.getUsers()) {
            if (normalUser.getBooks().contains(normalUserBook)) {
                notifyObserver(normalUser,
                        loggedUser.getName() + " deseja trocar o livro " + loggedUserBook.getTitle()
                                + " com o seu livro " + normalUserBook.getTitle());

                BookSwap.userController.addLibraryBook(normalUser, normalUserBook);
                BookSwap.userController.addLibraryBook(normalUser, loggedUserBook);

                System.out.println("\nSua mensagem de solicitação foi enviada para " + normalUser.getName()
                        + ". Aguarde pela confirmação!\n");

                break;
            }
        }
    }

    public void showRequestExchanges(User normalUser) {
        for (int i = 0; i < normalUser.getBookExchangeRequest().size(); i += 2) {
            System.out.print((i / 2 + 1) + ". ");
            System.out.print(normalUser.getBookExchangeRequest().get(i).getTitle());
            if (i + 1 < normalUser.getBookExchangeRequest().size()) {
                System.out.print(" <-> ");
                System.out.println(normalUser.getBookExchangeRequest().get(i + 1).getTitle());
            }
        }
    }

    public void exchangeBook(Library library, User loggedUser, int chosenBook) {
        Book loggedUserBook = loggedUser.getBookExchangeRequest().get(chosenBook - 1);
        Book normalUserBook = loggedUser.getBookExchangeRequest().get(chosenBook);

        for (User normalUser : library.getUsers()) {
            if (normalUser.getBooks().contains(normalUserBook)) {
                normalUserBook.setAvailable(false);
                loggedUserBook.setAvailable(false);

                BookSwap.userController.addBook(loggedUser, normalUserBook);
                removeBook(loggedUser, loggedUserBook);

                BookSwap.userController.addBook(normalUser, loggedUserBook);
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
    public void registerObserver(Library library, Observer observer) {
        library.getObservers().add(observer);
    }

    @Override
    public void removeObserver(Library library, Observer observer) {
        library.getObservers().remove(observer);
    }

    @Override
    public void notifyObserver(Observer observer, String message) {
        observer.update(message);
    }
}
