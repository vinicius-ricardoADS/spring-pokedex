package br.com.pokemon.springapi.entity;

import java.util.List;

public record PokemonResponseDTO(Long id, String name, List<Type> types, List<Type> weaknesses,
        double height, double weight, String category, String abillities, Gender gender) {

    public PokemonResponseDTO(Pokemon pokemon) {
        this(
                pokemon.getId(), pokemon.getName(), pokemon.getType(), pokemon.getWeaknesses(),
                pokemon.getHeight(), pokemon.getWeight(), pokemon.getCategory(), pokemon.getAbillities(),
                pokemon.getGender());
    }

}
