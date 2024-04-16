package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.repository.FamiliaRepository;

@Service
public class FamiliaService {
    
    @Autowired
    FamiliaRepository familiaRepository;

}
