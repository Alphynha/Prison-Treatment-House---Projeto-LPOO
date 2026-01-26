package app;

import java.util.Scanner;

public class PrisonTreatmentHouse {

    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = inteiroUsuario();

            switch (opcao) {
                case 1 -> menuPresidiarios();
                case 2 -> menuCelas();
                case 3 -> menuVisitas();
                case 0 -> System.out.println("Encerrando aplicação... Boa sorte!");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void exibirMenuPrincipal() {

        System.out.println("\nBem vindo a Prison Treatment House!");
        System.out.println("1 - Presidiários");
        System.out.println("2 - Celas");
        System.out.println("3 - Visitas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

    }

    private int inteiroUsuario() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void menuPresidiarios() {
        System.out.println("Menu Presidiarios");
    }

    private void menuCelas() {
        System.out.println("Menu Celas");
    }

    private void menuVisitas() {
        System.out.println("Menu Visitas");
    }
}

