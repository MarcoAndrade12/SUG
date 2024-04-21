package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.repository.ColetaRepository;

@Service
public class ColetaService {

    @Autowired
    ColetaRepository coletaRepository;

}
