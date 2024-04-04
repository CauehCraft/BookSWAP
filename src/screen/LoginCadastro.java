package screen;

import java.util.ArrayList;
import java.util.Scanner;

import models.Usuario;

public class LoginCadastro {
    public static void displayLoginCadastro(Scanner input, ArrayList<Usuario> usuarios) {
        String email;
        String senha;
        int opcao;

        System.out.println("Bem-vindo(a) ao BookSwap!");
        System.out.println("1. Sign In");
        System.out.println("2. Sign Out");
        System.out.print("Informe sua opção: ");
        opcao = Integer.parseInt(input.nextLine());

        switch (opcao) {
            case 1:
                System.out.println("fazendo loggin...");

                System.out.print("Informe seu email: ");
                email = input.nextLine();
                System.out.print("Informe sua senha: ");
                senha = input.nextLine();

                if (usuarioExiste(email, senha, usuarios)) {
                    System.out.println("usuário encontrado! Entrando no programa....");
                }

                break;

            default:
                break;
        }

    }

    public static boolean usuarioExiste(String email, String senha, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuario.setSignIn(true);

                return true;
            }
        }

        return false;
    }
}
