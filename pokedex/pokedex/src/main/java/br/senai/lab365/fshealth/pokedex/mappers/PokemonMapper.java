package br.senai.lab365.fshealth.pokedex.mappers;

import br.senai.lab365.fshealth.pokedex.dtos.PokemonCapturadoRequest;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonResponse;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonSummary;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonVistoRequest;
import br.senai.lab365.fshealth.pokedex.models.Pokemon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokemonMapper {

  private PokemonMapper() {}

  public static Pokemon map(PokemonVistoRequest source) {
    if (source == null) return null;

    Pokemon target = new Pokemon();

    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setImagemUrl(source.getImagemUrl());
    target.setHabitat(source.getHabitat());

    return target;
  }

  public static Pokemon map(PokemonCapturadoRequest source) {
    if (source == null) return null;

    Pokemon target = new Pokemon();

    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setDescricao(source.getDescricao());
    target.setImagemUrl(source.getImagemUrl());
    target.setTipo(source.getTipo());
    target.setCategoria(source.getCategoria());
    target.setHabitat(source.getHabitat());
    target.setAltura(source.getAltura());
    target.setPeso(source.getPeso());
    target.setCapturado(true);

    return target;
  }

  public static PokemonResponse map(Pokemon source) {
    if (source == null) return null;

    PokemonResponse target = new PokemonResponse();

    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setDescricao(source.getDescricao());
    target.setImagemUrl(source.getImagemUrl());
    target.setTipo(source.getTipo());
    target.setCategoria(source.getCategoria());
    target.setHabitat(source.getHabitat());
    target.setAltura(source.getAltura());
    target.setPeso(source.getPeso());
    target.setCapturado(source.isCapturado());

    return target;
  }

  public static PokemonSummary mapToSummary(Pokemon source) {
    if (source == null) return null;

    PokemonSummary target = new PokemonSummary();

    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setCapturado(source.isCapturado());

    return target;
  }

  public static List<PokemonSummary> mapToSummary(List<Pokemon> source) {
    if (source == null) return Collections.emptyList();

    List<PokemonSummary> target = new ArrayList<>();

    for (Pokemon pokemon : source) {
      target.add(mapToSummary(pokemon));
    }

    return target;
  }
}
