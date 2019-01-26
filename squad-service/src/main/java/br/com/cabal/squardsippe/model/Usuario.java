package br.com.cabal.squardsippe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario", schema = "sippe")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -6596084529099512004L;

    @Id
    @Column(name = "cod_usuario")
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotEmpty(message = "O nome do usuário não deve ser vazio")
    private String nome;

    @Column(name = "cpf", nullable = false)
    @NotEmpty(message = "O CPF não pode ser vazio")
    private String cpf;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "O email não pode ser vazio")
    private String email;

}
