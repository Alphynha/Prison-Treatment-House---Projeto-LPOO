package ui;

import model.Visita;
import services.VisitaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuVisitas {

    private final Scanner scanner = new Scanner(System.in);
    private final VisitaService visitaService;

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuVisitas(VisitaService visitaService) {
        this.visitaService = visitaService;
    }

    // Inicializar Menu
    public void start() {
        int opcao;

        do {
            System.out.println("\n=== MENU VISITAS ===");
            System.out.println("1 - Registrar visita");
            System.out.println("2 - Listar visitas por presidiário");
            System.out.println("3 - Listar todas as visitas");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            try {
                switch (opcao) {
                    case 1 -> registrar();
                    case 2 -> listarPorPresidiario();
                    case 3 -> listarTodas();
                    case 0 -> {
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    // Registrar Visitas
    private void registrar() {
        System.out.print("Matrícula do presidiário: ");
        String matricula = scanner.nextLine();

        System.out.print("Nome do visitante: ");
        String nomeVisitante = scanner.nextLine();

        LocalDate dataVisita = lerData("Data da visita (dd/MM/yyyy): ");

        visitaService.registrarVisita(
                matricula,
                nomeVisitante,
                dataVisita
        );

        System.out.println("Visita registrada com sucesso.");
    }

    // Listar Visitas
    private void listarPorPresidiario() {
        System.out.print("Matrícula do presidiário: ");
        String matricula = scanner.nextLine();

        List<Visita> visitas =
                visitaService.listarVisitasPorPresidiario(matricula);

        if (visitas.isEmpty()) {
            System.out.println("Nenhuma visita encontrada para este presidiário.");
            return;
        }

        visitas.forEach(System.out::println);
    }

    // Listar todas as visitas
    private void listarTodas() {
        List<Visita> visitas = visitaService.listarTodos();

        if (visitas.isEmpty()) {
            System.out.println("Nenhuma visita registrada.");
            return;
        }

        visitas.forEach(System.out::println);
    }

    // Tratando entradas do usuário
    // Inteiro
    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Datas
    private LocalDate lerData(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return LocalDate.parse(
                        scanner.nextLine(),
                        formatter
                );
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use dd/MM/yyyy.");
            }
        }
    }
}
