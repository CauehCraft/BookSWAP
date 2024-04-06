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

    public Livro buscaLivro(int id) {
        for (Usuario usuario : usuarios) {
            for (Livro livro : usuario.getLivros()) {
                if (livro.getId() == id) {
                    return livro;
                }
            }
        }

        return null;
    }

    public void solicitarTroca(int idDestino, int idOrigem, String nomeDoUsuario) {
        Livro livroDestino = buscaLivro(idDestino);
        Livro livroOrigem = buscaLivro(idOrigem);

        for (Usuario usuario : usuarios) {
            if (usuario.getLivros().contains(livroDestino)) {
                usuario.setCaixaDeMensagens(nomeDoUsuario + " deseja trocar o livro " + livroOrigem.getTitulo()
                        + " com o seu livro " + livroDestino.getTitulo());
                break;
            }
        }
    }
}
