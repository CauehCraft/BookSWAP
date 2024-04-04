package screen;

import java.util.Scanner;

import models.Biblioteca;
import models.Livro;
import models.Usuario;

public class Menu {
    public static void displayMenu(Scanner input, Usuario usuario, Biblioteca biblioteca) {
        int opcao = 0;

        do {
            System.out.println("1. Listar livros disponíveis na biblioteca");
            System.out.println("2. Realizar troca de livro(s) na biblioteca");
            System.out.println("3. Adicionar livro à biblioteca");
            System.out.println("4. Visualizar meus livros");
            System.out.println("5. Visualizar mensagens");
            System.out.println("6. Visualizar trocas de livros ativas");
            System.out.println("7. Sair");
            System.out.print("informe sua opção: ");

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\nlistando livros da biblioteca...");
                    biblioteca.listarLivros();
                    break;

                case 2:
                    System.out.println("\nrealizando troca de livro na biblioteca...");
                    break;

                case 3:
                    System.out.println("\nadicionando livro à biblioteca...");
                    String titulo;
                    String autor;
                    int edicao;

                    System.out.print("Informe o titulo do livro: ");
                    titulo = input.nextLine();
                    System.out.print("Informe o autor do livro: ");
                    autor = input.nextLine();
                    System.out.print("Informe o ano de edição do livro: ");
                    edicao = Integer.parseInt(input.nextLine());

                    Livro livroDoUsuario = new Livro(1, titulo, autor, edicao);

                    usuario.setLivros(livroDoUsuario);

                    System.out.println("Livro cadastrado com sucesso!\n");
                    break;
                case 4:
                    System.out.println("\nvisualizando seus livros...");
                    if (usuario.getLivros().isEmpty()) {
                        System.out.println("Você não possui livros cadastrados!");
                    } else {
                        for (Livro livro : usuario.getLivros()) {
                            System.out.println(livro);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nvisualizando sua caixa de mensagens...");
                    for (String mensagem : usuario.getCaixaDeMensagens()) {
                        System.out.println(mensagem);
                    }
                    break;

                case 6:
                    System.out.println("\nvisualizando trocas de livros ativas...");
                    for (Livro livro : usuario.getLivrosDeBiblioteca()) {
                        System.out.println(livro);
                    }
                    break;

                case 7:
                    System.out.println("\nsaindo da conta...");
                    usuario.setSignIn(false);
                    break;

                default:
                    break;
            }
        } while (opcao != 7);

    }
}
