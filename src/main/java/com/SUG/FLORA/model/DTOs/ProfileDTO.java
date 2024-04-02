package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO extends DomainDTO implements DTO {
    private String name;
}
