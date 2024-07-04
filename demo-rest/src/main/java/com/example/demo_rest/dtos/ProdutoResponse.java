package com.example.demo_rest.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class ProdutoResponse {
  private Long id;
  private String nome;
  private String fabricante;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate validade;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(String fabricante) {
    this.fabricante = fabricante;
  }

  public LocalDate getValidade() {
    return validade;
  }

  public void setValidade(LocalDate validade) {
    this.validade = validade;
  }
}
