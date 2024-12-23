package com.alura.cursos.conversor.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeRate(
        @JsonAlias("base_code")
        String monedaBase,
        @JsonAlias("target_code")
        String monedaAConvertir,
        @JsonAlias("conversion_rate")
        String tasaDeConversion,
        @JsonAlias("conversion_result")
        String resultadoDeConversion
) {
        @Override
        public String toString() {
                return "\nCambio de moneda exitoso......" +
                        "\nmoneda base = " + monedaBase +
                        ", \nmoneda de conversion = " + monedaAConvertir +
                        ", \ntasa de conversion = " + tasaDeConversion +
                        ", \nresultado de la conversion = " + resultadoDeConversion;
        }
}
