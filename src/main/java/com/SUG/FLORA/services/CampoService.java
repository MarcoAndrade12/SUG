package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.repository.CampoRepository;

@Service
public class CampoService {

    @Autowired
    CampoRepository campoRepository;

}
