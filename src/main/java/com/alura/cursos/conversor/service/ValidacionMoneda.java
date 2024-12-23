package com.alura.cursos.conversor.service;

public class ValidacionMoneda {

     public String validarMoneda(String moneda) {
         String monedaBase = "";
         if(moneda == "Dolar") {
             monedaBase = "USD";
         }
         if(moneda == "Peso argentino") {
             monedaBase = "ARS";
         }
         if(moneda == "Real brasileño") {
             monedaBase = "BRL";
         }
         if(moneda == "Peso colombiano") {
             monedaBase = "COP";
         }
       return monedaBase;
     }

}
