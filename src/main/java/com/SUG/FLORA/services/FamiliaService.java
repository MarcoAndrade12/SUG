package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Familia;
import com.SUG.FLORA.repository.FamiliaRepository;

@Service
public class FamiliaService {
    
    @Autowired
    FamiliaRepository familiaRepository;

    public Familia findByName(String nome_cientifico_familia) {
        Familia familia = familiaRepository.findBynome_cientifico(nome_cientifico_familia);

        return familia;
    }

    public void save(Familia familia) {
        familiaRepository.save(familia);
    }


}
