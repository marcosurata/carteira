package com.urata.carteira.rendavariavel.fundo

import com.urata.carteira.CorretoraEnum
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
@SequenceGenerator(name = "ID_GENERATOR_FRV", sequenceName = "SEQ_APLICACAO_RENDA_VARIAVEL", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class AplicacaoFundoRendaVariavel {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_FRV", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    String nomeFundo

    BigDecimal valorAplicado

    BigDecimal valorCorretagem

    @Enumerated(EnumType.STRING)
    TipoFundoEnum tipoFundoEnum

    @Enumerated(EnumType.STRING)
    CorretoraEnum corretoraEnum



}
