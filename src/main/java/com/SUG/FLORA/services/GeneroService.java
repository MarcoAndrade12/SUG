package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Genero;
import com.SUG.FLORA.repository.GeneroRepository;

@Service
public class GeneroService {
    
    @Autowired
    GeneroRepository generoRepository;

    public Genero findByName(String nome_cientifico_genero) {
        Genero genero = generoRepository.findBynome_cientifico(nome_cientifico_genero);

        return genero;
    }

    public void save(Genero genero) {
        generoRepository.save(genero);
    }

}
