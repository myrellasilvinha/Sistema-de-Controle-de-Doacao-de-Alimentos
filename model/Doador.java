package model;

public class Doador extends Pessoa {
    private String endereco;

    public Doador (String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco (String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n===== DOADOR =====");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
    }
}