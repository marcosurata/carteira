package com.urata.carteira.outros

import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Version
import java.time.LocalDateTime

@Entity
@SequenceGenerator(name = "ID_GENERATOR_CREDITO", sequenceName = "SEQ_CREDITOS_DIVERSOS", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class CreditosDiversos {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_CREDITO", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataConcessaoCredito

    BigDecimal valorCredito

    @Enumerated(EnumType.STRING)
    TipoCredito tipoCredito
}
