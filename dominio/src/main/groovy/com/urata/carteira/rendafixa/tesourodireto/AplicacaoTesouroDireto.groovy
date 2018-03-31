package com.urata.carteira.rendafixa.tesourodireto

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
@SequenceGenerator(name = "ID_GENERATOR_TD", sequenceName = "SEQ_APLICACAO_TESOURO_DIRETO", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class AplicacaoTesouroDireto {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_TD", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    float taxaJuros

    BigDecimal valorAplicado

    BigDecimal precoUnitario

    BigDecimal valorCorretagem

    @Enumerated(EnumType.STRING)
    TipoTituloTesouroDiretoEnum tipoTituloTesouroDiretoEnum

    @Enumerated(EnumType.STRING)
    CorretoraEnum corretoraEnum

}
