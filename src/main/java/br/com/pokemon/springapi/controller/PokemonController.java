package br.com.pokemon.springapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemon.springapi.entity.Pokemon;
import br.com.pokemon.springapi.service.PokemonService;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemons() {
        List<Pokemon> pokemons = pokemonService.findAll();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") Long id) {
        Pokemon pokemon = pokemonService.findById(id);
        if (pokemon != null)
            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon createdPokemon = pokemonService.save(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable("id") Long id, @RequestBody Pokemon pokemon) {
        Pokemon updatedPokemon = pokemonService.update(id, pokemon);
        if (updatedPokemon != null)
            return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable("id") Long id) {
        pokemonService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
