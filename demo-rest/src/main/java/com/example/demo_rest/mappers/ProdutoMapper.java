package com.example.demo_rest.mappers;

import com.example.demo_rest.dtos.ProdutoRequest;
import com.example.demo_rest.dtos.ProdutoResponse;
import com.example.demo_rest.models.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;

public class ProdutoMapper {

  private ProdutoMapper() {}

  public static Produto map(ProdutoRequest source) {
    Produto target = new Produto();
    target.setNome(source.getNome());
    target.setFabricante(source.getFabricante());
    target.setValidade(source.getValidade());

    return target;
  }

  public static ProdutoResponse map(Produto source) {
    ProdutoResponse target = new ProdutoResponse();

    target.setId(source.getId());
    target.setNome(source.getNome());
    target.setFabricante(source.getFabricante());
    target.setValidade(source.getValidade());

    return target;
  }

  public static List<ProdutoResponse> map(List<Produto> source) {
    List<ProdutoResponse> target = new ArrayList<>();

    for (Produto produto : source) {
      target.add(map(produto));
    }

    return target;
  }

  public static Page<ProdutoResponse> map(Page<Produto> source) {
    // TODO
  }
}
