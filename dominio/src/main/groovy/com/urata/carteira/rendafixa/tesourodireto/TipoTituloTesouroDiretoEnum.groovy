package com.urata.carteira.rendafixa.tesourodireto

import java.time.LocalDate

enum TipoTituloTesouroDiretoEnum {

    IPCA_MAIS_NTNB_P_35(LocalDate.of(2035,05,15)),
    SELIC_LFT_21(LocalDate.of(2021,3,1)),
    SELIC_LFT_23(LocalDate.of(2023,3,1)),
    IPCA_MAIS_NTNB_50(LocalDate.of(2050,8,15))

    LocalDate dataVencimento

    TipoTituloTesouroDiretoEnum(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento
    }

}