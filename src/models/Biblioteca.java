package models;

import java.util.ArrayList;

import interfaces.TrocaDeLivro;

public class Biblioteca implements TrocaDeLivro {
    private ArrayList<Usuario> usuarios;

    public Biblioteca(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void listarLivros() {
        for (Usuario usuario : usuarios) {
            System.out.println("Usuário: " + usuario.getNome() + ". Livros em posse: ");
            for (Livro livro : usuario.getLivros()) {
                if (livro.isEstaDisponivel()) {
                    System.out.println(livro);
                }
            }
            System.out.println();
        }
    }

    public void solicitarTroca(Usuario usuario, String nomeDoLivro) {
        for (Livro livro : usuario.getLivros()) {
            if (livro.getTitulo().equals(nomeDoLivro)) {
                usuario.setCaixaDeMensagens("Livro que querem emprestado: " + livro.toString());
            }
        }
    }
}
