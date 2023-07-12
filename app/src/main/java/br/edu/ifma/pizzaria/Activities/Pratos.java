package br.edu.ifma.pizzaria.Activities;

public class Pratos {
    private String nomeDoPrato;
    private String quantidadeDePratos;
    private String valorDoPrato;

    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    public void setNomeDoPrato(String nomeDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
    }

    public String getQuantidadeDePratos() {
        return quantidadeDePratos;
    }

    public void setQuantidadeDePratos(String quantidadeDePratos) {
        this.quantidadeDePratos = quantidadeDePratos;
    }

    public String getValorDoPrato() {
        return valorDoPrato;
    }

    public void setValorDoPrato(String valorDoPrato) {
        this.valorDoPrato = valorDoPrato;
    }

    public Pratos(String nomeDoPrato, String quantidadeDePratos, String valorDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
        this.quantidadeDePratos = quantidadeDePratos;
        this.valorDoPrato = valorDoPrato;


    }
}
