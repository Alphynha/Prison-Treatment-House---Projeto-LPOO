package model;

import java.time.LocalDate;

public class Visita {

    private String nomeVisitante;
    private LocalDate data;
    private Presidiario presidiario;

    public Visita(String nomeVisitante, LocalDate data, Presidiario presidiario) {
        this.nomeVisitante = nomeVisitante;
        this.data = data;
        this.presidiario = presidiario;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "nomeVisitante='" + nomeVisitante + '\'' +
                ", data=" + data +
                ", presidiario=" + presidiario +
                '}';
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Presidiario getPresidiario() {
        return presidiario;
    }

    public void setPresidiario(Presidiario presidiario) {
        this.presidiario = presidiario;
    }
}
