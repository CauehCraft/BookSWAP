package screen;

import java.util.Scanner;

import models.Library;
import models.Book;
import models.User;
import test.DemoApp;

public class Menu {
    public static void displayMenu(Scanner input, User loggedUser, Library library) {
        String title;
        String author;
        int edition;
        int idLoggedUserBook;
        int idNormalUserBook;
        int menuAction = 0;
        int option = 0;

        do {
            System.out.println("1. Listar livros disponíveis na biblioteca");
            System.out.println("2. Solicitar troca de livro(s) na biblioteca");
            System.out.println("3. Adicionar livro à biblioteca");
            System.out.println("4. Visualizar meus livros");
            System.out.println("5. Visualizar Caixa de mensagens");
            System.out.println("6. Confirmar troca de livro");
            System.out.println("7. Sair");
            System.out.print("informe sua opção: ");

            menuAction = Integer.parseInt(input.nextLine());

            switch (menuAction) {
                case 1:
                    System.out.println("\nlistando livros da biblioteca...");
                    library.showAvailableBooks(loggedUser);

                    break;

                case 2:
                    System.out.print("\nsolicitando troca de livro na biblioteca...");

                    if (loggedUser.getBooks().isEmpty()) {
                        System.out.println(" você não possui livros para trocar!\n");

                        break;
                    }

                    System.out.print("\ninforme o id do livro desejado: ");
                    idNormalUserBook = Integer.parseInt(input.nextLine());

                    System.out.print("informe o id do seu livro a ser trocado: ");
                    idLoggedUserBook = Integer.parseInt(input.nextLine());

                    library.requestExchange(idNormalUserBook, idLoggedUserBook, loggedUser);

                    break;

                case 3:
                    System.out.println("\nadicionando livro à biblioteca...");

                    System.out.print("Informe o titulo do livro: ");
                    title = input.nextLine();

                    System.out.print("Informe o autor do livro: ");
                    author = input.nextLine();

                    System.out.print("Informe o ano de edição do livro: ");
                    edition = Integer.parseInt(input.nextLine());

                    Book loggedUserBook = new Book(++DemoApp.idBook, title, author, edition);

                    loggedUser.setLivros(loggedUserBook);

                    System.out.println("\nLivro cadastrado com sucesso!\n");

                    break;

                case 4:
                    System.out.println("\nvisualizando seus livros...");

                    if (loggedUser.getBooks().isEmpty()) {
                        System.out.println("Você não possui livros cadastrados!");
                    } else {
                        for (Book livro : loggedUser.getBooks()) {
                            System.out.println(livro);
                        }
                        System.out.println();
                    }

                    break;

                case 5:
                    System.out.println("\nvisualizando sua caixa de mensagens...");

                    for (String message : loggedUser.getMailbox()) {
                        System.out.println(message);
                    }

                    System.out.println();
                    break;

                case 6:
                    System.out.println("\nrealizando troca de livros...");

                    library.showRequestExchanges(loggedUser);
                    System.out.print("\nselecione sua opção de troca: ");

                    option = Integer.parseInt(input.nextLine());

                    library.exchangeBook(loggedUser, option);

                    System.out.println("Sua troca foi confirmada!\n");

                    break;

                case 7:
                    System.out.println("\nsaindo da conta...");

                    loggedUser.setSignIn(false);

                    break;

                default:
                    break;
            }
        } while (menuAction != 7);

    }
}
