package com.SUG.FLORA.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	List<Usuario> findAllByDeletedFalse();

	Usuario findByEmailAndDeletedFalse(String username);

    Usuario findByEmail(String email);

}
