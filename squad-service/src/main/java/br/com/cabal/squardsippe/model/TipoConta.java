package br.com.cabal.squardsippe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_tipo_conta", schema = "sippe")
public class TipoConta implements Serializable {

    private static final long serialVersionUID = -3203018963885896519L;

    @Id
    @Column(name = "cod_tipo_conta")
    private Long id;

    @Column(name = "descricao", nullable = false)
    @NotEmpty(message = "A descrição não pode ser vazia")
    private String descricao;
}
