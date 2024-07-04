package com.example.demo_rest.exceptions;

import com.example.demo_rest.exceptions.dtos.ErroValidacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> trataEntidadeNaoEncontrada() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErroValidacaoDTO>> trataParametroInvalido(
      MethodArgumentNotValidException exception) {
    return ResponseEntity.badRequest()
        .body(exception.getFieldErrors().stream().map(ErroValidacaoDTO::new).toList());
  }
}
