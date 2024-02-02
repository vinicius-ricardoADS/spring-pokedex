package br.com.pokemon.springapi.entity;

import java.util.List;

public record PokemonRequestDTO(String name, List<Type> type, List<Type> weaknesses, double height,
                double weight, String category, String abillities, Gender gender) {

}
