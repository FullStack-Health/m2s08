package com.example.demo_rest.services;

import static com.example.demo_rest.mappers.ProdutoMapper.map;

import com.example.demo_rest.dtos.ProdutoGetRequest;
import com.example.demo_rest.dtos.ProdutoRequest;
import com.example.demo_rest.dtos.ProdutoResponse;
import com.example.demo_rest.models.Produto;
import com.example.demo_rest.repositories.ProdutoRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final ProdutoRepository repository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.repository = produtoRepository;
  }

  public void cadastra(ProdutoRequest produtoRequest) {

    Produto produto = map(produtoRequest);

    repository.save(produto);
  }

  public void atualiza(ProdutoRequest produtoRequest, Long id) {
    boolean existe = repository.existsById(id);

    if (existe) {
      Produto produto = map(produtoRequest);
      produto.setId(id);

      repository.save(produto);
    } else {
      // TODO: retorna 404
    }
  }

  public ProdutoResponse busca(Long id) {
    // TODO: converter model para dto
    Optional<Produto> produtoOptional = repository.findById(id);

    if (produtoOptional.isEmpty()) {
      // TODO: retornar 404
      return null;
    } else {
      Produto produto = produtoOptional.get();
      ProdutoResponse response = map(produto);
      return response;
    }
  }

  public Page<ProdutoResponse> lista(ProdutoGetRequest filtros, Pageable paginacao) {
    String filtroFabricante = filtros.getFabricante() != null ? filtros.getFabricante() : "";
    String filtroNome = filtros.getNome() != null ? filtros.getNome() : "";

    return map(
        repository.findByNomeContainingIgnoreCaseAndFabricanteContainingIgnoreCase(
            filtroNome, filtroFabricante, paginacao));
  }
}
