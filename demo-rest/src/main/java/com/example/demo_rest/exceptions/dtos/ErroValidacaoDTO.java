package com.example.demo_rest.exceptions.dtos;

import org.springframework.validation.FieldError;

public class ErroValidacaoDTO {
  private String campo;
  private String mensagem;

  public ErroValidacaoDTO(FieldError error) {
    this.campo = error.getField();
    this.mensagem = error.getDefaultMessage();
  }

  public String getCampo() {
    return campo;
  }

  public void setCampo(String campo) {
    this.campo = campo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
}
