package com.cadastro.usuario.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioDto {
    @NotBlank
    private String senha;
    @NotBlank
    private String usuario;
}
