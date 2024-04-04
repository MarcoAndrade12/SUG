package com.SUG.FLORA.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

public interface DTOConvertible {

    DTO getDTO();

    default void setId(UUID id){};
    default void setId(int id){};
    void setCreationDate(LocalDateTime creationDate);
    void setDeleted(boolean deleted);
    void setDeletedDate(LocalDateTime deletedDate);
    void setLastUpdate(LocalDateTime lastUpdate);

}
