package br.senai.lab365.fshealth.pokedex.exceptions;

import br.senai.lab365.fshealth.pokedex.exceptions.dtos.ErroResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

  private static final Logger LOGGER = LogManager.getLogger(TratadorDeErros.class);

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> trataEntidadeNaoEncontrada() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseEntity<ErroResponse> trataChaveDuplicada(DuplicateKeyException exception) {
    ErroResponse erro = new ErroResponse();

    erro.setCampo("numero");
    erro.setMensagem(exception.getMessage());

    LOGGER.error("Chave duplicada.", exception);

    return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErroResponse>> trataErroValidacao(
      MethodArgumentNotValidException exception) {
    List<FieldError> fieldErrors = exception.getFieldErrors();

    List<ErroResponse> responseList = fieldErrors.stream().map(ErroResponse::new).toList();

    responseList.forEach(
        errorResponse -> LOGGER.warn("campo obrigatório faltando: {} ", errorResponse.getCampo()));

    return ResponseEntity.badRequest().body(responseList);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErroResponse> trataEnumInvalido(HttpMessageNotReadableException exception) {
    ErroResponse response = new ErroResponse();
    response.setCampo("tipo");
    response.setMensagem(exception.getLocalizedMessage());

    return ResponseEntity.badRequest().body(response);
  }
}
