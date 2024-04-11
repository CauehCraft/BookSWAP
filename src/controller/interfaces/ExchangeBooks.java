package controller.interfaces;

import controller.Book;
import controller.User;

public interface ExchangeBooks {
    public void requestExchange(int idNormalUserBook, int idLoggedUserBook, User usuarioLogged);

    public void showRequestExchanges(User normalUser);

    public void exchangeBook(User usuarioLogged, int option);

    public void removeBook(User user, Book book);
}