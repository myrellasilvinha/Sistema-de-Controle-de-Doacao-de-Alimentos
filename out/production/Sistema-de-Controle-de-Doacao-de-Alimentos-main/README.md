# Sistema de Controle de Doação de Alimentos

Projeto desenvolvido como trabalho prático da disciplina de **Programação Orientada a Objetos (POO)** do curso **Tecnólogo em Sistemas para Internet** do **Instituto Federal do Acre (IFAC) – Campus Rio Branco**.

O sistema tem como objetivo gerenciar o processo de doação e distribuição de alimentos, permitindo o cadastro de doadores, beneficiários e alimentos, além do controle de estoque, histórico de movimentações e validações importantes para garantir a integridade dos dados.

## Sobre o Projeto

O **Sistema de Controle de Doação de Alimentos** foi desenvolvido para auxiliar instituições e projetos sociais na administração de alimentos doados, promovendo maior organização, transparência e eficiência no combate ao desperdício.

A aplicação foi construída utilizando os princípios da **Programação Orientada a Objetos**, aplicando conceitos como:

- Herança
- Encapsulamento
- Polimorfismo
- Tratamento de Exceções
- Organização em Camadas (MVC)

## Funcionalidades

### Cadastro

- Cadastro de doadores
- Cadastro de beneficiários
- Cadastro de alimentos

### Controle de Estoque

- Registro de doações
- Registro de distribuições
- Atualização automática do estoque
- Consulta do estoque disponível

### Consultas

- Buscar doadores
- Buscar beneficiários
- Buscar alimentos
- Listagem de doadores
- Listagem de beneficiários

### Histórico

- Histórico de doações
- Histórico de distribuições

### Validações

- Impede doação de alimentos vencidos
- Impede distribuição acima do estoque disponível
- Tratamento de exceções personalizadas
- Mensagens de erro claras para o usuário

## Estrutura do Projeto

```
control
  └── SistemaController.java

model
  ├── Pessoa.java
  ├── Doador.java
  ├── Beneficiario.java
  ├── Alimento.java
  ├── Doacao.java
  └── Distribuicao.java

persistencia
  └── BancoSimulado.java

exception
  ├── AlimentosVencidoException.java
  └── EstoqueInsuficienteException.java

interfaces
  └── Exibivel.java

view
  ├── Menu.java
  └── Main.java
```

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- IntelliJ IDEA
- Estrutura MVC
- Banco de dados em memória (BancoSimulado)

## Conceitos Aplicados

- Classes e Objetos
- Herança
- Polimorfismo
- Encapsulamento
- Interfaces
- Exceções Personalizadas
- Coleções (ArrayList)
- Organização em camadas
- Boas práticas de desenvolvimento

## Como Executar

1. Clone este repositório

```bash
git clone https://github.com/myrellasilvinha/Sistema-de-Controle-de-Doacao-de-Alimentos.git
```

2. Abra o projeto em uma IDE Java (IntelliJ IDEA, Eclipse ou NetBeans).

3. Execute a classe:

```
view/Main.java
```

4. Utilize o menu interativo para realizar cadastros, doações, distribuições e consultas.

---

## Documentação

O projeto possui documentação contendo:

- Introdução
- Sobre a empresa
- Justificativa
- Diagramas
- Requisitos Funcionais
- Requisitos Não Funcionais
- Conclusões

## Colaboradores

- **Myrella da Silva Souza**
- **João Victor de Souza Malveira**
- **Marcus Vinicius de Souza Malveira**

## Objetivo Acadêmico

Este projeto foi desenvolvido para colocar em prática os conceitos de Programação Orientada a Objetos, simulando um sistema real de gerenciamento de doações de alimentos e aplicando boas práticas de desenvolvimento de software.
