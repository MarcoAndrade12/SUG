package com.SUG.FLORA.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {
	@Autowired
    UsuarioRepository usuarioRepository;
	
	AuthenticationManager authenticationManager;
	 
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
            .password(new EncoderBean().getEncoder().encode("123"))
            .roles("USER")
            .build();
        UserDetails user2 = User.withUsername("user2")
            .password(new EncoderBean().getEncoder().encode("123"))
            .roles("USER")
            .build();
        UserDetails admin = User.withUsername("admin")
            .password(new EncoderBean().getEncoder().encode("123"))
            .roles("ADMIN")
            .build();
        
        if(usuarioRepository.findAll().size()==0) {
        	Usuario u = new Usuario();
        	u.setEmail("teste@teste.com");
        	u.setSenha(new EncoderBean().getEncoder().encode("123"));
        	usuarioRepository.save(u);
        }
        
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        
        authenticationManager = authenticationManagerBuilder.build();

        http
        .csrf()
        .disable()
		.authorizeHttpRequests()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/icon/**", "/printer/**" , "/teste.html", "/index.html", "/index_agent.html",  "/topic/", "/ws", "/report/**",
					 "/chat/**").permitAll()
		.anyRequest().authenticated()
        .and()       
		.formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/index", true))
		.logout(logout -> logout.logoutUrl("/logout"))		
		.authenticationManager(authenticationManager)
		.sessionManagement().maximumSessions(1)
		.maxSessionsPreventsLogin(true)
		.expiredUrl("/login");
        
        return http.build();
    }


}
