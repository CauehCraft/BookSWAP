package models;

import java.util.ArrayList;

import interfaces.TrocaDeLivros;

public class Biblioteca implements TrocaDeLivros {
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

    public void solicitarTroca(int idDestino, int idOrigem, Usuario usuarioLogged) {
        Livro livroDestino = buscaLivro(idDestino);
        Livro livroOrigem = buscaLivro(idOrigem);

        for (Usuario usuarioNormal : usuarios) {
            if (usuarioNormal.getLivros().contains(livroDestino)) {
                usuarioNormal.setCaixaDeMensagens(
                        usuarioLogged.getNome() + " deseja trocar o livro " + livroOrigem.getTitulo()
                                + " com o seu livro " + livroDestino.getTitulo());

                usuarioNormal.setLivrosDeBiblioteca(livroDestino);
                usuarioNormal.setLivrosDeBiblioteca(livroOrigem);

                break;
            }
        }
    }

    public void mostrarSolicitacoesDeTrocas(Usuario usuarioNormal) {
        for (int i = 0; i < usuarioNormal.getLivrosDeBiblioteca().size(); i++) {
            if (i == 0 || i % 2 == 0) {
                System.out.print((i + 1) + ". ");
            } else {
                System.out.print("<->");
            }
            System.out.print(usuarioNormal.getLivrosDeBiblioteca().get(i).getTitulo());
            // System.out.println();
        }
    }

    public void realizarTroca(Usuario usuarioLogged, int opcao) {
        Livro livro1 = usuarioLogged.getLivrosDeBiblioteca().get(opcao - 1); // meu livro
        Livro livro2 = usuarioLogged.getLivrosDeBiblioteca().get(opcao); // teu livro

        for (Usuario usuarioNormal : usuarios) {
            if (usuarioNormal.getLivros().contains(livro2)) {
                livro2.setEstaDisponivel(false);
                livro1.setEstaDisponivel(false);

                usuarioLogged.setLivros(livro2);
                removerLivro(usuarioLogged, livro1);

                usuarioNormal.setLivros(livro1);
                removerLivro(usuarioNormal, livro2);

                break;
            }
        }
    }

    public void removerLivro(Usuario usuario, Livro livro) {
        int index = usuario.getLivros().indexOf(livro);

        usuario.getLivros().remove(index);
    }

}
