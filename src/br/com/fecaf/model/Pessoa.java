package br.com.fecaf.model;

import java.util.Scanner;

public class Pessoa {
    // Definir Atributos / Caracteristicas
    public String nome;
    public String cpf;
    public int idade;
    public String email;

    // Condiciono a Pessoa com um Livro
    public Livro livro = null;

    // Importar Biblioteca Scanner
    Scanner scanner = new Scanner(System.in);

    // Cadastrar Pessoa
    public boolean cadastrarPessoa () {
        System.out.println("/**********    Cadastro Pessoa   **********/");
        System.out.println("Informe o seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Informe o CPF: ");
        cpf = scanner.nextLine();
        System.out.println("Informe o Email: ");
        email = scanner.nextLine();
        System.out.println("Informe a Idade: ");
        idade = scanner.nextInt();
        System.out.println("/*****************************************/");

        return true;

    }

    // Exibir Pessoa
    public void exibirPessoa () {
        System.out.println("/****************************************/");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("/****************************************/");
    }




}
