package com.urata.carteira.previdencia

import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*

@Entity
@SequenceGenerator(name = "ID_GENERATOR_PPSP", sequenceName = "SEQ_PERCENTUAL_PARTIC_SUPER_PREV", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class PercentualParticipacaoSuperPrevidencia {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_PPSP", strategy = GenerationType.SEQUENCE)
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
