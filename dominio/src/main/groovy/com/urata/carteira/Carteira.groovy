package com.urata.carteira

import com.urata.carteira.outros.CreditosDiversos
import com.urata.carteira.previdencia.AplicacaoSuperPrevidencia
import com.urata.carteira.rendafixa.DadosAplicacoesRendaFixa
import com.urata.carteira.rendafixa.fundo.AplicacaoRendaFixa
import com.urata.carteira.rendafixa.tesourodireto.AplicacaoTesouroDireto
import com.urata.carteira.rendavariavel.DadosAplicacoesRendaVariavel
import com.urata.carteira.rendavariavel.fundo.AplicacaoFundoRendaVariavel
import com.urata.carteira.rendavariavel.papel.OrdemCompraPapelRendaVariavel
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Version

@Entity
@SequenceGenerator(name = "ID_GENERATOR_CARTEIRA", sequenceName = "SEQ_CARTEIRA", allocationSize = 1)
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class Carteira {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR_CARTEIRA", strategy = GenerationType.SEQUENCE)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @Embedded
    DadosAplicacoesRendaVariavel dadosAplicacoesRendaVariavel

    @Embedded
    DadosAplicacoesRendaFixa dadosAplicacoesRendaFixa


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "COD_CARTEIRA", referencedColumnName = "COD", nullable = false)
    Set<AplicacaoSuperPrevidencia> aplicacoesSuperPrevidencia = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "COD_CARTEIRA", referencedColumnName = "COD", nullable = false)
    Set<CreditosDiversos> creditosDiversos = new HashSet<>()





}
