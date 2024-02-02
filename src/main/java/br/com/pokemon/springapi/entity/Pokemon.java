package br.com.pokemon.springapi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String name;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private List<Type> type;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public List<Type> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<Type> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbillities() {
        return abillities;
    }

    public void setAbillities(String abillities) {
        this.abillities = abillities;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pokemon other = (Pokemon) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (gender != other.gender)
            return false;
        return true;
    }
}
