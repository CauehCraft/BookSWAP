package screen;

import java.util.Scanner;
import java.util.Random;

import models.Biblioteca;
import models.Livro;
import models.Usuario;

public class Menu {
    public static void displayMenu(Scanner input, Usuario usuario, Biblioteca biblioteca) {
        Random random = new Random();
        String titulo;
        String autor;
        int edicao;
        int meuLivro; // id do meu livro
        int livroDesejado; // id do livro que eu quero
        int opcao = 0;
        int escolha = 0;

        do {
            System.out.println("1. Listar livros disponíveis na biblioteca");
            System.out.println("2. Solicitar troca de livro(s) na biblioteca");
            System.out.println("3. Adicionar livro à biblioteca");
            System.out.println("4. Visualizar meus livros");
            System.out.println("5. Visualizar Caixa de mensagens");
            System.out.println("6. Realizar troca de livro");
            System.out.println("7. Sair");
            System.out.print("informe sua opção: ");

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\nlistando livros da biblioteca...");
                    biblioteca.listarLivros();
                    break;

                case 2:
                    System.out.println("\nsolicitando troca de livro na biblioteca...");

                    System.out.print("Informe o id do livro desejado: ");
                    livroDesejado = Integer.parseInt(input.nextLine());

                    System.out.print("informe o id do seu livro a ser trocado: ");
                    meuLivro = Integer.parseInt(input.nextLine());

                    biblioteca.solicitarTroca(livroDesejado, meuLivro, usuario);

                    break;

                case 3:
                    System.out.println("\nadicionando livro à biblioteca...");

                    System.out.print("Informe o titulo do livro: ");
                    titulo = input.nextLine();
                    System.out.print("Informe o autor do livro: ");
                    autor = input.nextLine();
                    System.out.print("Informe o ano de edição do livro: ");
                    edicao = Integer.parseInt(input.nextLine());

                    Livro livroDoUsuario = new Livro(random.nextInt(30), titulo, autor, edicao);

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
                    System.out.println("\nrealizando troca de livros...");

                    biblioteca.mostrarSolicitacoesDeTrocas(usuario);
                    System.out.print("\nselecione sua opção de troca: ");
                    escolha = Integer.parseInt(input.nextLine());

                    biblioteca.realizarTroca(usuario, escolha);

                    System.out.println("troca bem feita");

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
