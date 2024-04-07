package models;

import java.util.ArrayList;

import interfaces.ExchangeBooks;

public class Library implements ExchangeBooks {
    private ArrayList<User> users;

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
        Book loggedUserBook = searchBook(idLoggedUserBook);

        for (User normalUser : users) {
            if (normalUser.getBooks().contains(normalUserBook)) {
                normalUser.setMailbox(
                        usuarioLogged.getName() + " deseja trocar o livro " + loggedUserBook.getTitle()
                                + " com o seu livro " + normalUserBook.getTitle());

                normalUser.setLibraryBooks(normalUserBook);
                normalUser.setLibraryBooks(loggedUserBook);

                System.out.println("Sua mensagem de solicitação foi enviada para " + normalUser.getName()
                        + ". Aguarde pelo confirmação!");

                break;
            }
        }
    }

    public void showRequestExchanges(User normalUser) {
        int count = 0;
        for (int i = 0; i < normalUser.getBookExchangeRequest().size(); i++) {
            count = i;

            if (i == 0 || i % 2 == 0) {
                System.out.print((count + 1) + ". ");
                System.out.print(normalUser.getBookExchangeRequest().get(i).getTitle());
            } else {
                System.out.print("<->");
                System.out.println(normalUser.getBookExchangeRequest().get(i).getTitle());

            }
        }
    }

    public void exchangeBook(User usuarioLogged, int option) {
        Book loggedUserBook = usuarioLogged.getBookExchangeRequest().get(option - 1);
        Book normalUserBook = usuarioLogged.getBookExchangeRequest().get(option);

        for (User normalUser : users) {
            if (normalUser.getBooks().contains(normalUserBook)) {
                normalUserBook.setAvailable(false);
                loggedUserBook.setAvailable(false);

                usuarioLogged.setLivros(normalUserBook);
                removeBook(usuarioLogged, loggedUserBook);

                normalUser.setLivros(loggedUserBook);
                removeBook(normalUser, normalUserBook);

                break;
            }
        }
    }

    public void removeBook(User user, Book book) {
        int index = user.getBooks().indexOf(book);

        user.getBooks().remove(index);
    }

}
