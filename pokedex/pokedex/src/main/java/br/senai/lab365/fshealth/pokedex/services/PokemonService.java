package br.senai.lab365.fshealth.pokedex.services;

import static br.senai.lab365.fshealth.pokedex.mappers.PokemonMapper.map;

import br.senai.lab365.fshealth.pokedex.dtos.PokemonCapturadoRequest;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonVistoRequest;
import br.senai.lab365.fshealth.pokedex.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

  private final PokemonRepository repository;

  public PokemonService(PokemonRepository pokemonRepository) {
    this.repository = pokemonRepository;
  }

  public void cadastraVisto(PokemonVistoRequest pokemonVistoRequest) {
    // TODO: validar exists
    repository.save(map(pokemonVistoRequest));
  }

  public void cadastraCapturado(PokemonCapturadoRequest pokemonCapturadoRequest) {
    // TODO: validar exists
    repository.save(map(pokemonCapturadoRequest));
  }
}
