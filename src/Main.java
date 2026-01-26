import enums.GrauPericulosidade;
import enums.Sexo;
import enums.StatusCela;
import enums.StatusFuncionario;
import model.*;
import repository.ArrayListRepository;
import repository.Repository;
import services.CelaService;
import services.PresidiarioService;
import services.VisitaService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Repository<Presidiario, String> presidiarioRepo = new ArrayListRepository<>(Presidiario::getMatricula);

        VisitaService visitaService = new VisitaService(presidiarioRepo);

        Presidiario preso = new Presidiario(
                "Alpha",
                "12357821837",
                LocalDate.of(2000, 4, 10),
                Sexo.M,
                "P001",
                LocalDate.now(),
                GrauPericulosidade.ALTO
        );

        presidiarioRepo.salvar(preso);

        visitaService.registrarVisita(
                "P001",
                "Flaky",
                LocalDate.now()
        );

        visitaService.registrarVisita(
                "P001",
                "R9",
                LocalDate.now().minusDays(1)
        );

        System.out.println("Visitas do presidiario P001: ");
        visitaService.listarVisitasPorPresidiario("P001").forEach(System.out::println);

        System.out.println("\nTodas as visitas: ");
        visitaService.listarTodos().forEach(System.out::println);

    }
}
