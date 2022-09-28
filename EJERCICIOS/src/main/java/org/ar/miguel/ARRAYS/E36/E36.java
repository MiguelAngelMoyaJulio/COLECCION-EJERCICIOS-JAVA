package org.ar.miguel.ARRAYS.E36;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Se da un conjunto de 744 temperaturas que se tomaron en
 * una localidad diariamente hora por hora
 * durante los 31 días de un
 * mes (el conjunto esta ordenado por día y hora). Desarrollar un programa
 * que determine e imprima:
 * a) Armar la matriz TEMPEDIA en que
 * cada fila corresponda a un día y cada columna a una hora e
 * imprimirla por horas.
 * b) En que día y hora se produjo la temperatura máxima del mes.
 * c) En que día se produjo la menor temperatura media.
 * d) A que hora se produjo la mayor temperatura media.
 */
public class E36 {
    public static void main(String[] args) {
        String readRecord = null;
        double[][] ma = new double[31][24];
        try {
            //Put the exact location of the file Datos.csv
            FileReader fileReader = new FileReader("D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\ARRAYS\\E36\\LOTE.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 24; j++) {
                    readRecord = bufferedReader.readLine();
                    if (readRecord != null) {
                        ma[i][j] = Double.parseDouble(readRecord);
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
            tempMaxMonth(ma, 31, 24);
            tempMinAveDay(ma, 31, 24);
            tempMaxAveHour(ma, 31, 24);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tempMaxMonth(double[][] ma, int fil, int col) {
        int posDay = 0;
        int posHour = 0;
        int x = 0;
        double maxTemp = 0;
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                if (x == 0) {
                    maxTemp = ma[i][j];
                    posDay = i;
                    posHour = j;
                    x++;
                }
                if (maxTemp < ma[i][j]) {
                    maxTemp = ma[i][j];
                    posDay = i;
                    posHour = j;
                }
            }
        }
        System.out.println("TEMP MAXIMUM : " + maxTemp + " DAY : " + (posDay + 1) + " HOUR : " + (posHour + 1));
    }

    private static void tempMinAveDay(double[][] ma, int fil, int col) {
        double sumTemp = 0;
        int x = 0;
        double aveMinDay = 0;
        double aveMinDayRef = 0;
        int minDayAve = 0;

        for (int i = 0; i < fil; i++) {
            aveMinDayRef = 0;
            sumTemp = 0;
            for (int j = 0; j < col; j++) {
                sumTemp = sumTemp + ma[i][j];
            }
            aveMinDayRef = sumTemp / 24;
            if (x == 0) {
                aveMinDay = aveMinDayRef;
                minDayAve = i;
                x++;
            }
            if (aveMinDayRef < aveMinDay) {
                aveMinDay = aveMinDayRef;
                minDayAve = i;
            }
        }
        System.out.println("DAY OF LOWER AVERAGE TEMPERATURE : " + (minDayAve + 1));
    }

    private static void tempMaxAveHour(double[][] ma, int fil, int col) {
        double sumTemp = 0;
        int x = 0;
        double aveMaxHour = 0;
        double aveMaxHourRef = 0;
        int maxHourAve = 0;

        for (int i = 0; i < col; i++) {
            aveMaxHourRef = 0;
            sumTemp = 0;
            for (int j = 0; j < fil; j++) {
                sumTemp = sumTemp + ma[j][i];
            }
            aveMaxHourRef = sumTemp / 31;
            if (x == 0) {
                aveMaxHour = aveMaxHourRef;
                maxHourAve = i;
                x++;
            }
            if (aveMaxHourRef > aveMaxHour) {
                aveMaxHour = aveMaxHourRef;
                maxHourAve = i;
            }
        }
        System.out.println("HOUR OF HIGHER AVERAGE TEMPERATURE : " + (maxHourAve + 1));
    }

}
