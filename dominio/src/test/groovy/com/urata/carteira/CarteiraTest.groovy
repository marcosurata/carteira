package com.urata.carteira

import com.urata.carteira.rendavariavel.papel.OrdemCompraPapelRendaVariavel
import com.urata.carteira.rendavariavel.papel.PapelRendaVariavel
import com.urata.carteira.rendavariavel.papel.TipoBolsaEnum
import com.urata.carteira.rendavariavel.papel.TipoPapelRendaVariavelEnum
import org.junit.Test

class CarteiraTest {

    Carteira carteira = new Carteira()

    @Test
    void calcularPrecoMedioDeAcao() {
        def BBAS3 = new PapelRendaVariavel('BBAS3', TipoPapelRendaVariavelEnum.ACAO, TipoBolsaEnum.BOVESPA)
        def ordemCompraUm = new OrdemCompraPapelRendaVariavel(BBAS3, 200, new BigDecimal(30.83))
        def ordemCompraDois = new OrdemCompraPapelRendaVariavel(BBAS3, 100, new BigDecimal(25.87))

        def ENEV3 = new PapelRendaVariavel('ENEV3', TipoPapelRendaVariavelEnum.ACAO, TipoBolsaEnum.BOVESPA)
        def ordemCompraTres = new OrdemCompraPapelRendaVariavel(ENEV3, 100, new BigDecimal(13.26))

        carteira.adicionarOrdemCompraPapelRendaVariavel(ordemCompraUm)
        carteira.adicionarOrdemCompraPapelRendaVariavel(ordemCompraDois)
        carteira.adicionarOrdemCompraPapelRendaVariavel(ordemCompraTres)

        assert 29.17 == carteira.calcularPrecoMedio(BBAS3)
        assert 13.26 == carteira.calcularPrecoMedio(ENEV3)
    }
}
