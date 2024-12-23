package com.alura.cursos.conversor.principal;

import com.alura.cursos.conversor.model.ExchangeRate;
import com.alura.cursos.conversor.service.ConsumirAPI;
import com.alura.cursos.conversor.service.ConvierteDatos;
import com.alura.cursos.conversor.service.ValidacionMoneda;

import java.util.Scanner;

public class Principal {

    private static final String url = "https://v6.exchangerate-api.com/v6/6875f50372284d4c1d9568e2/pair/";
    private static final Scanner in = new Scanner(System.in);
    private ConsumirAPI consumirAPI = new ConsumirAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private ValidacionMoneda validacionMoneda = new ValidacionMoneda();

    public void muestraElMenu() {
        ExchangeRate datos;
        String monedaBase;
        String monedaAConvertir;
        String json;
        int cantidadAConvertir;

        int opcion = 0;
        while(opcion != 7) {
            System.out.println("\n********************************************");
            System.out.print("Sea bienvendido/a al conversor de monedas =]" +
                    "\n 1) Dolar => Peso argentino" +
                    "\n 2) Peso argentino => Dolar" +
                    "\n 3) Dolar => Real brasileño" +
                    "\n 4) Real brasileño => Dolar" +
                    "\n 5) Dolar => Peso colombiano" +
                    "\n 6) Peso colombiano => Dolar" +
                    "\n 7) Salir => Salir" +
                    "\n Eliga una opcion valida: ");
            opcion = in.nextInt();
            System.out.println("********************************************\n");

            switch (opcion) {
                case 1:
                    cantidadAConvertir = cantidadDeDinero();
                    monedaBase = validacionMoneda.validarMoneda("Dolar");
                    monedaAConvertir = validacionMoneda.validarMoneda("Peso argentino");
                    json = construirURL(monedaBase, monedaAConvertir, cantidadAConvertir);
                    datos = convierteDatos.obtenerDatos(json, ExchangeRate.class);
                    System.out.println(datos);
                    break;

                case 2:
                    cantidadAConvertir = cantidadDeDinero();
                    monedaBase = validacionMoneda.validarMoneda("Peso argentino");
                    monedaAConvertir = validacionMoneda.validarMoneda("Dolar");
                    json = construirURL(monedaBase, monedaAConvertir, cantidadAConvertir);
                    datos = convierteDatos.obtenerDatos(json, ExchangeRate.class);
                    System.out.println(datos);
                    break;

                case 3:
                    cantidadAConvertir = cantidadDeDinero();
                    monedaBase = validacionMoneda.validarMoneda("Dolar");
                    monedaAConvertir = validacionMoneda.validarMoneda("Real brasileño");
                    json = construirURL(monedaBase, monedaAConvertir, cantidadAConvertir);
                    datos = convierteDatos.obtenerDatos(json, ExchangeRate.class);
                    System.out.println(datos);
                    break;

                case 4:
                    cantidadAConvertir = cantidadDeDinero();
                    monedaBase = validacionMoneda.validarMoneda("Real brasileño");
                    monedaAConvertir = validacionMoneda.validarMoneda("Dolar");
                    json = construirURL(monedaBase, monedaAConvertir, cantidadAConvertir);
                    datos = convierteDatos.obtenerDatos(json, ExchangeRate.class);
                    System.out.println(datos);
                    break;

                case 5:
                    cantidadAConvertir = cantidadDeDinero();
                    monedaBase = validacionMoneda.validarMoneda("Dolar");
                    monedaAConvertir = validacionMoneda.validarMoneda("Peso colombiano");
                    json = construirURL(monedaBase, monedaAConvertir, cantidadAConvertir);
                    datos = convierteDatos.obtenerDatos(json, ExchangeRate.class);
                    System.out.println(datos);
                    break;

                case 6:
                    cantidadAConvertir = cantidadDeDinero();
                    monedaBase = validacionMoneda.validarMoneda("Peso colombiano");
                    monedaAConvertir = validacionMoneda.validarMoneda("Dolar");
                    json = construirURL(monedaBase, monedaAConvertir, cantidadAConvertir);
                    datos = convierteDatos.obtenerDatos(json, ExchangeRate.class);
                    System.out.println(datos);
                    break;

                case 7:
                    System.out.println("Programa finalizado!!");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    public int cantidadDeDinero() {
        int cantidad;
        System.out.print("Digite la cantidad de dinero a convertir: ");
        cantidad = in.nextInt();
        return cantidad;
    }

    public String construirURL(String monedaBase, String monedaAConvertir, int cantidad) {
        return consumirAPI.obtenerDatos(url + monedaBase + "/" + monedaAConvertir + "/" + cantidad);
    }
}
