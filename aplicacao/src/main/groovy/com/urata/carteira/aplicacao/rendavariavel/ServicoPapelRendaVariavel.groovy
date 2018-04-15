package com.urata.carteira.aplicacao.rendavariavel

import com.urata.carteira.Carteira
import com.urata.carteira.CarteiraRepository
import com.urata.carteira.aplicacao.rendavariavel.papel.OrdemCompraPapelRendaVariavelDto
import com.urata.carteira.comum.CorretoraEnum
import com.urata.carteira.rendavariavel.papel.OrdemCompraPapelRendaVariavel
import com.urata.carteira.rendavariavel.papel.PapelRendaVariavel
import com.urata.carteira.rendavariavel.papel.PapelRendaVariavelRepository
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
class ServicoPapelRendaVariavel {

    final PapelRendaVariavelRepository papelRendaVariavelRepository
    final CarteiraRepository carteiraRepository

    ServicoPapelRendaVariavel(PapelRendaVariavelRepository papelRendaVariavelRepository, CarteiraRepository carteiraRepository) {
        this.papelRendaVariavelRepository = papelRendaVariavelRepository
        this.carteiraRepository = carteiraRepository
    }

    @Transactional
    void criar(OrdemCompraPapelRendaVariavelDto dto) {
        Optional<Carteira> carteira = carteiraRepository.findById(dto.idCarteira)
        Optional<PapelRendaVariavel> papel = papelRendaVariavelRepository.findById(dto.idPapel)
        OrdemCompraPapelRendaVariavel novaOrdemCompra = new OrdemCompraPapelRendaVariavel(papel.get(), dto.quantidade, dto.precoUnitario, dto.valorCorretagem, CorretoraEnum.valueOf(dto.corretora))
        carteira.get().adicionarOrdemCompraPapelRendaVariavel(novaOrdemCompra)
    }

    Optional<String> a() {
        return Optional.of("marcos")
    }

    static void main(String[] args) {
        def m = new ServicoPapelRendaVariavel(null, null).a()
        println m.get()
    }


}
