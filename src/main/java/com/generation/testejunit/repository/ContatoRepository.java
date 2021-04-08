package com.generation.testejunit.repository;

import com.generation.testejunit.model.ContatoModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {

}
