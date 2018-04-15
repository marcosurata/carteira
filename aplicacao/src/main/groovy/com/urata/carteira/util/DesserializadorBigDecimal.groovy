package com.urata.carteira.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer


final class DesserializadorBigDecimal extends JsonDeserializer<BigDecimal> {

    @Override
    BigDecimal deserialize(JsonParser jsonParser,
                           DeserializationContext deserializationContext) throws IOException {
        ConversorValorMonetario.paraBigDecimal(jsonParser.getText())
    }
}
