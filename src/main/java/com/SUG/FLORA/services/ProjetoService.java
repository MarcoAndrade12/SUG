package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

}
