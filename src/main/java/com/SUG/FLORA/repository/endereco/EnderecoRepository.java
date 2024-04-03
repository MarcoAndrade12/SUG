package com.SUG.FLORA.repository.endereco;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.endereco.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID>{
    
}
