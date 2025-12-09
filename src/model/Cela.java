package model;

import enums.StatusCela;

public class Cela {

    private String idCela;
    private int capacidade;
    private int ocupacaoAtual;
    private StatusCela status;

    public Cela(String idCela, int capacidade, int ocupacaoAtual, StatusCela status) {
        this.idCela = idCela;
        this.capacidade = capacidade;
        this.ocupacaoAtual = ocupacaoAtual;
        this.status = status;
    }

    //Verificar se a cela está disponível
    public boolean possuiEspaco() {
        return status != StatusCela.MANUTENCAO && ocupacaoAtual < capacidade;
    }

    public boolean alocarPreso() {
        if (possuiEspaco()) {
            ocupacaoAtual++;
            atualizarStatus();
            return true;
        }
        System.out.println("Não foi possível alocar presidiário! A cela " + getIdCela() + " está cheia! ");
        return false;
    }

    private void atualizarStatus() {
        if (status == StatusCela.MANUTENCAO) {
            return;
        }

        if (ocupacaoAtual == 0) {
            status = StatusCela.DESOCUPADA;
        } else {
            status = StatusCela.OCUPADA;
        }

    }

    @Override
    public String toString() {
        return "Cela{" +
                "idCela='" + idCela + '\'' +
                ", capacidade=" + capacidade +
                ", ocupacaoAtual=" + ocupacaoAtual +
                ", status=" + status +
                '}';
    }

    //Getters & Setters
    public String getIdCela() {
        return idCela;
    }

    public void setIdCela(String idCela) {
        this.idCela = idCela;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getOcupacaoAtual() {
        return ocupacaoAtual;
    }

    public void setOcupacaoAtual(int ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }

    public StatusCela getStatus() {
        return status;
    }

    public void setStatus(StatusCela status) {
        this.status = status;
    }
}
