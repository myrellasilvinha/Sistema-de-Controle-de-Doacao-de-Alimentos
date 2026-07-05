package model;

import interfaces.Exibivel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Distribuicao implements Exibivel {
    private int id;
    private Beneficiario beneficiario;
    private LocalDate data;
    private List<Alimento> alimentos;

    public Distribuicao (int id, Beneficiario beneficiario, LocalDate data) {
        this.id = id;
        this.beneficiario = beneficiario;
        this.data = data;
        this.alimentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
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
        System.out.println("\n===== DISTRIBUIÇÃO =====");
        System.out.println("Código: " + getId());
        System.out.println("Beneficiário: " + getBeneficiario().getNome());
        System.out.println("Data: " + getData());
        System.out.println("Alimentos:");
        for (Alimento alimento : alimentos) {
            System.out.println("- " + alimento.getNome()
                    + " | Quantidade: " + alimento.getQuantidade());
        }
    }
}
