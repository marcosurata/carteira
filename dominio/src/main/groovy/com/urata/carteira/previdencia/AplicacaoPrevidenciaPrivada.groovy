package com.urata.carteira.previdencia

import com.urata.carteira.rendafixa.DadosEntidadeFinanceira
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class AplicacaoPrevidenciaPrivada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
