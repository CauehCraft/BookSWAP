package models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int edition;
    private boolean available;

    public Book(int id, String title, String author, int edition) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edicao) {
        this.edition = edicao;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "id: " + id + ", titulo: " + title + ", autor: " + author + ", edicao: " + edition + ", status: "
                + (available ? "diponível" : "não disponível");
    }

}
