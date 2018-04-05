package com.urata.carteira.previdencia

import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class PercentualParticipacaoSuperPrevidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    float percentual

    @ManyToOne
    @JoinColumn(name = "COD_APLICACAO_SUPER_PREV")
    AplicacaoSuperPrevidencia aplicacaoSuperPrevidencia

    @ManyToOne
    @JoinColumn(name = "COD_APLICACAO_PREV_PRIVADA")
    AplicacaoPrevidenciaPrivada aplicacaoPrevidenciaPrivada
}
