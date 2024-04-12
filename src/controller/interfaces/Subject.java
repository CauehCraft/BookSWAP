package controller.interfaces;

import model.Library;

public interface Subject {
    public void registerObserver(Library library, Observer observer);
    public void removeObserver(Library library, Observer observer);
    public void notifyObserver(Observer observer, String message);
}
