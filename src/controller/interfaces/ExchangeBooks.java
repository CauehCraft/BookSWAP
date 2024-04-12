package controller.interfaces;

import model.Book;
import model.Library;
import model.User;

public interface ExchangeBooks {
    public void requestExchange(Library library, int idNormalUserBook, int idLoggedUserBook, User usuarioLogged);

    public void showRequestExchanges(User normalUser);

    public void exchangeBook(Library library, User loggedUser, int chosenBook);

    public void removeBook(User user, Book book);
}