package com.SUG.FLORA.model.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;

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

    public void copyDomainOfIntDomain(IntDomain intDomain) {
        setId(intDomain.getId());
        setCreationDate(intDomain.getCreationDate());
        setDeleted(intDomain.isDeleted());
        setDeletedDate(intDomain.getDeletedDate());
        setLastUpdate(intDomain.getLastUpdate());
    }
    
}
