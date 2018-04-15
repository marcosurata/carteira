package com.urata.carteira

import com.urata.carteira.outros.CreditosDiversos
import com.urata.carteira.previdencia.AplicacaoSuperPrevidencia
import com.urata.carteira.rendafixa.fundo.AplicacaoRendaFixa
import com.urata.carteira.rendafixa.tesourodireto.AplicacaoTesouroDireto
import com.urata.carteira.rendavariavel.fundo.AplicacaoFundoRendaVariavel
import com.urata.carteira.rendavariavel.papel.OrdemCompraPapelRendaVariavel
import com.urata.carteira.rendavariavel.papel.PapelRendaVariavel
import com.urata.usuario.Usuario
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

    @OneToOne
    @JoinColumn(name = "COD_USUARIO", foreignKey = @ForeignKey(name = "FK_CARTEIRA_USUARIO"))
    Usuario usuario

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

    public Carteira() {
        // JPA
    }

    Carteira(Usuario usuario) {
        this.usuario = usuario
    }


    void adicionarOrdemCompraPapelRendaVariavel(OrdemCompraPapelRendaVariavel ordemCompraPapelRendaVariavel) {
        ordensCompraPapelRendaVariavel.add(ordemCompraPapelRendaVariavel)
        ordemCompraPapelRendaVariavel.setCarteira(this)
    }

    BigDecimal calcularPrecoMedio(PapelRendaVariavel papelRendaVariavel) {
        def papeis = ordensCompraPapelRendaVariavel.findAll {
            it.papelRendaVariavel.ticker == papelRendaVariavel.ticker
        }
        def quantidadeDoPapel = papeis.sum { it.quantidade }
        quantidadeDoPapel > 0 ? (papeis.sum {
            it.getValorCompra()
        }).divide(quantidadeDoPapel, 2, RoundingMode.DOWN) : 0
    }

}
