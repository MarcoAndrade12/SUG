package com.SUG.FLORA.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.SUG.FLORA.model.DTOs.UuidDomainDTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class UuidDomain {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
	
	
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

	public void copyDomainOfUuidDomainDTO(UuidDomainDTO uuidDomainDto) {
		setId(uuidDomainDto.getId());
        setCreationDate(uuidDomainDto.getCreationDate());
        setDeleted(uuidDomainDto.isDeleted());
        setDeletedDate(uuidDomainDto.getDeletedDate());
        setLastUpdate(uuidDomainDto.getLastUpdate());
	}
}
