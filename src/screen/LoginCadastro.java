package screen;

import java.util.ArrayList;
import java.util.Scanner;

import models.Usuario;
import test.DemoApp;

public class LoginCadastro {
    public static void displayLoginCadastro(Scanner input, ArrayList<Usuario> usuarios) {
        String email;
        String senha;
        int opcao;

        do {
            System.out.println("Bem-vindo(a) ao BookSwap!");
            System.out.println("1. Sign In");
            System.out.println("2. Cadastre-se");
            System.out.println("3. Sair do programa");
            System.out.print("Informe sua opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\nfazendo loggin...");

                    System.out.print("Informe seu email: ");
                    email = input.nextLine();
                    System.out.print("Informe sua senha: ");
                    senha = input.nextLine();

                    if (usuarioExiste(email, senha, usuarios)) {
                        System.out.println("usuário encontrado! Entrando no programa....");
                        DemoApp.usuarioLogged.setSignIn(true);

                        return;
                    }

                    break;

                case 2:
                    System.out.println("\nfazendo cadastro na plataforma...");

                    String nome;
                    System.out.print("Informe seu nome: ");
                    nome = input.nextLine();
                    System.out.print("Informe seu email: ");
                    email = input.nextLine();
                    System.out.print("Informe sua senha: ");
                    senha = input.nextLine();

                    Usuario usuario = new Usuario(1, nome, email, senha);

                    usuarios.add(usuario);

                    System.out.println("usuário criado com sucesso!\n");

                    break;

                case 3:
                    System.out.println("encerrando programa...");
                    DemoApp.programaEstaEncerrado = true;

                    break;
                default:
                    break;

            }
        } while (opcao != 3);

    }

    public static boolean usuarioExiste(String email, String senha, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                DemoApp.usuarioLogged = usuario;

                return true;
            }
        }

        return false;
    }
}
