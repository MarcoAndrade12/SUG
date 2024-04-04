package com.SUG.FLORA.model.endereco;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import com.SUG.FLORA.enums.EnumRegiao;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.DTOs.RegiaoDoPaisDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RegiaoDoPais extends IntDomain implements DTOConvertible { 
   
	@Enumerated(EnumType.STRING)
    private EnumRegiao nome;

    @OneToMany
    @JoinColumn(name = "regiao_id")
    private List<Estado> estados = new ArrayList<Estado>();

    public RegiaoDoPaisDTO getDTO() {
        RegiaoDoPaisDTO DTO = new RegiaoDoPaisDTO();
        DTO.setId(getId());
		DTO.setCreationDate(getCreationDate());
		DTO.setDeleted(isDeleted());
		DTO.setDeletedDate(getDeletedDate());

        DTO.setNome(nome);
        DTO.setEstados(estados.stream().map(estado -> estado.getDTO()).toList());

        return DTO;
    }


}
