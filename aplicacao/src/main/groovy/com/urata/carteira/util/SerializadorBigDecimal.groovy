package com.urata.carteira.util

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

final class SerializadorBigDecimal extends JsonSerializer<BigDecimal> {

    @Override
    void serialize(BigDecimal valorMonetario, JsonGenerator jsonGenerator,
                   SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(ConversorValorMonetario.paraString(valorMonetario))
    }
}
