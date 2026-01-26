package ui;

import java.awt.*;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);

    private final MenuPresidiarios menuPresidiarios;
    private final MenuCelas menuCelas;

    public MenuPrincipal(MenuPresidiarios menuPresidiarios, MenuCelas menuCelas) {
        this.menuPresidiarios = menuPresidiarios;
        this.menuCelas = menuCelas;
    }

    public void start() {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA PENITENCIÁRIO ===");
            System.out.println("1 - Presidiários");
            System.out.println("2 - Celas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> menuPresidiarios.start();
                case 2 -> menuCelas.start();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
