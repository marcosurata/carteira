package com.urata.carteira.rendafixa

import com.urata.carteira.rendafixa.fundo.AplicacaoRendaFixa
import com.urata.carteira.rendafixa.tesourodireto.AplicacaoTesouroDireto

import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Embeddable
class DadosAplicacoesRendaFixa {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoTesouroDireto> aplicacoesTesouroDireto = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoRendaFixa> aplicacoesRendaFixa = new HashSet<>()
}
