package com.urata.carteira.previdencia

import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Version
import java.time.LocalDateTime

@Entity
@SequenceGenerator(name = "ID_GENERATOR_APS", sequenceName = "SEQ_APLICACAO_SUPER_PREV", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class AplicacaoSuperPrevidencia {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_APS", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    BigDecimal valorAplicado

    @OneToMany(mappedBy = "aplicacaoSuperPrevidencia")
    List<PercentualParticipacaoSuperPrevidencia> planosPrevidencia;
}
