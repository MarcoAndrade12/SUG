package com.SUG.FLORA.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.repository.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Usuario user = userRepository.findByEmailAndDeletedFalse(username);
		
		if (user!=null) {
			System.out.println(user.getId());
			return user;
		} else {
//			logger.debug("User not found with email: " + info);
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
		
	}

}
