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
import com.SUG.FLORA.model.endereco.Estado;
import com.SUG.FLORA.model.endereco.Pais;
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

    public Endereco salvar(Endereco e) {
    	
//    	if (!cidadeRepository.existsByNomeIgnoreCase(e.getCidade().getNome())) {
//    		System.out.println("Cidade não existe");
//    		
//    		e.setCidade(cidadeRepository.save(e.getCidade()));
//    		e.getEstado().getCidades().add(e.getCidade());
//    	} else {
//    		e.setCidade(cidadeRepository.findByNome(e.getCidade().getNome()));
//    	}
//
//    	if (!estadoRepository.existsByNomeIgnoreCase(e.getEstado().getNome())) {    
//    		System.out.println("Estado não existe");
//
//    		e.setEstado(estadoRepository.save(e.getEstado()));  
//    		e.getPais().getEstados().add(e.getEstado());
//    	} else {
//    		e.setEstado(estadoRepository.findByNome(e.getEstado().getNome()));    		
//    	}
//
//    	
//    	if (!paisRepository.existsByNomeIgnoreCase(e.getPais().getNome())) {
//    		System.out.println("Pais não existe");
//
//    		e.setPais(paisRepository.save(e.getPais()));
//    	} else {
//    		e.setPais(paisRepository.findByNome(e.getPais().getNome()));
//    	}
    	
    	return enderecoRepository.save(e);
    }
    
    public Endereco findEnderecoById(int id) {
        return enderecoRepository.findById(id).get();
    }

    public Cidade salvarCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

}
