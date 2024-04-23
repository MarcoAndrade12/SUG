package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO extends UuidDomainDTO implements DTO {

    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private String sexo;
    private String email;
    private List<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
    private EnderecoDTO endereco = new EnderecoDTO();
    private String status;
    private boolean consentimento;

    public UsuarioDTO(MultiValueMap<String, String> body) {
        this.nome = body.getFirst("primeiro_nome");
        this.sobrenome = body.getFirst("sobrenome");
        this.rg = body.getFirst("rg");
        this.cpf = body.getFirst("cpf");
        this.sexo = body.getFirst("sexo");
        this.email = body.getFirst("email");
        this.status = body.getFirst("status");
        String flg = body.getFirst("consentimento");
        this.consentimento = (flg != null && flg.equals("true")) ? true : false;

        this.endereco = new EnderecoDTO(body);

    }

    public Usuario getModel() {

        Usuario usuario = new Usuario();

        usuario.copyDomainOfUuidDomainDTO(this);

        usuario.setNome(getNome());
        usuario.setSobrenome(getSobrenome());
        usuario.setRg(getRg());
        usuario.setCpf(getCpf());
        usuario.setSexo(EnumSexo.stringToSexo(sexo));
        usuario.setEmail(getEmail());

        usuario.setProfiles((List<Profile>) profiles
                .stream()
                .map(
                        profile -> profile.getModel())
                .toList());

        usuario.setStatus(EnumStatusUsuario.stringToEnum(status));
        usuario.setConsentimento(consentimento);
        usuario.setEndereco(endereco.getModel());

        return usuario;
    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof Usuario) {
            Usuario usuario = (Usuario) obj;
            copyDomainOfUuidDomain(usuario);

            this.nome = usuario.getNome();
            this.sobrenome = usuario.getSobrenome();
            this.rg = usuario.getRg();
            this.cpf = usuario.getCpf();
            this.sexo = usuario.getSexo().toString();
            this.email = usuario.getEmail();
            this.profiles = usuario.getProfilesDTO();
            this.endereco = usuario.getEndereco().getDTO();
            this.status = usuario.getStatus().toString();
            this.consentimento = usuario.isConsentimento();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Usuario");
        }

    }

}
