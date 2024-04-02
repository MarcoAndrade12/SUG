package com.SUG.FLORA.model.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainDTO {

    private UUID id;
    private LocalDateTime creationDate;
    private boolean deleted;
    private LocalDateTime deletedDate;
    
}
