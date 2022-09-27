package org.ar.miguel.FILES.E28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * El gobierno de la Ciudad de Buenos Aires realiza una encuesta
 * en casas de familia. De cada familia se conoce:
 * domicilio, tipo de vivienda (‘C’: casa, ‘D’: departamento), y cantidad de integrantes.
 * De cada integrante de la familia se conoce:
 * nombre, apellido, edad, sexo (‘F’, ‘M’),
 * nivel de estudios alcanzados (‘N’: no posee, ‘P’: primario, ‘S’: secundario, ‘T’: terciario, ‘U’: universitario), y un indicador (‘I’: incompleto, ‘C’: completo) que se refiere al ítem anterior.
 * Los datos finalizan cuando la cantidad de integrantes sea igual a cero.
 * Se pide emitir un listado con los resultados:
 * •Los datos de los encuestados que hayan completado los estudios primarios.
 * •El porcentaje de analfabetismo en la ciudad
 * (se considera analfabetos a los mayores de 10 años que no posean estudios).
 * •	El domicilio de la familia con mayor cantidad de
 * integrantes que viven en departamento.
 * •	La edad promedio de cada familia y de la ciudad.
 * •	La cantidad de encuestados en cada tipo de nivel
 * de estudios alcanzados incompletos.
 * •	El porcentaje de encuestados de sexo femenino y masculino.
 */
public class E28 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        Scanner s = new Scanner(System.in);
        String cadenaLectura = null;
        String[] record = new String[0];
        String vueloAnterior = "";
        int cantidadAsientoAnterior = 0;
        int asientoVendido = 0;
        double ventaRecauda = 0, totalRecaudadoMes = 0;
        int vueloCompleto = 0;
        String vueloMaxRecaudacion = "";
        double maxVentas = 0d;
        try {
            //Put the exact location of the file Datos.csv
            FileReader fileReader = new FileReader("D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\E28\\LOTE.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            cadenaLectura = bufferedReader.readLine();

            if (cadenaLectura != null) {
                record = cadenaLectura.split(";");
            }

            while ((cadenaLectura) != null) {
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
                System.out.println("TOTAL RECAUDADO : " + df.format(ventaRecauda));
                System.out.println("% ASIENTO LIBRE DEL VUELO : " + ((double) (asientoVendido * 100) / cantidadAsientoAnterior));
                System.out.println("% ASIENTO OCUPADO DEL VUELO : " + (100 - (double) (asientoVendido * 100) / cantidadAsientoAnterior));
            }
            System.out.println("CANTIDAD DE VUELOS COMPLETOS : " + vueloCompleto);
            System.out.println("TOTAL RECAUDADO EN EL MES : " + df.format(totalRecaudadoMes));
            System.out.println("VUELO QUE MAS RECAUDO : " + vueloMaxRecaudacion);
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
