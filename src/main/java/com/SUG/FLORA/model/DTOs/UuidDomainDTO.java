package com.SUG.FLORA.model.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.interfaces.DTOConvertible;

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

    public DTOConvertible setDomainModel(DTOConvertible dtoConvertible) {
        dtoConvertible.setId(id);
        dtoConvertible.setCreationDate(creationDate);
        dtoConvertible.setDeleted(deleted);
        dtoConvertible.setDeletedDate(deletedDate);
        dtoConvertible.setLastUpdate(lastUpdate);

        return dtoConvertible;
    }
    
}
