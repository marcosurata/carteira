package com.urata.carteira.rendavariavel.papel.cotacao

enum AlphaVantageJsonResponseBatchStockQuotes {

    OBJ_ROOT ('Stock Quotes'), OBJ_SYMBOL('1. symbol'), OBJ_PRICE('2. price')

    String key

    AlphaVantageJsonResponseBatchStockQuotes(String elKey) {
        this.key = elKey
    }

}