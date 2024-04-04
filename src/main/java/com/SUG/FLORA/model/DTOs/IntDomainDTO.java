package com.SUG.FLORA.model.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.interfaces.DTOConvertible;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntDomainDTO {

    private int id;
    private LocalDateTime creationDate;
    private boolean deleted;
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
