package model;

import enums.StatusCela;

public class Cela {

    private String idCela;
    private int capacidade;
    private int ocupacaoAtual;
    private StatusCela status;

    public Cela(String idCela, int capacidade) {
        this.idCela = idCela;
        this.capacidade = capacidade;
        this.ocupacaoAtual = 0;
        this.status = StatusCela.DESOCUPADA;
    }

    // Verificar se a cela está disponível
    public boolean possuiEspaco() {
        atualizarStatus();
        return status != StatusCela.LOTADA;
    }

    // Alocar preso em uma cela
    public boolean alocarPreso() {
        if (possuiEspaco()) {
            ocupacaoAtual++;
            atualizarStatus();
            return true;
        }
        System.out.println("Não foi possível alocar presidiário! A cela " + getIdCela() + " está cheia! ");
        return false;
    }

    // Desalocar preso de uma cela
    public boolean desalocarPreso() {
        if (ocupacaoAtual > 0) {
            ocupacaoAtual--;
            atualizarStatus();
            return true;
        }
        System.out.println("A cela está vazia!");
        return false;
    }

    // Atualizar status da cela
    private void atualizarStatus() {
        if (ocupacaoAtual == 0) {
            status = StatusCela.DESOCUPADA;
        } else if (ocupacaoAtual < capacidade) {
            status = StatusCela.OCUPADA;
        } else {
            status = StatusCela.LOTADA;
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

    // Getters & Setters
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
