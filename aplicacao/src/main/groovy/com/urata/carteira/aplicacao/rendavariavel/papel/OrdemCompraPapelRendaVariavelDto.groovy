package com.urata.carteira.aplicacao.rendavariavel.papel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.urata.carteira.util.DesserializadorBigDecimal
import groovy.transform.Immutable
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
@Immutable(copyWith = true)
class OrdemCompraPapelRendaVariavelDto {

    Long idCarteira
    Long idPapel
    Double quantidade
    @JsonDeserialize(using = DesserializadorBigDecimal.class)
    BigDecimal precoUnitario
    @JsonDeserialize(using = DesserializadorBigDecimal.class)
    BigDecimal valorCorretagem
    String corretora

}
