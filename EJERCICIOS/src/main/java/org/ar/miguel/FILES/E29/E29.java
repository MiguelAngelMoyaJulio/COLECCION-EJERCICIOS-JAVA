package org.ar.miguel.FILES.E29;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * De un censo realizado en una población se conocen los siguientes datos:
 * 1.	Día de nacimiento (2 dígitos)
 * 2.	Mes (2 dígitos)
 * 3.	Año (4 dígitos)
 * 4.	Sexo ('M'=masculino, 'F'=femenino)
 * Con estos datos de cada habitante se forma un lote, finalizado su ingreso con un día igual a 0. Se pide desarrollar el programa que determine e imprima:
 * 1.	Cuántos nacimientos hubo en el mes de octubre de todos los años.
 * 2.	Cuántos nacimientos hubo antes del 9 de julio de 1990.
 * 3.	Cuántos nacimientos de mujeres hubo en la primavera del 1982.
 * 4.	Sexo de la persona más vieja (solo existe una).
 */
public class E29 {
    private static final String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E29\\LOTE.txt";

    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String cadenaLectura = null, sex = "";
        String[] record = new String[0];
        int birthsOnOctober = 0, birthsBeforeNineJuly = 0, birthsFemaleSpring = 0;
        int anio = 0, anioMinimum = 0, i = 0;

        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);
            while ((cadenaLectura = bufferedReader.readLine()) != null) {
                record = cadenaLectura.split(";");
                if (Integer.parseInt(record[1]) == 10) {
                    birthsOnOctober++;
                }
                if (Integer.parseInt(record[2]) < 1990) {
                    birthsBeforeNineJuly++;
                } else if (Integer.parseInt(record[2]) == 1990) {
                    if (Integer.parseInt(record[1]) >= 1 && Integer.parseInt(record[1]) <= 6) {
                        birthsBeforeNineJuly++;
                    } else if (Integer.parseInt(record[1]) == 7 && Integer.parseInt(record[0]) >= 1 && Integer.parseInt(record[0]) <= 9) {
                        birthsBeforeNineJuly++;
                    }
                }

                if (Integer.parseInt(record[2]) == 1982) {
                    if (Integer.parseInt(record[1]) == 9 && Integer.parseInt(record[0]) >= 21 && Integer.parseInt(record[0]) <= 30) {
                        birthsFemaleSpring++;
                    } else if (Integer.parseInt(record[1]) > 9 && Integer.parseInt(record[1]) < 12) {
                        birthsFemaleSpring++;
                    } else if (Integer.parseInt(record[1]) == 12 && Integer.parseInt(record[0]) >= 1 && Integer.parseInt(record[0]) <= 21) {
                        birthsFemaleSpring++;
                    }
                }
                anio = Integer.parseInt(record[2]) * 10000 + Integer.parseInt(record[1]) * 100 + Integer.parseInt(record[0]);
                if (i == 0) {
                    anioMinimum = anio;
                    sex = record[3];
                    i++;
                }
                if (anio < anioMinimum) {
                    sex = record[3];
                    anioMinimum = anio;
                }
            }
            finalTotal(birthsOnOctober, birthsBeforeNineJuly, birthsFemaleSpring, anioMinimum, sex);
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

    private static void finalTotal(int birthsOnOctober, int birthsBeforeNineJuly, int birthsFemaleSpring, int anioMinimum, String sex) {
        System.out.println("AMOUNT OF BIRTHS ON OCTOBER : " + birthsOnOctober);
        System.out.println("AMOUNT OF BIRTHS BEFORE 9 JULY : " + birthsBeforeNineJuly);
        System.out.println("AMOUNT OF BIRTHS ON SPRING : " + birthsFemaleSpring);
        System.out.println("OLDEST PERSON'S SEX : " + sex + " " + anioMinimum);
    }
}
