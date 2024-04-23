package com.SUG.FLORA.model.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.UuidDomain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UuidDomainDTO {

    private UUID id;
    private LocalDateTime creationDate = LocalDateTime.now();
    private boolean deleted = false;
    private LocalDateTime deletedDate;
    private LocalDateTime lastUpdate;

    public void copyDomainOfUuidDomain(UuidDomain uuidDomain) {
        setId(uuidDomain.getId());
        setCreationDate(uuidDomain.getCreationDate());
        setDeleted(uuidDomain.isDeleted());
        setDeletedDate(uuidDomain.getDeletedDate());
        setLastUpdate(uuidDomain.getLastUpdate());
    }
    
}
