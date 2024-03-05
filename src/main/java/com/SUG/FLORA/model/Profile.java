package com.SUG.FLORA.model;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper=false)
@Data
public class Profile extends Domain implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	@Override
	public String getAuthority() {
		return getName();
	}
	
	
}