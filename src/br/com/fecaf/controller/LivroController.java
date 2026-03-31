package br.com.fecaf.controller;

import br.com.fecaf.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroController {
    // Criar uma lista para salvar os livros
    List<Livro> livroList = new ArrayList<>();

    // Adicionar Livro List
    public void adicionarLivro(Livro livro) {
        System.out.println("Adicionando Livro...");
        livroList.add(livro);
    }

    // Exibir Livros Lista
    public void exibirLivros() {
        System.out.println("/**** Listando Livros  ****/");

        for (Livro livro : livroList) {
            livro.exibirLivro();
        }

    }

    // Pesquisar Livros Lista
    public Livro pesquisarLivro(int isbn) {
        System.out.println("/**** Pesquisar Livros  ****/");

        for (Livro livro : livroList) {
            if (livro.isbn == isbn) {
                System.out.println("Livro Encontrado !");
                return livro;
            }
        }

        return null;
    }

    // Delete Livro
    // Seguindo o mesmo passo a passo do Deleta pessoa, com a diferença de que, em vez de procurar um valor null, ele não tem a informação do que está emprestado no isEmprestado.
    public void deletarLivro(Livro livro) {
        if (livro.isEmprestado) {
            System.out.println("O livro não pode ser deletado, pois está emprestado");

        } else {
            this.livroList.remove(livro);
            System.out.println("Livro deletado com Sucesso !");
        }


    }
}