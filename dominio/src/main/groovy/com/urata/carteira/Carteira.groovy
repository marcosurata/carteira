package com.urata.carteira

import com.urata.carteira.outros.CreditosDiversos
import com.urata.carteira.previdencia.AplicacaoSuperPrevidencia
import com.urata.carteira.rendafixa.DadosAplicacoesRendaFixa
import com.urata.carteira.rendavariavel.DadosAplicacoesRendaVariavel
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @Embedded
    DadosAplicacoesRendaVariavel dadosAplicacoesRendaVariavel

    @Embedded
    DadosAplicacoesRendaFixa dadosAplicacoesRendaFixa


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoSuperPrevidencia> aplicacoesSuperPrevidencia = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<CreditosDiversos> creditosDiversos = new HashSet<>()


}
