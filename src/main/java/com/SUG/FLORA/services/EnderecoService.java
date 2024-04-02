package com.SUG.FLORA.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.BairroDTO;
import com.SUG.FLORA.model.DTOs.CidadeDTO;
import com.SUG.FLORA.model.DTOs.EstadoDTO;
import com.SUG.FLORA.model.DTOs.LogradouroDTO;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.DTOs.TipoLogradouroDTO;
import com.SUG.FLORA.model.endereco.Logradouro;
import com.SUG.FLORA.model.endereco.Pais;
import com.SUG.FLORA.repository.endereco.BairroRepository;
import com.SUG.FLORA.repository.endereco.CidadeRepository;
import com.SUG.FLORA.repository.endereco.EstadoRepository;
import com.SUG.FLORA.repository.endereco.LogradouroRepository;
import com.SUG.FLORA.repository.endereco.PaisRepository;

@Service
public class EnderecoService {

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    BairroRepository bairroRepository;

    @Autowired
    LogradouroRepository logradouroRepository;

    public List<? extends DTO> ToDTOs(List<? extends DTOConvertible> entities) {
        List<DTO> entityDTOs = new ArrayList<>();

        for (DTOConvertible entity : entities) {
            entityDTOs.add(entity.getDTO());
        }

        return entityDTOs;
    }

    @SuppressWarnings("unchecked")
    public List<PaisDTO> findAllPaisesDTOsByDeletedFalse() {
        return (List<PaisDTO>) ToDTOs(paisRepository.findAllByDeletedFalse());
    }

    @SuppressWarnings("unchecked")
    public List<EstadoDTO> findAllEstadosDTOsByDeletedFalse() {
        return (List<EstadoDTO>) ToDTOs(estadoRepository.findAllByDeletedFalse());
    }

    @SuppressWarnings("unchecked")
    public List<CidadeDTO> findAllCidadesDTOsByDeletedFalse() {
        return (List<CidadeDTO>) ToDTOs(cidadeRepository.findAllByDeletedFalse());
    }

    @SuppressWarnings("unchecked")
    public List<BairroDTO> findAllBairrosDTOsByDeletedFalse() {
        return (List<BairroDTO>) ToDTOs(bairroRepository.findAllByDeletedFalse());
    }

    @SuppressWarnings("unchecked")
    public List<LogradouroDTO> findAllLogradourosDTOsByDeletedFalse() {
        return (List<LogradouroDTO>) ToDTOs(logradouroRepository.findAllByDeletedFalse());
    }

    public List<TipoLogradouroDTO> findAllTiposLogradourosDTOsByDeletedFalse() {
        List<TipoLogradouroDTO> tipos = Arrays.stream(EnumTipoLogradouro.values())
                .map(tipo -> new TipoLogradouroDTO(tipo.name())).collect(Collectors.toList());

        System.out.println(tipos);

        return tipos;
    }

}
