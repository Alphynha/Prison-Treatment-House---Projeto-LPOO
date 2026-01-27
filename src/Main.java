import model.Cela;
import model.Presidiario;
import model.Visita;
import repository.ArrayListRepository;
import repository.Repository;
import services.CelaService;
import services.PresidiarioService;
import services.VisitaService;
import ui.MenuCelas;
import ui.MenuPresidiarios;
import ui.MenuPrincipal;
import ui.MenuVisitas;

public class Main {

    public static void main(String[] args) {

        // Repositórios
        Repository<Presidiario, String> presidiarioRepo =
                new ArrayListRepository<>(Presidiario::getMatricula);

        Repository<Cela, String> celaRepo =
                new ArrayListRepository<>(Cela::getIdCela);

        Repository<Visita, Visita> visitaRepo =
                new ArrayListRepository<>(v -> v); // sem id, o próprio objeto

        // Services
        PresidiarioService presidiarioService =
                new PresidiarioService(presidiarioRepo, celaRepo);

        CelaService celaService =
                new CelaService(celaRepo);

        VisitaService visitaService =
                new VisitaService(presidiarioRepo);

        // Menus
        MenuPresidiarios menuPresidiarios = new MenuPresidiarios(presidiarioService, celaService);
        MenuCelas menuCelas = new MenuCelas(celaService);
        MenuVisitas menuVisitas = new MenuVisitas(visitaService);

        // Menu principal
        MenuPrincipal menu = new MenuPrincipal(menuPresidiarios, menuCelas, menuVisitas);

        // Inicializando Menu Principal
        menu.start();

    }
}
