package control;

import exception.AlimentosVencidoException;
import exception.EstoqueInsuficienteException;
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

    public void registrarDoacao(int id, String cpfDoador, Alimento alimento)
        throws AlimentosVencidoException, EstoqueInsuficienteException {

        Doador doador = banco.buscarDoador(cpfDoador);

        if (doador == null) {
            throw new IllegalArgumentException("Doador não encontrado.");
        }

        if (alimento.estaVencido()) {
            throw new AlimentosVencidoException("Alimento vencido.");
        }

        Doacao doacao = new Doacao(id, doador, null);
        doacao.adicionarAlimento(alimento);

        banco.adicionarDoacao(doacao);
        banco.adicionarAlimento(alimento);
    }

    public void distribuirAlimento(int id,
                                   String cpfBeneficiario,
                                   int idAlimento,
                                   int quantidade)
            throws EstoqueInsuficienteException {

        Beneficiario beneficiario = banco.buscarBeneficiario(cpfBeneficiario);

        if (beneficiario == null) {
            System.out.println("Beneficiário não encontrado.");
            return;
        }

        Alimento alimento = banco.buscarAlimento(idAlimento);

        if (alimento == null) {
            System.out.println("Alimento não encontrado.");
            return;
        }

        if (alimento.getQuantidade() < quantidade) {
            throw new EstoqueInsuficienteException("Quantidade insuficiente em estoque.");
        }

        alimento.setQuantidade(alimento.getQuantidade() - quantidade);

        Alimento entregue = new Alimento(
                alimento.getNome(),
                alimento.getTipo(),
                alimento.getPeso(),
                quantidade, alimento.getDataValidade());

        Distribuicao distribuicao =
                new Distribuicao(id, beneficiario, null);

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

        for (Doador d : banco.getDoadores()) {
            d.exibirInformacoes();
        }

    }

    public void mostrarBeneficiarios() {

        for (Beneficiario b : banco.getBeneficiarios()) {
            b.exibirInformacoes();
        }

    }

    public void mostrarHistoricoDoacoes() {

        for (Doacao d : banco.getDoacoes()) {
            d.exibirInformacoes();
        }

    }

    public void mostrarHistoricoDistribuicoes() {

        for (Distribuicao d : banco.getDistribuicoes()) {
            d.exibirInformacoes();
        }

    }

    public void cadastrarDoador(Doador doador) {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarDoador'");
    }

    public void cadastrarBeneficiario(Beneficiario beneficiario) {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarBeneficiario'");
    }

    public void cadastrarAlimento(Alimento alimento) {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarAlimento'");
    }

    public void distribuirAlimento1(int codigo, String cpf, int idAlimento, int quantidade) {
        throw new UnsupportedOperationException("Unimplemented method 'distribuirAlimento'");
    }
}