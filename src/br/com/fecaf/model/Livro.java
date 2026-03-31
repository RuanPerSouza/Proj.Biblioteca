package br.com.fecaf.model;

import java.util.Scanner;

public class Livro {
    // Criar os Atributos
    public String titulo;
    public String autor;
    public int anolancamento;
    public int paginas;
    public int isbn;

    // Atributo Para validar se livro esta emprestado
    public boolean isEmprestado = false;

    Scanner scanner = new Scanner(System.in);

    public boolean cadastrarLivro () {
        System.out.println("/*******  Cadastro Livro  ********/");
        System.out.println("Informe o titulo: ");
        titulo = scanner.nextLine();
        System.out.println("Informe o autor: ");
        autor = scanner.nextLine();
        System.out.println("Informe o ano de lancamento: ");
        anolancamento = scanner.nextInt();
        System.out.println("Informe as paginas: ");
        paginas = scanner.nextInt();
        System.out.println("Informe o ISBN: ");
        isbn = scanner.nextInt();
        System.out.println("/*************************************/");

        return true;

    }

    public void exibirLivro () {
        System.out.println("/*******  Exibir Livro  ********/");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de lancamento: " + anolancamento);
        System.out.println("Paginas: " + paginas);
        System.out.println("ISBN: " + isbn);
        //Decidi por essa área de status para o usuário saber se o livro está disponível para ser emprestado ou não.
        if (isEmprestado == true) {
            System.out.println("Status: Livro Emprestado");
        }else
            System.out.println("Status: Livro Disponivel");
        System.out.println("/*************************************/");

    }


}
