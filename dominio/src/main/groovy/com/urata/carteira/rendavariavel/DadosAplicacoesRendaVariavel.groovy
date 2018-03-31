package com.urata.carteira.rendavariavel

import com.urata.carteira.rendavariavel.fundo.AplicacaoFundoRendaVariavel
import com.urata.carteira.rendavariavel.papel.OrdemCompraPapelRendaVariavel

import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Embeddable
class DadosAplicacoesRendaVariavel {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "COD_CARTEIRA", referencedColumnName = "COD", nullable = false)
    Set<OrdemCompraPapelRendaVariavel> ordensCompraPapelRendaVariavel = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "COD_CARTEIRA", referencedColumnName = "COD", nullable = false)
    Set<AplicacaoFundoRendaVariavel> aplicacoesFundoRendaVariavel = new HashSet<>()
}
