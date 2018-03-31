package com.urata.carteira.rendafixa.fundo

import com.urata.carteira.CorretoraEnum
import com.urata.carteira.rendafixa.DadosEntidadeFinanceira
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@SequenceGenerator(name = "ID_GENERATOR_RF", sequenceName = "SEQ_APLICACAO_RENDA_FIXA", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class AplicacaoRendaFixa {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_RF", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    String nomeFundo

    BigDecimal valorAplicado

    float taxaCDI

    LocalDateTime dataVencimento

    BigDecimal valorCorretagem

    @Embedded
    DadosEntidadeFinanceira dadosEntidadeFinanceira

    @Enumerated(EnumType.STRING)
    TipoAplicacaoRendaFixaEnum tipoAplicacaoRendaFixaEnum

    @Enumerated(EnumType.STRING)
    CorretoraEnum corretoraEnum
}
