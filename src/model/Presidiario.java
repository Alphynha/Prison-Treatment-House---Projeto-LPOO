package model;

import enums.GrauPericulosidade;
import enums.Sexo;

import java.time.LocalDate;

public class Presidiario extends Pessoa{

    private String matricula;
    private LocalDate dataIngresso;
    private GrauPericulosidade grau;
    private Cela celaAlocada;

    public Presidiario(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, String matricula, LocalDate dataIngresso, GrauPericulosidade grau) {
        super(nome, cpf, dataNascimento, sexo);
        this.matricula = matricula;
        this.dataIngresso = dataIngresso;
        this.grau = grau;
        this.celaAlocada = null; //Cela nula inicialmente
    }

    @Override
    public String toString() {
        return "Presidiario{" + "nome: " + getNome() +
                ", matricula='" + matricula + '\'' +
                ", dataIngresso=" + dataIngresso +
                ", grau=" + grau +
                ", celaAlocada=" + celaAlocada +
                '}';
    }

    // Getters & Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public GrauPericulosidade getGrau() {
        return grau;
    }

    public void setGrau(GrauPericulosidade grau) {
        this.grau = grau;
    }

    public Cela getCelaAlocada() {
        return celaAlocada;
    }

    public void setCelaAlocada(Cela celaAlocada) {
        this.celaAlocada = celaAlocada;
    }
}
