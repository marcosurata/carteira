package com.urata.carteira.rendafixa

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
@EqualsAndHashCode
@ToString
class DadosEntidadeFinanceira {
    @Column(name = "NOME_ENTIDADE_FINANCEIRA")
    String nome

    @Column(name = "CNPJ_ENTIDADE_FINANCEIRA")
    String cnpj
}
