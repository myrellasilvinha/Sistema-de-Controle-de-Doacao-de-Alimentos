package control;

import exception.AlimentosVencidoException;
import exception.EstoqueInsuficienteException;

import java.time.LocalDate;
import java.util.List;
import model.Alimento;
import model.Beneficiario;
import model.Doador;
import model.Distribuicao;
import model.Doacao;
import persistencia.BancoSimulado;

public class SistemaController {
    private BancoSimulado banco;

    public SistemaController() {
        banco = new BancoSimulado();
    }

    public BancoSimulado getBanco() {
        return banco;
    }

    public void adicionarAlimento(Alimento alimento) {
        banco.adicionarAlimento(alimento);
    }

    public void adicionarBeneficiario(Beneficiario beneficiario) {
        banco.adicionarBeneficiario(beneficiario);
    }

    public void adicionarDoador(Doador doador) {
        banco.adicionarDoador(doador);
    }

    public void adicionarDistribuicao(Distribuicao distribuicao) {
        banco.adicionarDistribuicao(distribuicao);
    }

    public void adicionarDoacao(Doacao doacao) {
        banco.adicionarDoacao(doacao);
    }

    public List<Alimento> listarAlimentos() {
        return banco.getAlimentos();
    }

    public List<Beneficiario> listarBeneficiarios() {
        return banco.getBeneficiarios();
    }

    public List<Doador> listarDoadores() {
        return banco.getDoadores();
    }

    public List<Distribuicao> listarDistribuicoes() {
        return banco.getDistribuicoes();
    }

    public List<Doacao> listarDoacoes() {
        return banco.getDoacoes();
    }

    public void registrarDoacao(int id, String cpfDoador, Alimento alimento, java.time.LocalDate dataDoacao)
            throws AlimentosVencidoException, EstoqueInsuficienteException {

        Doador doador = banco.buscarDoador(cpfDoador);

        if (doador == null) {
            System.out.println("Doador não encontrado.");
            return;
        }

        if (alimento.estaVencido()) {
            throw new AlimentosVencidoException("Alimento vencido.");
        }


        Doacao doacao = new Doacao(id, doador, dataDoacao);
        doacao.adicionarAlimento(alimento);

        banco.adicionarDoacao(doacao);

        Alimento existente = banco.buscarAlimento(alimento.getNome());

        if (existente != null) {
            existente.setQuantidade(existente.getQuantidade() - alimento.getQuantidade());
        } else {
            banco.adicionarAlimento(alimento);
        }
    }

    public void distribuirAlimento(int id,
                                   String cpfBeneficiario,
                                   String nomeAlimento,
                                   int quantidade,
                                   java.time.LocalDate dataDistribuicao)
            throws EstoqueInsuficienteException {

        Beneficiario beneficiario = banco.buscarBeneficiario(cpfBeneficiario);

        if (beneficiario == null) {
            System.out.println("Beneficiário não encontrado.");
            return;
        }

        Alimento alimento = banco.buscarAlimento(nomeAlimento);

        if (alimento == null) {
            System.out.println("Alimento não encontrado.");
            return;
        }

        if (alimento.getQuantidade() < quantidade) {
            throw new EstoqueInsuficienteException("Quantidade insuficiente em estoque.");
        }

        if (alimento.estaVencido()) {
            System.out.print("Alimento vencido.");
            return;
        }

        alimento.setQuantidade(alimento.getQuantidade() - quantidade);

        Alimento entregue = new Alimento(
                alimento.getId(),
                alimento.getNome(),
                alimento.getTipo(),
                alimento.getPeso(),
                quantidade, alimento.getDataValidade());

        Distribuicao distribuicao =
                new Distribuicao(id, beneficiario, dataDistribuicao);

        distribuicao.adicionarAlimento(entregue);

        banco.adicionarDistribuicao(distribuicao);

        System.out.println("Distribuição realizada com sucesso!");
    }

    public void mostrarEstoque() {

        if (banco.getAlimentos().isEmpty()) {

            System.out.println("Estoque vazio.");
            return;
        }

        for (Alimento alimento : banco.getAlimentos()) {
            alimento.exibirInformacoes();
        }
    }

    public void mostrarDoadores() {

        if (banco.getDoadores().isEmpty()) {

            System.out.println("Sem doadores registrados");
            return;
        }

        for (Doador d : banco.getDoadores()) {
            d.exibirInformacoes();
        }

    }

    public void mostrarBeneficiarios() {

        if (banco.getBeneficiarios().isEmpty()) {

            System.out.println("Sem Beneficiarios registrados");
            return;
        }

        for (Beneficiario b : banco.getBeneficiarios()) {
            b.exibirInformacoes();
        }

    }

    public void mostrarHistoricoDoacoes() {

        if (banco.getDoacoes().isEmpty()) {

            System.out.println("Sem doacoes registradas");
            return;
        }
        for (Doacao d : banco.getDoacoes()) {
            d.exibirInformacoes();
        }

    }

    public void mostrarHistoricoDistribuicoes() {

        if (banco.getDistribuicoes().isEmpty()) {

            System.out.println("Sem distribuicoes registradas");
            return;
        }

        for (Distribuicao d : banco.getDistribuicoes()) {
            d.exibirInformacoes();
        }

    }

    public void cadastrarDoador(Doador doador) {
        banco.adicionarDoador(doador);
    }

    public void cadastrarBeneficiario(Beneficiario beneficiario) {
        banco.adicionarBeneficiario(beneficiario);
    }

    public void cadastrarAlimento(Alimento alimento) {
        banco.adicionarAlimento(alimento);
    }

    public void distribuirAlimento1(int codigo, String cpf, int idAlimento, int quantidade) {
        throw new UnsupportedOperationException("Unimplemented method 'distribuirAlimento'");
    }
}