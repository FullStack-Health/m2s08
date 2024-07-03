package com.example.demo_rest.controllers;

import com.example.demo_rest.dtos.ProdutoGetRequest;
import com.example.demo_rest.dtos.ProdutoRequest;
import com.example.demo_rest.dtos.ProdutoResponse;
import com.example.demo_rest.services.ProdutoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public void cadastra(@Valid @RequestBody ProdutoRequest produto) {
    service.cadastra(produto);
  }

  @PutMapping("/{id}")
  public void atualiza(@Valid @RequestBody ProdutoRequest produtoRequest, @PathVariable Long id) {
    service.atualiza(produtoRequest, id);
  }

  @GetMapping("/{id}")
  public ProdutoResponse busca(@PathVariable Long id) {
    return service.busca(id);
  }

  @GetMapping
  public List<ProdutoResponse> lista(ProdutoGetRequest filtros, Pageable paginacao) {
    return service.lista(filtros, paginacao);
  }
}
