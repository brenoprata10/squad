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
@Table(name = "tb_transacao", schema = "sippe")
public class Transacao implements Serializable {

    private static final long serialVersionUID = -6772068781205429091L;

    @Id
    @Column(name = "cod_transacao")
    private Long id;

    @Column(name = "dt_transacao")
    @NotNull(message = "A data da transação não pode ser vazia")
    private LocalDateTime dataTransacao;

    @Column(name = "valor")
    @NotNull(message = "O valor não pode ser vazio")
    private BigDecimal valor;

    @Column(name = "saldo_posterior")
    @NotNull(message = "O saldo posterior não pode ser vazio")
    private BigDecimal saldoPosterior;

    @Column(name = "saldo_anterior")
    @NotNull(message = "O saldo anterior não pode ser vazio")
    private BigDecimal saldoAnterior;

    @Column(name = "dt_debito")
    @NotNull(message = "A data do débito não pode ser vazia")
    private LocalDateTime dataDebito;

    @Column(name = "cod_conta_destino")
    private String contaDestino;

    @Column(name = "cod_agencia_destino")
    @NotEmpty(message = "O código da agencia destino não pode ser nulo")
    private String codigoAgenciaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_agencia",
            foreignKey = @ForeignKey(name = "fk_transacao_agencia"))
    private Agencia agencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_banco",
            foreignKey = @ForeignKey(name = "fk_transacao_banco"))
    private Banco banco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_conta",
            foreignKey = @ForeignKey(name = "fk_transacao_conta"))
    @NotNull(message = "A conta de origem não pode ser vazia")
    private Conta contaOrigem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_movimentacao",
            foreignKey = @ForeignKey(name = "fk_transacao_tipo_movimentacao"))
    @NotNull(message = "O tipo da movimentação não pode ser vazia")
    private TipoMovimentacao tipoMovimentacao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo_transacao",
            foreignKey = @ForeignKey(name = "fk_transacao_tipo_transacao"))
    @NotNull(message = "O tipo da transação não pode ser vazia")
    private TipoTransacao tipoTransacao;
}
