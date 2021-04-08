package com.generation.testejunit.repository;

import java.util.List;

import com.generation.testejunit.model.ContatoModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {

    public ContatoModel findFirstByNome(String nome);
	public List<ContatoModel> findAllByNomeContainingIgnoreCase(String nome);

}
