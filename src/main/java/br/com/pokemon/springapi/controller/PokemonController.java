package br.com.pokemon.springapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemon.springapi.entity.Pokemon;
import br.com.pokemon.springapi.entity.PokemonRequestDTO;
import br.com.pokemon.springapi.entity.PokemonResponseDTO;
import br.com.pokemon.springapi.service.PokemonService;

@RestController
@RequestMapping("/api/pokemons")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<PokemonResponseDTO>> getAllPokemons() {
        List<PokemonResponseDTO> pokemons = pokemonService.findAll();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponseDTO> getPokemonById(@PathVariable("id") Long id) {
        Pokemon pokemon = pokemonService.findById(id);
        if (pokemon != null) {
            PokemonResponseDTO pokemonResponseDTO = new PokemonResponseDTO(pokemon);
            return new ResponseEntity<>(pokemonResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/found/{name}")
    public ResponseEntity<PokemonResponseDTO> getPokemonByName(@PathVariable("name") String name) {
        List<PokemonResponseDTO> pokemons = pokemonService.findAll();

        Optional<PokemonResponseDTO> pokemon = pokemons.stream()
                .filter(p -> p.name().equals(name))
                .findFirst();

        if (pokemon.isPresent()) {
            return new ResponseEntity<>(pokemon.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody PokemonRequestDTO pokemonRequestDTO) {
        Pokemon createdPokemon = new Pokemon(pokemonRequestDTO);
        pokemonService.save(createdPokemon);
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
