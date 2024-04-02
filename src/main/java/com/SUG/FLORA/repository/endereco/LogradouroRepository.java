package com.SUG.FLORA.repository.endereco;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.model.DTOs.TipoLogradouroDTO;
import com.SUG.FLORA.model.endereco.Estado;
import com.SUG.FLORA.model.endereco.Logradouro;

public interface LogradouroRepository extends JpaRepository<Logradouro, UUID> {

    List<Logradouro> findAllByDeletedFalse();

    List<Logradouro> findDistinctTipoByDeletedFalse();

}
