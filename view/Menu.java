package view;

import control.SistemaController;
import exception.AlimentosVencidoException;
import exception.EstoqueInsuficienteException;
import java.time.LocalDate;
import java.util.Scanner;
import model.Alimento;
import model.Beneficiario;
import model.Doador;

public class Menu {

    private Scanner sc;
    private SistemaController controller;

    public Menu() {
        sc = new Scanner(System.in);
        controller = new SistemaController();
    }

    public void iniciar() throws EstoqueInsuficienteException {

        int opcao;

        do {

            System.out.println("\n===============================");
            System.out.println(" SISTEMA DE DOAÇÃO DE ALIMENTOS");
            System.out.println("===============================");
            System.out.println("1 - Cadastrar Doador");
            System.out.println("2 - Cadastrar Beneficiário");
            System.out.println("3 - Cadastrar Alimento");
            System.out.println("4 - Registrar Doação");
            System.out.println("5 - Distribuir Alimentos");
            System.out.println("6 - Mostrar Estoque");
            System.out.println("7 - Mostrar Doadores");
            System.out.println("8 - Mostrar Beneficiários");
            System.out.println("9 - Histórico de Doações");
            System.out.println("10 - Histórico de Distribuições");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarDoador();
                    break;

                case 2:
                    cadastrarBeneficiario();
                    break;

                case 3:
                    cadastrarAlimento();
                    break;

                case 4:
                    registrarDoacao();
                    break;

                case 5:
                    distribuirAlimento();
                    break;

                case 6:
                    controller.mostrarEstoque();
                    break;

                case 7:
                    controller.mostrarDoadores();
                    break;

                case 8:
                    controller.mostrarBeneficiarios();
                    break;

                case 9:
                    controller.mostrarHistoricoDoacoes();
                    break;

                case 10:
                    controller.mostrarHistoricoDistribuicoes();
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");

            }

        } while (opcao != 0);

    }

    private void distribuirAlimento() {
        System.out.println("\n=== DISTRIBUIR ALIMENTO ===");

        System.out.print("ID da distribuição: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("CPF do beneficiário: ");
        String cpfBeneficiario = sc.nextLine();

        System.out.print("Nome do alimento: ");
        String nomeAlimento = sc.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.print("Ano da distribuição: ");
        int anoDistribuicao = sc.nextInt();

        System.out.print("Mês da distribuição: ");
        int mesDistribuicao = sc.nextInt();

        System.out.print("Dia da distribuição: ");
        int diaDistribuicao = sc.nextInt();
        sc.nextLine();

        LocalDate dataDistribuicao = LocalDate.of(anoDistribuicao, mesDistribuicao, diaDistribuicao);

        try {
            controller.distribuirAlimento(id, cpfBeneficiario, nomeAlimento, quantidade, dataDistribuicao);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro ao distribuir alimento: " + e.getMessage());
        }
    }

    private void cadastrarDoador() {

        System.out.println("\n=== CADASTRO DE DOADOR ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        Doador doador = new Doador(nome, cpf, telefone, endereco);

        controller.cadastrarDoador(doador);

        System.out.println("\nDoador cadastrado com sucesso!");

    }

    private void cadastrarBeneficiario() {

        System.out.println("\n=== CADASTRO DE BENEFICIÁRIO ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Quantidade de pessoas da família: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        Beneficiario beneficiario = new Beneficiario(nome, cpf, telefone, qtd);

        controller.cadastrarBeneficiario(beneficiario);

        System.out.println("\nBeneficiário cadastrado com sucesso!");

    }

    private void cadastrarAlimento() {

        System.out.println("\n=== CADASTRO DE ALIMENTO ===");

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.nextLine();

        System.out.print("Peso: ");
        int peso = sc.nextInt();

        System.out.print("Ano de validade: ");
        int ano = sc.nextInt();

        System.out.print("Mês: ");
        int mes = sc.nextInt();

        System.out.print("Dia: ");
        int dia = sc.nextInt();
        sc.nextLine();

        LocalDate validade = LocalDate.of(ano, mes, dia);

        Alimento alimento = new Alimento(id, nome, tipo, peso,   quantidade, validade);

        controller.cadastrarAlimento(alimento);

        System.out.println("\nAlimento cadastrado com sucesso!");

    }

    private void registrarDoacao() throws EstoqueInsuficienteException {

        try {

            System.out.println("\n=== REGISTRAR DOAÇÃO ===");

            System.out.print("Código da doação: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("CPF do doador: ");
            String cpf = sc.nextLine();

            System.out.print("ID do alimento: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome do alimento: ");
            String nome = sc.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine();

            System.out.print("Ano validade: ");
            int ano = sc.nextInt();

            System.out.print("Mês: ");
            int mes = sc.nextInt();

            System.out.print("Dia: ");
            int dia = sc.nextInt();
            sc.nextLine();

            Alimento alimento = new Alimento( id, nome, quantidade, LocalDate.of(ano, mes, dia));

            System.out.print("Ano da doação: ");
            int anoDoacao = sc.nextInt();

            System.out.print("Mês da doação: ");
            int mesDoacao = sc.nextInt();

            System.out.print("Dia da doação: ");
            int diaDoacao = sc.nextInt();
            sc.nextLine();

            LocalDate dataDoacao = LocalDate.of(anoDoacao, mesDoacao, diaDoacao);

            controller.registrarDoacao(codigo, cpf, alimento, dataDoacao);

        } catch (AlimentosVencidoException e) {
            System.out.println(e.getMessage());
        }

    }

    private void distribuirAlimento1() {

        System.out.println("\n=== DISTRIBUIR ALIMENTOS ===");

        System.out.print("Código da distribuição: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("CPF do beneficiário: ");
        String cpf = sc.nextLine();

        System.out.print("ID do alimento: ");
        int idAlimento = sc.nextInt();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        controller.distribuirAlimento1(codigo, cpf, idAlimento, quantidade);
    }

}