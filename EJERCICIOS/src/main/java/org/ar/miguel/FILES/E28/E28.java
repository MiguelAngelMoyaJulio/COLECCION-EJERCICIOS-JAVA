package org.ar.miguel.FILES.E28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Una compañía aérea desea emitir un listado con los movimientos mensuales de sus m vuelos al exterior.
 * Para ello cuenta con la siguiente información:
 * •	De cada vuelo realizado el número de vuelo, destino, y cantidad de asientos.
 * •	De cada pasajero el número de pasaporte y el importe que abonó por el pasaje (en dólares). La información finaliza con un número de pasaporte igual a cero. Se pide emitir el siguiente listado: Nro. de Vuelo: 9999, Destino: xxxxxxxxxxxxxxxxx
 * Nro. de Pasaporte	Importe en u$s
 * 99999999	999.99
 * 99999999	999.99
 * 99999999	999.99
 * Total recaudado del vuelo: $99999.99
 * % de Asientos Libres del vuelo: 999.99
 * % de Asientos Ocupados del vuelo: 999.99
 * :	:	:
 * Total recaudado en el mes: $999999.99
 * Cantidad de veces seguidas que se dieron vuelos completos: 99 El número de vuelo que más recaudó: 9999
 */
public class E28 {
    private final static String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\E28\\LOTE.txt";

    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        String cadenaLectura = null;
        String[] record = new String[0];
        String vueloAnterior = "", vueloMaxRecaudacion = "";
        int cantidadAsientoAnterior = 0, asientoVendido = 0, vueloCompleto = 0;
        double ventaRecauda = 0, totalRecaudadoMes = 0, maxVentas = 0d;

        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);
            cadenaLectura = bufferedReader.readLine();

            while ((cadenaLectura) != null) {
                record = cadenaLectura.split(";");
                ventaRecauda = 0;
                vueloAnterior = record[0];
                asientoVendido = 0;
                cantidadAsientoAnterior = Integer.parseInt(record[2]);
                System.out.println("NUMERO DE VUELO : " + vueloAnterior + " DESTINO : " + record[1].toUpperCase());
                System.out.println("NUMERO DE PASAPORTE     IMPORTE");
                while (vueloAnterior.equals(record[0]) && (cadenaLectura) != null) {
                    System.out.println("      " + record[3] + "             " + df.format(Double.parseDouble(record[4])));
                    asientoVendido++;
                    ventaRecauda = ventaRecauda + Double.parseDouble(record[4]);
                    cadenaLectura = bufferedReader.readLine();
                    if (cadenaLectura != null) {
                        record = cadenaLectura.split(";");
                    }
                }

                if (ventaRecauda > maxVentas) {
                    vueloMaxRecaudacion = vueloAnterior;
                    maxVentas = ventaRecauda;
                }

                if (asientoVendido == cantidadAsientoAnterior) {
                    vueloCompleto++;
                }

                totalRecaudadoMes = totalRecaudadoMes + ventaRecauda;
                totalCutFilght(df, ventaRecauda, asientoVendido, cantidadAsientoAnterior);
            }
            finalTotal(df,vueloCompleto,totalRecaudadoMes,vueloMaxRecaudacion);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void totalCutFilght(DecimalFormat df, double ventaRecauda, int asientoVendido, int cantidadAsientoAnterior) {
        System.out.println("TOTAL RECAUDADO : " + df.format(ventaRecauda));
        System.out.println("% ASIENTO LIBRE DEL VUELO : " + ((double) (asientoVendido * 100) / cantidadAsientoAnterior));
        System.out.println("% ASIENTO OCUPADO DEL VUELO : " + (100 - (double) (asientoVendido * 100) / cantidadAsientoAnterior));
    }

    private static void finalTotal(DecimalFormat df, int vueloCompleto, double totalRecaudadoMes, String vueloMaxRecaudacion) {
        System.out.println("CANTIDAD DE VUELOS COMPLETOS : " + vueloCompleto);
        System.out.println("TOTAL RECAUDADO EN EL MES : " + df.format(totalRecaudadoMes));
        System.out.println("VUELO QUE MAS RECAUDO : " + vueloMaxRecaudacion);
    }
}

