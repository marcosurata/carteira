package com.urata.carteira.rendavariavel.papel

import com.urata.carteira.Carteira
import com.urata.carteira.comum.CorretoraEnum
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class OrdemCompraPapelRendaVariavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @Column(nullable = false)
    LocalDateTime dataCompra

    @Column(nullable = false)
    double quantidade

    @Column(nullable = false)
    BigDecimal precoUnitario = 0

    BigDecimal valorCorretagem = 0

    @OneToOne
    @JoinColumn(name = "COD_PAPEL", foreignKey = @ForeignKey(name="FK_OCPRV_COD_PAPEL"))
    PapelRendaVariavel papelRendaVariavel

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CorretoraEnum corretora

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COD_CARTEIRA", foreignKey = @ForeignKey(name="FK_OCPRV_COD_CARTEIRA"))
    Carteira carteira

    private OrdemCompraPapelRendaVariavel() {
        // JPA
    }

    OrdemCompraPapelRendaVariavel(PapelRendaVariavel papelRendaVariavel, double quantidade, BigDecimal precoUnitario) {
        this(papelRendaVariavel, quantidade, precoUnitario, 0, null)
    }

    OrdemCompraPapelRendaVariavel(PapelRendaVariavel papelRendaVariavel, double quantidade, BigDecimal precoUnitario, BigDecimal valorCorretagem, CorretoraEnum corretora) {
        this.papelRendaVariavel = papelRendaVariavel
        this.quantidade = quantidade
        this.precoUnitario = precoUnitario
        this.valorCorretagem = valorCorretagem
        this.corretora = corretora
        this.dataCompra = LocalDateTime.now()
    }

    BigDecimal getValorCompra() {
        (quantidade * precoUnitario) + valorCorretagem
    }

    @Override
    public String toString() {
        return "OrdemCompraPapelRendaVariavel{" +
                "quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", papelRendaVariavel=" + papelRendaVariavel +
                '}';
    }
}
