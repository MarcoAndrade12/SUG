package com.SUG.FLORA.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@MappedSuperclass
@Data
public class Domain {
	
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
}
