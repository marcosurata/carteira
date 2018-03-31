package com.urata.carteira.rendavariavel.papel


import com.urata.carteira.CorretoraEnum
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.Column
import javax.persistence.Embedded
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
@SequenceGenerator(name = "ID_GENERATOR_OCPRV", sequenceName = "SEQ_ORDEM_COMPRA_PAPEL_RV", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class OrdemCompraPapelRendaVariavel {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_OCPRV", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id;

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataCompra

    double quantidade

    BigDecimal precoUnitario

    BigDecimal valorCorretagem

    @Embedded
    PapelRendaVariavel papelRendaVariavel

    @Enumerated(EnumType.STRING)
    CorretoraEnum corretora


}
