package models;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private boolean signIn;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Livro> livros;
    private ArrayList<Livro> livrosDeBiblioteca; // troca l1--l2
    private ArrayList<String> caixaDeMensagens;

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.signIn = false;

        livros = new ArrayList<>();
        livrosDeBiblioteca = new ArrayList<>();
        caixaDeMensagens = new ArrayList<>();
    }

    public ArrayList<String> getCaixaDeMensagens() {
        return caixaDeMensagens;
    }

    public void setCaixaDeMensagens(String mensagem) {
        this.caixaDeMensagens.add(mensagem);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Livro livro) {
        this.livros.add(livro);
    }

    public ArrayList<Livro> getLivrosDeBiblioteca() {
        return livrosDeBiblioteca;
    }

    public void setLivrosDeBiblioteca(Livro livrosDeBiblioteca) {
        this.livrosDeBiblioteca.add(livrosDeBiblioteca);
    }

    @Override
    public String toString() {
        return "id: " + id + ", nome: " + nome + ", email: " + email;
    }

}
