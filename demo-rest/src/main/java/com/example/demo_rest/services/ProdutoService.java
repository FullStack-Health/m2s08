package com.example.demo_rest.services;

import com.example.demo_rest.dtos.ProdutoRequest;
import com.example.demo_rest.models.Produto;
import com.example.demo_rest.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService (ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }

    public void cadastra(ProdutoRequest produtoRequest) {

        Produto produto = new Produto();

        produto.setNome(produtoRequest.getNome());
        produto.setFabricante(produtoRequest.getFabricante());
        produto.setValidade(produtoRequest.getValidade());

        repository.save(produto);
    }
}
