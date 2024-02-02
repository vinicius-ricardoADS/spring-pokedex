package br.com.pokemon.springapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pokemon.springapi.entity.Pokemon;

@Repository
public interface RepositoryDAO extends JpaRepository<Pokemon, Long> {
}
