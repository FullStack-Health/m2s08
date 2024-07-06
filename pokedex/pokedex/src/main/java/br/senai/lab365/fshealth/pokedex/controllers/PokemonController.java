package br.senai.lab365.fshealth.pokedex.controllers;

import br.senai.lab365.fshealth.pokedex.dtos.PokemonCapturadoRequest;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonResponse;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonSummary;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonVistoRequest;
import br.senai.lab365.fshealth.pokedex.services.PokemonService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

  private final PokemonService service;

  public PokemonController(PokemonService pokemonService) {
    this.service = pokemonService;
  }

  @PostMapping("/visto")
  @ResponseStatus(HttpStatus.CREATED)
  public void cadastraVisto(@Valid @RequestBody PokemonVistoRequest pokemonVistoRequest) {
    service.cadastraVisto(pokemonVistoRequest);
  }

  @PutMapping("/capturado")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void atualizaCapturado(
      @Valid @RequestBody PokemonCapturadoRequest pokemonCapturadoRequest) {
    service.atualizaCapturado(pokemonCapturadoRequest);
  }

  @PutMapping("/visto")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void atualizaVisto(@Valid @RequestBody PokemonVistoRequest pokemonVistoRequest) {
    service.atualizaVisto(pokemonVistoRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void exclui(@PathVariable(name = "id") Integer numero) {
    service.exclui(numero);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PokemonResponse busca(@PathVariable(name = "id") Integer numero) {
    return service.busca(numero);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PokemonSummary> lista() {
    return service.lista();
  }
}
