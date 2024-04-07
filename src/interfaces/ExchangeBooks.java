package interfaces;

import models.Book;
import models.User;

public interface ExchangeBooks {
    public void requestExchange(int idNormalUserBook, int idLoggedUserBook, User usuarioLogged);

    public void showRequestExchanges(User normalUser);

    public void exchangeBook(User usuarioLogged, int option);

    public void removeBook(User user, Book book);
}