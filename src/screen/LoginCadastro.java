package screen;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;
import test.DemoApp;

public class LoginCadastro {
    public static void displayLoginCadastro(Scanner input, ArrayList<User> users) {
        String email;
        String password;
        int option;

        do {
            System.out.println("Bem-vindo(a) ao BookSwap!");
            System.out.println("1. Sign In");
            System.out.println("2. Cadastre-se");
            System.out.println("3. Sair do programa");
            System.out.print("Informe sua opção: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    System.out.println("\nfazendo loggin...");

                    System.out.print("Informe seu email: ");
                    email = input.nextLine();
                    System.out.print("Informe sua senha: ");
                    password = input.nextLine();

                    if (areThereUser(email, password, users)) {
                        System.out.println("\nusuário encontrado! Entrando no programa...\n");
                        DemoApp.loggedUser.setSignIn(true);

                        return;
                    }

                    break;

                case 2:
                    System.out.println("\nfazendo cadastro na plataforma...");

                    String name;

                    System.out.print("Informe seu nome: ");
                    name = input.nextLine();

                    System.out.print("Informe seu email: ");
                    email = input.nextLine();

                    System.out.print("Informe sua senha: ");
                    password = input.nextLine();

                    User user = new User(1, name, email, password);

                    users.add(user);

                    System.out.println("usuário criado com sucesso!\n");

                    break;

                case 3:
                    System.out.println("encerrando programa...");
                    DemoApp.exitProgram = true;

                    break;
                default:
                    break;

            }
        } while (option != 3);

    }

    public static boolean areThereUser(String email, String password, ArrayList<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                DemoApp.loggedUser = user;

                return true;
            }
        }

        return false;
    }
}
