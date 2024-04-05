package com.SUG.FLORA.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.CidadeDTO;
import com.SUG.FLORA.model.DTOs.EnumTipoLogradouroDTO;
import com.SUG.FLORA.model.DTOs.EstadoDTO;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.endereco.Cidade;
import com.SUG.FLORA.model.endereco.Endereco;
import com.SUG.FLORA.repository.endereco.CidadeRepository;
import com.SUG.FLORA.repository.endereco.EnderecoRepository;
import com.SUG.FLORA.repository.endereco.EstadoRepository;
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
    EnderecoRepository enderecoRepository;

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

    public Endereco findEnderecoById(int id) {
        return enderecoRepository.findById(id).get();
    }

    public Cidade salvarCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

}
