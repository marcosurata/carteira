package com.urata.carteira.rendavariavel.papel

import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class PapelRendaVariavel {

    PapelRendaVariavel() {
        // Hibernate
    }

    PapelRendaVariavel(String ticker, TipoPapelRendaVariavelEnum tipoRendaVariavel, TipoBolsaEnum tipoBolsa) {
        this.ticker = ticker
        this.tipoRendaVariavel = tipoRendaVariavel
        this.tipoBolsa = tipoBolsa
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id;

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    String cnpj

    @Column(nullable = false)
    String ticker

    String descricao

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TipoPapelRendaVariavelEnum tipoRendaVariavel

    @Enumerated(EnumType.STRING)
    TipoRamoInvestimentoEnum tipoRamoInvestimento

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TipoBolsaEnum tipoBolsa
}
