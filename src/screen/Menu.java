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
            System.out.println("3. Visualizar meus livros");
            System.out.println("4. Visualizar mensagens");
            System.out.println("5. Visualizar trocas de livros ativas");
            System.out.println("6. Sair");
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
                    System.out.println("\nvisualizando seus livros...");
                    for (Livro livro : usuario.getLivros()) {
                        System.out.println(livro);
                    }
                    break;

                case 4:
                    System.out.println("\nvisualizando sua caixa de mensagens...");
                    for (String mensagem : usuario.getCaixaDeMensagens()) {
                        System.out.println(mensagem);
                    }
                    break;

                case 5:
                    System.out.println("\nvisualizando trocas de livros ativas...");
                    for (Livro livro : usuario.getLivrosDeBiblioteca()) {
                        System.out.println(livro);
                    }
                    break;

                case 6:
                    System.out.println("\nsaindo da conta...");
                    break;

                default:
                    break;
            }
        } while (opcao != 6);

    }
}
