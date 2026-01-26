package ui;

import enums.GrauPericulosidade;
import enums.Sexo;
import model.Presidiario;
import services.CelaService;
import services.PresidiarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuPresidiarios {

    private final Scanner scanner = new Scanner(System.in);

    private final PresidiarioService presidiarioService;
    private final CelaService celaService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuPresidiarios(PresidiarioService presidiarioService, CelaService celaService) {
        this.presidiarioService = presidiarioService;
        this.celaService = celaService;
    }

    public void start() {
        int opcao;

        do {
            System.out.println("\n=== MENU PRESIDIÁRIOS ===");
            System.out.println("1 - Cadastrar presidiário");
            System.out.println("2 - Listar presidiários");
            System.out.println("3 - Alocar presidiário em cela");
            System.out.println("4 - Desalocar presidiário da cela");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            try {
                switch (opcao) {
                    case 1 -> cadastrar();
                    case 2 -> listar();
                    case 3 -> alocar();
                    case 4 -> desalocar();
                    case 0 -> {
                    }
                    default -> System.out.println("Opção inválida");
                }
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    //Cadastrar Presidiario
    private void cadastrar() {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        LocalDate dataNascimento = lerData("Data de nascimento (dd/MM/yyyy): ");

        Sexo sexo = lerSexo();

        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();

        LocalDate dataIngresso = lerData("Data de ingresso (dd/MM/yyyy): ");

        GrauPericulosidade grau = lerGrauPericulosidade();

        Presidiario presidiario = new Presidiario(
                nome,
                cpf,
                dataNascimento,
                sexo,
                matricula,
                dataIngresso,
                grau
        );

        presidiarioService.cadastrarPresidiario(presidiario);
        System.out.println("Presidiario cadastrado com sucesso.");
    }

    //Listar Presidiario
    private void listar() {
        List<Presidiario> presidiarios = presidiarioService.listar();

        if (presidiarios.isEmpty()) {
            System.out.println("Nenhum presidiário cadastrado.");
            return;
        }

        presidiarios.forEach(System.out::println);
    }

    //Alocar
    private void alocar() {
        System.out.println("Matrícula do presidiário: ");
        String matricula = scanner.nextLine();

        System.out.println("ID da cela: ");
        String idCela = scanner.nextLine();

        presidiarioService.alocarPresidiarioEmCela(matricula, idCela);
        System.out.println("Presidiario alocado com sucesso.");

    }

    //Desalocar
    private void desalocar() {

        System.out.println("Matricula do presidiario: ");
        String matricula = scanner.nextLine();

        presidiarioService.desalocarPresidiario(matricula);
        System.out.println("Presidiário desalocado com sucesso.");
    }

    //Tratamento de Entradas
    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

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

    private Sexo lerSexo() {
        while (true) {
            System.out.println("Sexo:");
            for (Sexo s : Sexo.values()) {
                System.out.println("- " + s);
            }
            System.out.print("Escolha: ");

            try {
                return Sexo.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Sexo inválido.");
            }
        }
    }

    private GrauPericulosidade lerGrauPericulosidade() {
        while (true) {
            System.out.println("Grau de periculosidade:");
            for (GrauPericulosidade g : GrauPericulosidade.values()) {
                System.out.println("- " + g);
            }
            System.out.print("Escolha: ");

            try {
                return GrauPericulosidade.valueOf(
                        scanner.nextLine().toUpperCase()
                );
            } catch (IllegalArgumentException e) {
                System.out.println("Grau inválido.");
            }
        }
    }
}