package br.com.pokemon.springapi.entity;

import java.util.List;

public record PokemonRequestDTO(String name, List<Type> types, List<Type> weaknesses, double height,
        double weight, String category, String abillities, Gender gender) {

}
