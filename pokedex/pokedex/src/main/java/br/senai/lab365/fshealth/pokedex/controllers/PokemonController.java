package br.senai.lab365.fshealth.pokedex.controllers;

import br.senai.lab365.fshealth.pokedex.dtos.PokemonCapturadoRequest;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonVistoRequest;
import br.senai.lab365.fshealth.pokedex.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping("/capturado")
  @ResponseStatus(HttpStatus.CREATED)
  public void cadastraCapturado(
      @Valid @RequestBody PokemonCapturadoRequest pokemonCapturadoRequest) {
    service.cadastraCapturado(pokemonCapturadoRequest);
  }
}
