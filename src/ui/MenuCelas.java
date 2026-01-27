package ui;

import model.Cela;
import services.CelaService;

import java.util.List;
import java.util.Scanner;

public class MenuCelas {

    private final Scanner scanner = new Scanner(System.in);
    private final CelaService celaService;

    public MenuCelas(CelaService celaService) {
        this.celaService = celaService;
    }

    // Inicializar Menu
    public void start() {
        int opcao;

        do {
            System.out.println("\n=== MENU CELAS ===");
            System.out.println("1 - Cadastrar cela");
            System.out.println("2 - Listar celas");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            try {
                switch (opcao) {
                    case 1 -> cadastrar();
                    case 2 -> listar();
                    case 0 -> {
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    // Cadastrar Cela
    private void cadastrar() {
        System.out.print("ID da cela: ");
        String id = scanner.nextLine();

        System.out.print("Capacidade máxima: ");
        int capacidade = lerInteiro();

        Cela cela = new Cela(id, capacidade);
        celaService.cadastrarCela(cela);

        System.out.println("Cela cadastrada com sucesso.");
    }

    // Listar Celas
    private void listar() {
        List<Cela> celas = celaService.listarCelas();

        if (celas.isEmpty()) {
            System.out.println("Nenhuma cela cadastrada.");
            return;
        }

        celas.forEach(System.out::println);
    }

    // Tratamento de Entrada
    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
