package model;

public class Beneficiario extends Pessoa {
    private int quantidadePessoasFamilia;

    public Beneficiario (String nome, String cpf, String telefone, int quantidadePessoasFamilia) {
        super(nome, cpf, telefone);
        this.quantidadePessoasFamilia = quantidadePessoasFamilia;
    }

    public int getQuantidadePessoasFamilia() {
        return quantidadePessoasFamilia;
    }

    public void setQuantidadePessoasFamilia (int quantidadePessoasFamilia) {
        this.quantidadePessoasFamilia = quantidadePessoasFamilia;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n===== BENEFICIÁRIO =====");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Quantidade de Pessoas na Família: " + getQuantidadePessoasFamilia());
    }
}
