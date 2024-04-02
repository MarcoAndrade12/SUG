package com.SUG.FLORA.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,UUID> {

    Profile findByName(String string);
    
}
