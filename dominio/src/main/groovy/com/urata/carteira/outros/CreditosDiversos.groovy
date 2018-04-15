package com.urata.carteira.outros

import com.urata.carteira.Carteira
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class CreditosDiversos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataConcessaoCredito

    BigDecimal valorCredito

    @Enumerated(EnumType.STRING)
    TipoCredito tipoCredito

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COD_CARTEIRA", foreignKey = @ForeignKey(name="FK_CD_COD_CARTEIRA"))
    Carteira carteira
}
