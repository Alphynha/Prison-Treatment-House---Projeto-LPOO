package services;

import enums.StatusCela;
import model.Cela;
import repository.Repository;

import java.util.List;

public class CelaService {

    private final Repository<Cela, String> celaRepo;

    public CelaService(Repository<Cela, String> celaRepo) {
        this.celaRepo = celaRepo;
    }

    //Cadastrar Cela
    public Cela cadastrarCela(Cela c) {
        boolean existe = celaRepo.buscarPorId(c.getIdCela()).isPresent();
        if (existe) {
            throw new IllegalArgumentException("Já existe uma cela com este ID.");
        }

        return celaRepo.salvar(c);
    }

    //Listar Celas
    public List<Cela> listarCelas() {
        return celaRepo.buscarTodos();
    }

    //Buscar Cela
    public Cela buscarPorId(String id) {
        return celaRepo.buscarPorId(id)
                .orElse(null);
    }

    //Listar celas disponíveis
    public List<Cela> listarCelasDisponiveis() {
        return celaRepo.buscarTodos().stream()
                .filter(c -> c.getStatus() != StatusCela.MANUTENCAO)
                .filter(Cela::possuiEspaco)
                .toList();
    }
}
