package com.SUG.FLORA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile findByName(String nome) {
        return profileRepository.findByName(nome);
    }

    public boolean existByNome(String nome) {
        if (findByName(nome) != null) {
            return true;
        } else {
            return false;
        }
    }

}
