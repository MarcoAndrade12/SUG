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
	
		System.out.println("@"+username);
		Usuario user = userRepository.findByEmailAndDeletedFalse(username);
		System.out.println(user);
		if (user!=null) {
			return user;
		} else {
//			logger.debug("User not found with email: " + info);
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
		
	}

}
