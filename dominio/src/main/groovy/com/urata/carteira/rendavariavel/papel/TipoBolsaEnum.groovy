package com.urata.carteira.rendavariavel.papel

enum TipoBolsaEnum {

    BOVESPA, NYSE, NASDAQ

    boolean isBolsaEUA() {
        this == NYSE || this == NASDAQ
    }
}