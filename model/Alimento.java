package model;

import interfaces.Exibivel;
import java.time.LocalDate;

public class Alimento implements Exibivel {
    private String nome;
    private String tipo;
    private double peso;
    private int quantidade;
    private LocalDate dataValidade;

    public Alimento (String nome, String tipo, double peso, int quantidade, LocalDate dataValidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
    }

    public Alimento(int id, String nome2, int quantidade2, LocalDate validade) {
        //TODO Auto-generated constructor stub
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso (double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade (int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public boolean estaVencido() {
        return dataValidade != null && dataValidade.isBefore(LocalDate.now());
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n===== ALIMENTO =====");
        System.out.println("Nome: " + getNome());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Peso: " + getPeso());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Data de Validade: " + getDataValidade());
    }
}
