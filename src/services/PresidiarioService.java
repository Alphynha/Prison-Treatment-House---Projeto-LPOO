package services;

import model.Cela;
import model.Presidiario;
import repository.Repository;

import java.util.List;

public class PresidiarioService {

    private final Repository<Presidiario, String> presidiarioRepo;
    private final Repository<Cela, String> celaRepo;

    public PresidiarioService(Repository<Presidiario, String> presidiarioRepo, Repository<Cela, String> celaRepo) {
        this.presidiarioRepo = presidiarioRepo;
        this.celaRepo = celaRepo;
    }

    // Cadastrar Presidiario
    public Presidiario cadastrarPresidiario(Presidiario p) {
        boolean existe = presidiarioRepo.buscarPorId(p.getMatricula()).isPresent();
        if (existe) {
            throw  new IllegalArgumentException("Já existe um presidiario com esta matrícula.");
        }

        return presidiarioRepo.salvar(p);
    }

    // Alocar em Cela
    public void alocarPresidiarioEmCela(String matricula, String idCela) {
        Presidiario p = presidiarioRepo.buscarPorId(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Presidiario não encontrado."));

        if (p.getCelaAlocada() != null) {
            throw new IllegalStateException("Presidiário já está alocado em uma cela");
        }

        Cela cela = celaRepo.buscarPorId(idCela)
                .orElseThrow(() -> new IllegalArgumentException("Cela não encontrado."));

        if (!cela.possuiEspaco()) {
            throw new IllegalStateException("A cela não possui espaço disponível.");
        }

        cela.alocarPreso();
        p.setCelaAlocada(cela);

        presidiarioRepo.salvar(p);
        celaRepo.salvar(cela);

    }

        // Desalocar
        public void desalocarPresidiario(String matricula) {

            Presidiario p = presidiarioRepo.buscarPorId(matricula)
                    .orElseThrow(() -> new IllegalArgumentException("Presidiario não encontrado."));

            if (p.getCelaAlocada() == null) {
                throw new IllegalStateException("Presidiario não está alocado em nenhuma cela.");
            }

            Cela cela = p.getCelaAlocada();
            cela.desalocarPreso();
            p.setCelaAlocada(null);

            presidiarioRepo.salvar(p);
            celaRepo.salvar(cela);
    }

    // Buscar Preso
    public Presidiario buscarPorMatricula(String matricula) {
        return presidiarioRepo.buscarPorId(matricula)
                .orElse(null);
    }

    // Listar Presidiarios
    public List<Presidiario> listar() {
        return presidiarioRepo.buscarTodos();
    }
}
