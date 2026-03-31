package br.com.fecaf.controller;

import br.com.fecaf.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaController {

    List<Pessoa> pessoaList = new ArrayList<>();

    // Add na Lista
    public void adicionarPessoa(Pessoa pessoa) {
        pessoaList.add(pessoa);
        System.out.println("Pessoa Adicionada !");
    }

    // Exibir
    public void exibirPessoas() {
        System.out.println("/**** Listando Pessoas  ****/");

        for (Pessoa pessoa : pessoaList) {
            pessoa.exibirPessoa();
        }


    }

    //Pesquisar Pessoa
    public Pessoa pesquisarPessoa(String cpf) {
        System.out.println("/**  Pesquisar Pessoa  **/");

        for (Pessoa pessoa : pessoaList) {
            if (pessoa.cpf.equals(cpf)) {
                System.out.println("Pessoa Encontrada !");

                return pessoa;
            }
        }
        // Se chegar aqui ! O quer dizer ??
        return null;
    }

    // Deletar Pessoa
    // Se o usuario possuir um livro ele não poderá ser deletado, assim que o sistema detecta que o usuario possui um valor de livro diferente de nula ele retornará a mensagem.
    public void deletarPessoa(Pessoa pessoa) {
        if (pessoa.livro != null) {
            System.out.println("O usuario possui o livro " + pessoa.livro.titulo + " e não poderá ser excluido");

        } else {
            this.pessoaList.remove(pessoa);
            System.out.println("Pessoa deletada com sucesso !");
        }

    }
}




