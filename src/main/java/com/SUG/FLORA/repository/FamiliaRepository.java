package com.SUG.FLORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

}
