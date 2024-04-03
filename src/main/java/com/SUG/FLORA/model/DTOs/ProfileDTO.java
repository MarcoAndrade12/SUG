package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO extends DomainDTO implements DTO {
    private String name;

    @Override
    public Profile getModel() {
        Profile profile = new Profile();
        profile.setId(getId());
        profile.setCreationDate(getCreationDate());
        profile.setDeleted(isDeleted());
        profile.setDeletedDate(getDeletedDate());
        profile.setLastUpdate(getLastUpdate());
        profile.setName(name);
        return profile;
    }
}
