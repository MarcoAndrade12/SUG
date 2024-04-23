package com.SUG.FLORA.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Endereco;
import com.SUG.FLORA.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<? extends DTO> ToDTOs(List<? extends DTOConvertible> entities) {
        List<DTO> entityDTOs = new ArrayList<>();

        for (DTOConvertible entity : entities) {
            entityDTOs.add(entity.getDTO());
        }

        return entityDTOs;
    }

    public Endereco salvar(Endereco e) {
        return enderecoRepository.save(e);
    }

    public Endereco findEnderecoById(long id) {
        return enderecoRepository.findById(id).get();
    }

}
