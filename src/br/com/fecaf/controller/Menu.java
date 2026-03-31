package br.com.fecaf.controller;

import br.com.fecaf.model.Livro;
import br.com.fecaf.model.Pessoa;

import java.util.Scanner;

public class Menu {

    // Instanciar Scanner
    Scanner scanner = new Scanner(System.in);
    // Controller Livro
    LivroController livroController = new LivroController();
    PessoaController pessoaController = new PessoaController();

    public void executarMenu () {
        boolean exit = false;

        while (!exit) {
            System.out.println("/************************/");
            System.out.println("/*         Menu         */");
            System.out.println("/************************/");
            System.out.println("/* 1 - Cadastrar Livro  */");
            System.out.println("/* 2 - Cadastrar User   */");
            System.out.println("/* 3 - Exibir Livro     */");
            System.out.println("/* 4 - Exibir User      */");
            System.out.println("/* 5 - Deletar Livro    */");
            System.out.println("/* 6 - Deletar User     */");
            System.out.println("/* 7 - Emprestar Livro  */");
            System.out.println("/* 8 - Devolver Livro   */");
            System.out.println("/* 9 - Sair             */");
            System.out.println("/************************/");

            int userOption = scanner.nextInt();
            scanner.nextLine();



            switch (userOption) {
                case 1:
                    Livro livro = new Livro();
                    livro.cadastrarLivro();
                    livroController.adicionarLivro(livro);
                    break;
                case 2:
                    Pessoa pessoa = new Pessoa();
                    pessoa.cadastrarPessoa();
                    pessoaController.adicionarPessoa(pessoa);
                    break;
                case 3:
                    livroController.exibirLivros();
                    break;
                case 4:
                    pessoaController.exibirPessoas();
                    break;
                case 5:
                    System.out.println("/** Deletar Livro **/");
                    livroController.exibirLivros();

                    System.out.println("Informe o ISBN do Livro que deseja deletar: ");
                    int isbnLivroDelete = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroDelete = livroController.pesquisarLivro(isbnLivroDelete);

                    if (livroDelete != null) {
                        System.out.println("Tem certeza que deseja deletar " +
                                livroDelete.titulo + "[1 -Sim 2-Não]");

                        int validationLivroDelete = scanner.nextInt();

                        if (validationLivroDelete == 1 ) {
                            livroController.deletarLivro(livroDelete);
                        }

                    } else {
                        System.out.println("/** livro não existe na base ! ***/");
                    }


                    break;
                case 6:
                    System.out.println("/** Deletar User **/");
                    pessoaController.exibirPessoas();

                    System.out.println("Informe o CPF de quem deseja deletar: ");
                    String cpfDelete = scanner.nextLine();

                    Pessoa pessoaDelete = pessoaController.pesquisarPessoa(cpfDelete);

                    if (pessoaDelete != null) {
                        System.out.println("Tem certeza que deseja deletar " +
                                pessoaDelete.nome + " [1-Sim  2-Não]");

                        int confirmDeleteUser = scanner.nextInt();
                        scanner.nextLine();

                        if (confirmDeleteUser == 1) {
                            pessoaController.deletarPessoa(pessoaDelete);
                        }

                    } else {
                        System.out.println("/** Pessoa não cadastrada na base **/");
                    }

                    break;
                case 7:
                    System.out.println("/*** Emprestar Livro ***/");

                    System.out.println("Olá, informe o seu CPF: ");
                    String cpfUserBook = scanner.nextLine();

                    Pessoa pessoaEmprestimoLivro = pessoaController.pesquisarPessoa(cpfUserBook);

                    if (pessoaEmprestimoLivro != null) {
                        livroController.exibirLivros();
                        System.out.println("Olá " + pessoaEmprestimoLivro.nome +
                                " Qual livro pensa em pegar hoje: ");

                        int isbnLivroEmprestimo = scanner.nextInt();
                        scanner.nextLine();

                        Livro livroEmprestimo = livroController.pesquisarLivro(isbnLivroEmprestimo);

                        if (livroEmprestimo != null) {
                            // valida user sem livro emprestado e valida se livro está disponivel
                            if (pessoaEmprestimoLivro.livro == null && livroEmprestimo.isEmprestado == false) {
                                System.out.println("/ ** Apto ao Emprestimo **/");

                                // Adicionar o livro para a pessoa
                                pessoaEmprestimoLivro.livro = livroEmprestimo;

                                // Trocar a flag de emprestimo do livro
                                livroEmprestimo.isEmprestado = true;

                                System.out.println("Livro emprestado com sucesso !");
                                System.out.println(pessoaEmprestimoLivro.nome + " está com o livro " + livroEmprestimo.titulo);

                            } else {
                                System.out.println("O user não pode pegar o Livro");
                                System.out.println("Ou o User já está com um Livro");
                                System.out.println("Ou o Livro já está emprestado");
                            }


                        } else {
                            System.out.println("Livro pesquisado não existe na base !");
                        }

                    } else {
                        System.out.println("Essa pessoa não existe na base !");
                    }

                    break;
                case 8:
                    // Aqui estou usando de referencia o código do case 7.
                    System.out.println("/**  Devolver Livro **/");
                    System.out.println("Informe o seu CPF");
                    String cpfUserDev = scanner.nextLine();

                    //Verificando o livro que o user já tem emprestado.
                    Pessoa pessoaDevolveLivro = pessoaController.pesquisarPessoa(cpfUserDev);

                    if (pessoaDevolveLivro != null) {

                        //Adicionei o nome do livro que a pessoa já tem emprestada.
                        if (pessoaDevolveLivro.livro != null) {
                            System.out.println("Olá " + pessoaDevolveLivro.nome +
                                    " você está com o livro: " + pessoaDevolveLivro.livro.titulo);

                            //Confirmando a devoção do livro
                            System.out.println("Deseja fazer a devolução do livro: " + pessoaDevolveLivro.livro.titulo + "(1 - Sim/2 - Não)");
                            int resposta = scanner.nextInt();

                            if (resposta == 1) {
                                Livro livroDevolucao = pessoaDevolveLivro.livro;
                                livroDevolucao.isEmprestado = false;
                                System.out.println("Livro Devolvido com sucesso !");

                            }else if (resposta == 2) {
                                System.out.println("O livro não será devolvido");

                            }else
                                System.out.println("Resposta invalida");

                        } else {
                            System.out.println("Você não possui livros");
                        }
                    }else
                        System.out.println("Pessoa não existe na base !");

                    break;
                case 9:
                    System.out.println("Saindo ...");
                    exit = true;
                    break;
                default:
                    System.out.println("escolha uma opção valida !");
            }

        }
    }

}

