package com.SUG.FLORA.model.DTOs;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO extends UuidDomainDTO implements DTO {
    private String name;

    public ProfileDTO(MultiValueMap<String, String> body){
        this.name = body.getFirst("primeiro_nome");
    }  

    @Override
    public Profile getModel() {

        Profile profile = new Profile();
        profile.copyDomainOfUuidDomainDTO(this);

        profile.setName(name);
        return profile;
    }
}
