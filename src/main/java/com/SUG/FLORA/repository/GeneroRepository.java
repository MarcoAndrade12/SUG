package com.SUG.FLORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
