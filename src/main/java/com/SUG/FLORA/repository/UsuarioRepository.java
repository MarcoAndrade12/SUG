package com.SUG.FLORA.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	List<Usuario> findByDeletedFalse();

	Usuario findByEmailAndDeletedFalse(String username);

}
