package com.example.demo_rest.controllers;

import com.example.demo_rest.dtos.ProdutoGetRequest;
import com.example.demo_rest.dtos.ProdutoRequest;
import com.example.demo_rest.dtos.ProdutoResponse;
import com.example.demo_rest.models.Produto;
import com.example.demo_rest.services.ProdutoService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoService service;

  public ProdutoController(ProdutoService produtoService) {
    this.service = produtoService;
  }

  @PostMapping
  public ResponseEntity<Void> cadastra(
      @Valid @RequestBody ProdutoRequest produto, UriComponentsBuilder uriBuilder) {
    Produto novoProduto = service.cadastra(produto);

    URI path = uriBuilder.path("/produtos/{id}").buildAndExpand(novoProduto.getId()).toUri();

    return ResponseEntity.created(path).build();
    // return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  /*
  // outra forma de responder um status diferente do padrão 200 OK
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void atualiza(@Valid @RequestBody ProdutoRequest produtoRequest, @PathVariable Long id) {
    service.atualiza(produtoRequest, id);
  }*/

  @PutMapping("/{id}")
  public ResponseEntity<Void> atualiza(
      @Valid @RequestBody ProdutoRequest produtoRequest, @PathVariable Long id) {
    service.atualiza(produtoRequest, id);
    return ResponseEntity.accepted().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProdutoResponse> busca(@PathVariable Long id) {
    // return ResponseEntity.ok(service.busca(id));
    return ResponseEntity.status(HttpStatus.OK).body(service.busca(id));
  }

  @GetMapping
  public ResponseEntity<Page<ProdutoResponse>> lista(
      ProdutoGetRequest filtros, Pageable paginacao) {
    return ResponseEntity.ok(service.lista(filtros, paginacao));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable Long id) {
    service.exclui(id);
    return ResponseEntity.noContent().build();
  }
}
