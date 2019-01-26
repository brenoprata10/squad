package br.com.cabal.squardsippe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_conta", schema = "sippe")
public class Conta implements Serializable {

    private static final long serialVersionUID = 5176558673356111259L;

    @Id
    @Column(name = "cod_conta")
    private Long id;

    @Column(name = "numero_conta")
    @NotEmpty(message = "O número conta não pode ser vazio")
    private String numeroConta;

    @Column(name = "saldo")
    @NotNull(message = "O saldo da conta não pode ser vazio")
    private BigDecimal saldo;

    @Column(name = "ativa")
    @NotNull(message = "A conta deve possuir especificação de ativo/inativo")
    private Boolean ativa;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_usuario",
            foreignKey = @ForeignKey(name = "fk_conta_usuario"))
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_conta",
            foreignKey = @ForeignKey(name = "fk_conta_tipo_conta"))
    @NotNull(message = "O tipo da conta não pode ser vazio")
    private TipoConta tipoConta;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_agencia",
            foreignKey = @ForeignKey(name = "fk_conta_agencia"))
    private Agencia agencia;
}
