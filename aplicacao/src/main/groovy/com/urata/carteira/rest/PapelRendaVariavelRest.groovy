package com.urata.carteira.rest

import com.urata.carteira.aplicacao.rendavariavel.ServicoPapelRendaVariavel
import com.urata.carteira.aplicacao.rendavariavel.papel.OrdemCompraPapelRendaVariavelDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/carteira/papel-renda-variavel")
class PapelRendaVariavelRest {

    ServicoPapelRendaVariavel servicoPapelRendaVariavel

    PapelRendaVariavelRest(ServicoPapelRendaVariavel servicoPapelRendaVariavel) {
        this.servicoPapelRendaVariavel = servicoPapelRendaVariavel
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    void adicionar(@RequestBody OrdemCompraPapelRendaVariavelDto dto) {
        servicoPapelRendaVariavel.criar(dto)
    }


}
