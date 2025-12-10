import enums.GrauPericulosidade;
import enums.Sexo;
import enums.StatusCela;
import enums.StatusFuncionario;
import model.*;
import repository.ArrayListRepository;
import repository.Repository;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        /*
        //Criando cela
        System.out.println("--- Criando cela ---");
        Cela c1 = new Cela(
                "C001",
                3,
                0,
                StatusCela.DESOCUPADA
        );

        System.out.println("Cela criada!");
        System.out.println(c1);
        System.out.println();

        //Criando funcionario
        System.out.println("--- Criando funcionario ---");
        Funcionario f1 = new Funcionario(
                "Alphynha",
                "148998125",
                LocalDate.of(2003, 5, 10),
                Sexo.M,
                "F001",
                StatusFuncionario.ATIVO
        );

        System.out.println("Funcionário criado!");
        System.out.println(f1);
        System.out.println();

        //Criando presidiario
        System.out.println("--- Criando presidiario ---");
        Presidiario p1 = new Presidiario(
                "Presidiario",
                "214898419",
                LocalDate.of(1970, 4, 30),
                Sexo.F,
                "P001",
                LocalDate.now(),
                GrauPericulosidade.MEDIO
        );

        System.out.println("Presidiario Criado!");
        System.out.println(p1);
        System.out.println();

        //Alocando presidiario
        if (c1.alocarPreso()) {
            p1.setCelaAlocada(c1);
            System.out.println();
            System.out.println("Preso alocado com sucesso!");
        }

        System.out.println("--- Após alocação ---");
        System.out.println(p1);
        System.out.println();

        //Criando visitante
        System.out.println("--- Criando visitante ---");
        Visita v1 = new Visita(
                "Flaky",
                LocalDate.now(),
                p1
        );

        System.out.println("Visita criada!");
        System.out.println(v1);
        System.out.println();

        System.out.println("Fim do programa!");

         */

        //Testando repositorio
        System.out.println("--- Teste Repositório ---");
        System.out.println();
        Repository<Presidiario, String> repo =
                new ArrayListRepository<>(Presidiario::getMatricula);

        Presidiario p = new Presidiario(
                "Presidiario",
                "214898419",
                LocalDate.of(1970, 4, 30),
                Sexo.F,
                "P001",
                LocalDate.now(),
                GrauPericulosidade.BAIXO
        );

        repo.salvar(p);
        repo.buscarTodos().forEach(System.out::println);
        repo.removerPorId(p.getMatricula());
        repo.buscarTodos().forEach(System.out::println);

    }
}
