import enums.GrauPericulosidade;
import enums.Sexo;
import enums.StatusCela;
import enums.StatusFuncionario;
import model.*;
import repository.ArrayListRepository;
import repository.Repository;
import services.CelaService;
import services.PresidiarioService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Repository<Cela, String> repo = new ArrayListRepository<>(Cela::getIdCela);

        CelaService service = new CelaService(repo);

        service.cadastrarCela(new Cela("C001", 3, 0, StatusCela.DESOCUPADA));
        service.cadastrarCela(new Cela("C002", 2, 0, StatusCela.DESOCUPADA));
        service.cadastrarCela(new Cela("C003", 2, 0, StatusCela.MANUTENCAO));

        System.out.println("Todas as celas");
        service.listarCelas().forEach(System.out::println);

        System.out.println("\nCelas disponíveis:");
        service.listarCelasDisponiveis().forEach(System.out::println);

        System.out.println("\nBuscar cela 1: ");
        System.out.println(service.buscarPorId("C001"));
    }
}
