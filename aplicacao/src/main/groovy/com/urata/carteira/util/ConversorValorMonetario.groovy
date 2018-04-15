package com.urata.carteira.util

import java.text.DecimalFormat

final class ConversorValorMonetario {
    public static final Locale LOCALE_PT_BR = (new Locale.Builder()).setLanguage("pt").setRegion("BR").build()

    static BigDecimal paraBigDecimal(String valor) {
        if (!valor) return null
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(LOCALE_PT_BR)
        decimalFormat.setParseBigDecimal(true)
        decimalFormat.parse(valor) as BigDecimal
    }

    static String paraString(BigDecimal valor) {
        if (valor == null || !(valor instanceof BigDecimal)) return null
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(LOCALE_PT_BR)
        decimalFormat.applyLocalizedPattern("#.##0,00#")
        decimalFormat.format(valor)
    }
}
