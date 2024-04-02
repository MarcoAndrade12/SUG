package com.SUG.FLORA.model;

import org.springframework.security.core.GrantedAuthority;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.ProfileDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Profile extends Domain implements GrantedAuthority, DTOConvertible {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = "ROLE_" + nome;
	}

	@Override
	public String getAuthority() {
		return getName();
	}

	@Override
	public ProfileDTO getDTO() {
		ProfileDTO DTO = new ProfileDTO();
		DTO.setId(getId());
		DTO.setCreationDate(getCreationDate());
		DTO.setDeleted(isDeleted());
		DTO.setDeletedDate(getDeletedDate());

		DTO.setName(name);
		return DTO;
	}

}