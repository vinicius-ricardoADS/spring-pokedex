package br.com.pokemon.springapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pokemon.springapi.dao.RepositoryDAO;
import br.com.pokemon.springapi.entity.Pokemon;

@Service
public class PokemonService {

    private final RepositoryDAO repositoryDAO;

    @Autowired
    public PokemonService(RepositoryDAO repositoryDAO) {
        this.repositoryDAO = repositoryDAO;
    }

    public Pokemon save(Pokemon pokemon) {
        return repositoryDAO.save(pokemon);
    }

    public Pokemon findById(Long id) {
        return repositoryDAO.findById(id).orElse(null);
    }

    public Pokemon update(Long id, Pokemon pokemonDetails) {
        return repositoryDAO.findById(id)
                .map(pokemon -> {
                    pokemon.setPokemon(pokemonDetails);
                    return repositoryDAO.save(pokemon);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repositoryDAO.deleteById(id);
    }

    public List<Pokemon> findAll() {
        return repositoryDAO.findAll();
    }
}
