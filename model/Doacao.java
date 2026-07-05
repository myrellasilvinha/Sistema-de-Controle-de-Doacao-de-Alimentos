package model;

import interfaces.Exibivel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doacao implements Exibivel {
    private int id;
    private Doador doador;
    private LocalDate data;
    private List<Alimento> alimentos;

    public Doacao(int id, Doador doador, LocalDate data) {
        this.id = id;
        this.doador = doador;
        this.data = data;
        this.alimentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Doador getDoador() {
        return doador;
    }

    public LocalDate getData() {
        return data;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void adicionarAlimento (Alimento alimento) {
        alimentos.add(alimento);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n===== DOAÇÃO =====");
        System.out.println("Código: " + getId());
        System.out.println("Doador: " + getDoador().getNome());
        System.out.println("Data: " + getData());
        System.out.println("Alimentos:");
        for (Alimento alimento : alimentos) {
            System.out.println("- " + alimento.getNome()
                    + " | Quantidade: " + alimento.getQuantidade());
        }
    }
}
