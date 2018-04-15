package com.urata.carteira.rendavariavel.papel.cotacao

import com.urata.carteira.aplicacao.rendavariavel.papel.cotacao.ServicoCotacaoPapelRendaVariavel
import org.junit.Test

class ServicoCotacaoPapelRendaVariavelTest {

    ServicoCotacaoPapelRendaVariavel servicoCotacaoPapelRendaVariavel = new ServicoCotacaoPapelRendaVariavel()

    @Test
    void deveRecuperarCotacaoUmPapelBolsaEUA() {
        Map<String, BigDecimal> dadosCotacao = servicoCotacaoPapelRendaVariavel.recuperarCotacaoPapelBolsaEUA('AAPL')
        assert dadosCotacao.containsKey('AAPL') != null
        assert dadosCotacao.get('AAPL') > 0G
    }

    @Test
    void deveRecuperarCotacaoMultiplosPapeisBolsaEUA() {
        Map<String, BigDecimal> dadosCotacao = servicoCotacaoPapelRendaVariavel.recuperarCotacaoPapelBolsaEUA('AAPL', 'FB', 'APTS','DLR')
        assert dadosCotacao.containsKey('AAPL') != null
        assert dadosCotacao.get('AAPL') > 0G

        assert dadosCotacao.containsKey('FB') != null
        assert dadosCotacao.get('FB') > 0G

        assert dadosCotacao.containsKey('APTS') != null
        assert dadosCotacao.get('APTS') > 0G

        assert dadosCotacao.containsKey('DLR') != null
        assert dadosCotacao.get('DLR') > 0G
    }

    @Test
    void deveRecuperarCotacaoUmaAcaoBovespa() {
        BigDecimal cotacao = servicoCotacaoPapelRendaVariavel.recuperarCotacaoPapelBovespa('MDIA3')
        assert cotacao > 0G
    }

    @Test
    void deveRecuperarCotacaoUmaFundoImobiliarioBovespa() {
        BigDecimal cotacao = servicoCotacaoPapelRendaVariavel.recuperarCotacaoPapelBovespa('BRCR11')
        assert cotacao > 0G
    }

}
