package br.com.cabal.squardsippe.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;

    private String nome;

    private String cpf;

    private String email;
}
