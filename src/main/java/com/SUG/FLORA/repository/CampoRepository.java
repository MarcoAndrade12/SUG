package com.SUG.FLORA.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Campo;

@Repository
public interface CampoRepository extends JpaRepository<Campo, UUID> {

}
