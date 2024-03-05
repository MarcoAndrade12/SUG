package com.SUG.FLORA.model.endereco;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.SUG.FLORA.enums.EnumRegiao;
import com.SUG.FLORA.model.Domain;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RegiaoDoPais extends Domain{ 
   
	@Enumerated(EnumType.STRING)
    private EnumRegiao nome;

    @OneToMany
    @JoinColumn(name = "regiao_id")
    private List<Estado> estados;


}
