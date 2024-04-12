package model;

import controller.interfaces.Observer;

import java.util.ArrayList;

public class Library {
    private ArrayList<User> users;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Library(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "users=" + users +
                ", observers=" + observers +
                '}';
    }
}
