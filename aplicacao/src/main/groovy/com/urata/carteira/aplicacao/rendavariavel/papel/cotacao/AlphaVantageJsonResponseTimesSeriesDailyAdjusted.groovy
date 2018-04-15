package com.urata.carteira.aplicacao.rendavariavel.papel.cotacao

enum AlphaVantageJsonResponseTimesSeriesDailyAdjusted {

    OBJ_META_DATA ('Meta Data'), OBJ_TIMES_SERIES('Time Series (Daily)'), OBJ_STOCK_SYMBOL('2. Symbol'), OBJ_STOCK_CLOSE('4. close')

    String key

    AlphaVantageJsonResponseTimesSeriesDailyAdjusted(String elKey) {
        this.key = elKey
    }

}