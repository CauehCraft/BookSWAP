package view;

import model.Library;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class LoginSignUp {
    public static void displayLoginSignUp(Scanner input, ArrayList<User> users, Library library) {
        String email;
        String password;
        int option;

        System.out.println("Bem-vindo(a) ao BookSwap!");
        try {
            do {
                System.out.println("1. Sign In");
                System.out.println("2. Cadastre-se");
                System.out.println("3. Sair do programa");
                System.out.print("Informe sua opção: ");
                option = Integer.parseInt(input.nextLine());

                switch (option) {
                    case 1:
                        System.out.println("\nfazendo loggin...");

                        //aqui
                        //System.out.print("Informe seu email: ");
                        email = getEmailFromUser(input);
                        //fim
                        System.out.print("Informe sua senha: ");
                        password = input.nextLine();

                        if (areThereUser(email, password, users)) {
                            System.out.println("\nusuário encontrado! Entrando no programa...\n");
                            BookSwap.loggedUser.setSignIn(true);
                            BookSwap.libraryController.registerObserver(library, BookSwap.loggedUser);

                            return;
                        } else {
                            System.out.println("\nemail ou senha inválido!\n");
                        }

                        break;

                    case 2:
                        System.out.println("\nfazendo cadastro na plataforma...");

                        String name;

                        //System.out.print("Informe seu nome: ");
                        name = getNomeFromUser(input);

                        //System.out.print("Informe seu email: ");
                        email = getEmailFromUser(input); //.nextLine();

                        if (areThereEmail(email, users)) {
                            System.out.println("\nEmail já existente!\n");

                            break;
                        }


                        System.out.print("Informe sua senha: ");
                        password = input.nextLine();

                        User user = new User(1, name, email, password);

                        users.add(user);

                        System.out.println("\nusuário criado com sucesso!\n");

                        break;

                    case 3:
                        System.out.println("encerrando programa...");
                        BookSwap.exitProgram = true;

                        break;
                    default:
                        break;

                }
            } while (option != 3);
        } catch (NumberFormatException e) {
            System.out.println("formato de entrada incorreto!");

            LoginSignUp.displayLoginSignUp(input, users, library);
        }
    }

    public static boolean areThereUser(String email, String password, ArrayList<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                BookSwap.loggedUser = user;

                return true;
            }
        }

        return false;
    }

    public static String getNomeFromUser(Scanner scanner) {
        String nomePattern = "^[\\p{L} '-]+$";
        String nome;
        while (true) {
            System.out.print("Por favor, digite seu nome: ");
            nome = scanner.nextLine();
            if (nome.matches(nomePattern)) {
                return nome;
            } else {
                System.out.println("\nNome inválido. Tente novamente.\n");
            }
        }
    }


    public static String getEmailFromUser(Scanner scanner) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String email;
        while (true) {
            System.out.print("Por favor, digite um email: ");
            email = scanner.nextLine();
            if (Pattern.matches(emailPattern, email)) {
                return email;
            } else {
                System.out.println("\nEmail inválido. Tente novamente.\n");
            }
        }
    }
    public static boolean areThereEmail(String email, ArrayList<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email)) return true;
        }

        return false;
    }
}
