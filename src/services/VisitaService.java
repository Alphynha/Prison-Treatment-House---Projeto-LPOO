package services;

import model.Presidiario;
import model.Visita;
import repository.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class VisitaService {

    private final List<Visita> visitas = new ArrayList<>();
    private final Repository<Presidiario, String> presidiarioRepo;

    public VisitaService(Repository<Presidiario, String> presidiarioRepo) {
        this.presidiarioRepo = presidiarioRepo;
    }

    // Registrar Visita
    public void registrarVisita(String matriculaPreso, String nomeVisitante, LocalDate data) {

        Presidiario preso = presidiarioRepo.buscarPorId(matriculaPreso)
                .orElseThrow(() -> new IllegalArgumentException("Presidiário não encontrado."));

        visitas.add(new Visita(nomeVisitante, data, preso));
    }

    // Listar Visitas por Preso
    public List<Visita> listarVisitasPorPresidiario(String matricula) {

        return visitas.stream()
                .filter(v -> v.getPresidiario().getMatricula().equals(matricula))
                .toList();

    }

    // Listar todas as Visitas
    public List<Visita> listarTodos() {
        return new ArrayList<>(visitas);
    }
}
