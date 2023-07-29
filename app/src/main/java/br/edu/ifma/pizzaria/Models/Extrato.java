package br.edu.ifma.pizzaria.Models;

import java.io.Serializable;

public class Extrato implements Serializable {
    private String nome;
    private int quantidade;
    private double total;

    public Extrato(String nome, int quantidade, Double total) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
