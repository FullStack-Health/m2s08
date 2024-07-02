package com.example.demo_rest.controllers;

import com.example.demo_rest.dtos.ProdutoRequest;
import com.example.demo_rest.models.Produto;
import com.example.demo_rest.services.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    @PostMapping
    public void cadastra(@RequestBody ProdutoRequest produto) {
        service.cadastra(produto);
    }

}
