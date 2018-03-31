package com.urata.carteira.rendavariavel.papel

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
@EqualsAndHashCode
@ToString
class PapelRendaVariavel {

    String cnpj

    String ticker

    @Enumerated(EnumType.STRING)
    TipoPapelRendaVariavelEnum tipoRendaVariavelEnum

    @Enumerated(EnumType.STRING)
    TipoRamoInvestimentoEnum tipoRamoInvestimentoEnum

    @Enumerated(EnumType.STRING)
    TipoBolsaEnum tipoBolsaEnum
}
