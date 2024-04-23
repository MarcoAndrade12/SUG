package com.SUG.FLORA.interfaces;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DTOConvertible {

    DTO getDTO();

    default void setId(UUID id) {
    };

    default void setId(int id) {
    };

    void setCreationDate(LocalDateTime creationDate);

    void setDeleted(boolean deleted);

    void setDeletedDate(LocalDateTime deletedDate);

    void setLastUpdate(LocalDateTime lastUpdate);

}
