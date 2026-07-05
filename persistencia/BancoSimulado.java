package persistencia;

import java.util.ArrayList;
import java.util.List;
import model.Alimento;
import model.Beneficiario;
import model.Doador;
import model.Distribuicao;
import model.Doacao;

public class BancoSimulado {
    private List<Alimento> alimentos;
    private List<Beneficiario> beneficiarios;
    private List<Doador> doadores;
    private List<Distribuicao> distribuicoes;
    private List<Doacao> doacoes;

    public BancoSimulado() {
        alimentos = new ArrayList<>();
        beneficiarios = new ArrayList<>();
        doadores = new ArrayList<>();
        distribuicoes = new ArrayList<>();
        doacoes = new ArrayList<>();
    }

    public void adicionarAlimento(Alimento alimento) {
        alimentos.add(alimento);
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void adicionarBeneficiario(Beneficiario beneficiario) {
        beneficiarios.add(beneficiario);
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void adicionarDoador(Doador doador) {
        doadores.add(doador);
    }

    public List<Doador> getDoadores() {
        return doadores;
    }

    public void adicionarDistribuicao(Distribuicao distribuicao) {
        distribuicoes.add(distribuicao);
    }

    public List<Distribuicao> getDistribuicoes() {
        return distribuicoes;
    }

    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public Doador buscarDoador (String cpf) {
        for (Doador doador : doadores) {
            if (doador.getCpf().equals(cpf)) {
                return doador;
            }
        }
        return null;
    }

    public Beneficiario buscarBeneficiario (String cpf) {
        for (Beneficiario beneficiario : beneficiarios) {
            if (beneficiario.getCpf().equals(cpf)) {
                return beneficiario;
            }
        }
        return null;
    }

    public Alimento buscarAlimento (int nomeAlimento) {
        for (Alimento alimento : alimentos) {
            if (alimento.getNome().equals(nomeAlimento)) {
                return alimento;
            }
        }
        return null;
    }
}