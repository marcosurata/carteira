package com.urata.carteira.aplicacao.rendavariavel.papel.cotacao

import org.springframework.core.io.ClassPathResource

import static AlphaVantageJsonResponseBatchStockQuotes.*
import static AlphaVantageJsonResponseTimesSeriesDailyAdjusted.*

import groovy.json.JsonSlurper


class ServicoCotacaoPapelRendaVariavel {

    final String BASE_URL = 'https://www.alphavantage.co/query?'
    final String API_KEY = new ClassPathResource('alpha-vantage-key.txt').file.text

    final String API_BUSCA_POR_ACAO = 'TIME_SERIES_DAILY_ADJUSTED'
    final String API_BUSCA_LOTE_STOCKS = 'BATCH_STOCK_QUOTES'

    Map<String,BigDecimal> recuperarCotacaoPapelBolsaEUA(String... ticker ) {
        String qs = montarQueryStringURL(API_BUSCA_LOTE_STOCKS, ticker)

        def stocksMap = [:]
        String jsonTxt = "$BASE_URL$qs".toURL().text
        def json = new JsonSlurper().parseText(jsonTxt)

        json[OBJ_ROOT.key].eachWithIndex { el, index ->
            def stock = "$el".values.iterator().next()
            stocksMap[stock[OBJ_SYMBOL.key]] = new BigDecimal(stock[OBJ_PRICE.key])
        }
        stocksMap
    }

    BigDecimal recuperarCotacaoPapelBovespa(String ticker) {
        def papel = ticker +'.SA'
        String qs = montarQueryStringURL(API_BUSCA_POR_ACAO, papel)

        String jsonTxt = "$BASE_URL$qs".toURL().text
        def json = new JsonSlurper().parseText(jsonTxt)

        assert papel == json[OBJ_META_DATA.key][OBJ_STOCK_SYMBOL.key]

        def sortedDates = json[OBJ_TIMES_SERIES.key].keySet()
        def ultimoDiaComPregao = sortedDates.sort().last()

        new BigDecimal(json[OBJ_TIMES_SERIES.key][ultimoDiaComPregao][OBJ_STOCK_CLOSE.key])
    }


    private String montarQueryStringURL(String tipoBuscaAPI, String... ticker) {
        def tickers = ticker.join(',')

        def s = API_BUSCA_LOTE_STOCKS.equals(tipoBuscaAPI) ? 'symbols' : 'symbol'
        def fun = [function: tipoBuscaAPI]
        def sym = [(s): tickers]
        def key = [apikey: API_KEY]

        String qs = (fun + sym + key).collect { k, v -> "$k=$v" }.join('&')
        qs
    }
}
