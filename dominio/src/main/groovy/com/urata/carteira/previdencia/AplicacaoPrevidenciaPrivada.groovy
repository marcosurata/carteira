package com.urata.carteira.previdencia

import com.urata.carteira.rendafixa.DadosEntidadeFinanceira
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Version
import java.time.LocalDateTime

@Entity
@SequenceGenerator(name = "ID_GENERATOR_APP", sequenceName = "SEQ_APLICACAO_PREV_PRIVADA", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class AplicacaoPrevidenciaPrivada {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_APP", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    BigDecimal valorAplicado

    @Embedded
    DadosEntidadeFinanceira dadosEntidadeFinanceira
}
