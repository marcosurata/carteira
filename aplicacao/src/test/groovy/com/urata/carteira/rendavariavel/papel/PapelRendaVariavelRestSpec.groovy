package com.urata.carteira.rendavariavel.papel

import com.urata.carteira.Carteira
import com.urata.carteira.CarteiraRepository
import com.urata.carteira.aplicacao.rendavariavel.ServicoPapelRendaVariavel
import com.urata.carteira.rest.PapelRendaVariavelRest
import com.urata.usuario.Usuario
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class PapelRendaVariavelRestSpec extends Specification {
    PapelRendaVariavelRepository papelRepositoryMock = Mock()
    CarteiraRepository carteiraRepositoryMock = Mock()
    ServicoPapelRendaVariavel servicoPapel = new ServicoPapelRendaVariavel(papelRepositoryMock, carteiraRepositoryMock)

    Carteira umaCarteira = new Carteira(usuario: new Usuario(Usuario.createInitializer().login('marcosurata')))

    def mockMvc = MockMvcBuilders.standaloneSetup(new PapelRendaVariavelRest(servicoPapel)).build()

    def 'adicionar nova ordem compra de uma acao'() {
        given:
        String json = '''{
                        "idCarteira": "1",
                        "idPapel": "1",                    
                        "quantidade": 100,
                        "precoUnitario": "33.57",
                        "precoUnitario": "33.57",
                        "valorCorretagem": "0.01",
                        "corretora": "MIRAE"
            }'''

        when:
        def response = mockMvc.perform(post('/carteira/papel-renda-variavel')
                .content(json).contentType('application/json'))

        then:
        response.andExpect(status().isOk())
        1 * carteiraRepositoryMock.findById(_ as Long) >> Optional.of(umaCarteira)
        1 * papelRepositoryMock.findById(_ as Long) >> Optional.of(new PapelRendaVariavel('BBAS3', TipoPapelRendaVariavelEnum.ACAO, TipoBolsaEnum.BOVESPA))
        umaCarteira.ordensCompraPapelRendaVariavel.size() == 1

    }
}
