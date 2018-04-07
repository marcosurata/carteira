package com.urata.carteira

import com.urata.carteira.outros.CreditosDiversos
import com.urata.carteira.previdencia.AplicacaoSuperPrevidencia

import com.urata.carteira.rendafixa.fundo.AplicacaoRendaFixa
import com.urata.carteira.rendafixa.tesourodireto.AplicacaoTesouroDireto
import com.urata.carteira.rendavariavel.fundo.AplicacaoFundoRendaVariavel
import com.urata.carteira.rendavariavel.papel.OrdemCompraPapelRendaVariavel
import com.urata.carteira.rendavariavel.papel.PapelRendaVariavel
import groovy.transform.ToString

import javax.persistence.*
import java.math.RoundingMode

@Entity
@ToString
class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<OrdemCompraPapelRendaVariavel> ordensCompraPapelRendaVariavel = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoFundoRendaVariavel> aplicacoesFundoRendaVariavel = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoTesouroDireto> aplicacoesTesouroDireto = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoRendaFixa> aplicacoesRendaFixa = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<AplicacaoSuperPrevidencia> aplicacoesSuperPrevidencia = new HashSet<>()

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carteira")
    Set<CreditosDiversos> creditosDiversos = new HashSet<>()


    void adicionarOrdemCompraPapelRendaVariavel(OrdemCompraPapelRendaVariavel ordemCompraPapelRendaVariavel) {
        ordensCompraPapelRendaVariavel.add(ordemCompraPapelRendaVariavel)
        ordemCompraPapelRendaVariavel.setCarteira(this)
    }

    BigDecimal calcularPrecoMedio(PapelRendaVariavel papelRendaVariavel) {
        double quantidade = 0
        BigDecimal valorCompra = 0G
        for (OrdemCompraPapelRendaVariavel umaOrdemCompraPapel  : ordensCompraPapelRendaVariavel) {
            if(umaOrdemCompraPapel.getPapelRendaVariavel().getTicker().equalsIgnoreCase(papelRendaVariavel.getTicker())) {
                quantidade += umaOrdemCompraPapel.getQuantidade()
                valorCompra += umaOrdemCompraPapel.getValorCompra()
            }
        }
        return quantidade > 0 ?  valorCompra.divide(quantidade, 2, RoundingMode.DOWN) : BigDecimal.ZERO
    }

}
