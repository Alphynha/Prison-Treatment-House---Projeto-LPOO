package model;

import enums.Sexo;
import enums.StatusFuncionario;

import java.time.LocalDate;

public class Funcionario extends Pessoa{

    private String matricula;
    private StatusFuncionario status;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, String matricula, StatusFuncionario status) {
        super(nome, cpf, dataNascimento, sexo);
        this.matricula = matricula;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome: " + getNome() +
                ", matricula='" + matricula + '\'' +
                ", status=" + status +
                '}';
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }
}
