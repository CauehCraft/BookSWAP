package models;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;

    public Biblioteca(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void listarLivros() {
        for (Usuario usuario : usuarios) {
            System.out.println("Usuário: " + usuario.getNome() + ". Livros em posse: ");
            for (Livro livro : usuario.getLivros()) {
                System.out.println(livro);
            }
            System.out.println();
        }
    }
}
