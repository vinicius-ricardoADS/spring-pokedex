package br.com.pokemon.springapi.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemons")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = { "id", "name" })
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String name;

    @Column(nullable = false)
    @ElementCollection
    @CollectionTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Type> type;

    @Column(nullable = false)
    @ElementCollection
    @CollectionTable(name = "pokemon_weaknesses", joinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Type> weaknesses;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, length = 10)
    private String abillities;

    @Column(nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Pokemon(PokemonRequestDTO pokemonRequestDTO) {
        this.name = pokemonRequestDTO.name();
        this.type = pokemonRequestDTO.type();
        this.weaknesses = pokemonRequestDTO.weaknesses();
        this.height = pokemonRequestDTO.height();
        this.weight = pokemonRequestDTO.weight();
        this.category = pokemonRequestDTO.category();
        this.abillities = pokemonRequestDTO.abillities();
        this.gender = pokemonRequestDTO.gender();
    }

    public void setPokemon(Pokemon pokemonDetails) {
        this.abillities = pokemonDetails.getAbillities();
        this.name = pokemonDetails.getName();
        this.type = pokemonDetails.getType();
        this.weaknesses = pokemonDetails.getWeaknesses();
        this.height = pokemonDetails.getHeight();
        this.weight = pokemonDetails.getHeight();
        this.category = pokemonDetails.getCategory();
        this.gender = pokemonDetails.getGender();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public void setWeaknesses(List<Type> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAbillities(String abillities) {
        this.abillities = abillities;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
