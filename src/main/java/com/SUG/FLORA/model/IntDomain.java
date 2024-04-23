package com.SUG.FLORA.model;

import java.time.LocalDateTime;
import com.SUG.FLORA.model.DTOs.IntDomainDTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class IntDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Basic
	@Column(name = "creation_date")
	private LocalDateTime creationDate = LocalDateTime.now();

	@Basic
	private boolean deleted = false;

	@Basic
	@Column(name = "last_update")
	private LocalDateTime lastUpdate = LocalDateTime.now();

	@Basic
	@Column
	private LocalDateTime deletedDate;

	public void copyDomainOfIntDomainDTO(IntDomainDTO dto) {
		setId(dto.getId());
		setCreationDate(dto.getCreationDate());
		setDeleted(dto.isDeleted());
		setDeletedDate(dto.getDeletedDate());
		setLastUpdate(dto.getLastUpdate());
	}

}
