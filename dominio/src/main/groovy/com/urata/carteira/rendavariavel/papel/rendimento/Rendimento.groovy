package com.urata.carteira.rendavariavel.papel.rendimento

import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class Rendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @Column(nullable = false)
    LocalDateTime dataPagamento

    @Column(nullable = false)
    BigDecimal valor

    @Enumerated(EnumType.STRING)
    TipoRendimento tipoRendimento
}
