package org.ar.miguel.E16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Se dispone de un conjunto de valores enteros positivos que finaliza
 * con el ingreso de un número negativo.
 * El conjunto está dividido en subconjuntos mediante valores 0 (cero).
 * Se pide Desarrollar un programa que determine e informe:
 * •	Por cada subconjunto, el promedio de valores que lo componen.
 * •	El total de subconjuntos procesados.
 * •	El valor máximo del conjunto, indicando en qué
 * subconjunto se encontró y su posición relativa dentro del mismo.
 * •	El valor mínimo de cada subconjunto.
 * Nota: el lote puede estar vacío (el primer valor ingresado será negativo),
 * o bien puede contener uno, varios o todos los sublotes vacíos (ceros consecutivos).
 */
public class E16 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");
        Scanner s = new Scanner(System.in);
        int partialSum = 0, partialInc = 0, n = 0;
        int cantSubLotes = 0;
        int maximum = 0, posMax = 0, i = 0, j = 0;
        int minimum = 0;
        int canReg = 0;
        int cantZeros = 0;
        double average = 0d;
        String cadenaLectura = null;
        try {
            //Put the exact location of the file Datos.csv
            FileReader fileReader = new FileReader("D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\E16\\LOTE.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((cadenaLectura = bufferedReader.readLine()) != null) {
                canReg++;
                n = Integer.parseInt(cadenaLectura);
                if (n == -1) {
                    break;
                }
                if (i == 0) {
                    maximum = n;
                    i = 1;
                }
                minimum = n;
                while (n > 0) {
                    j++;
                    if (n > maximum) {
                        maximum = n;
                        posMax = j;
                    }
                    if (n < minimum) {
                        minimum = n;
                    }
                    partialSum = partialSum + n;
                    partialInc++;
                    cadenaLectura = bufferedReader.readLine();
                    n = Integer.parseInt(cadenaLectura);
                    canReg++;
                }

                try {
                    if (n == 0) {
                        cantZeros++;
                        cantSubLotes++;
                        if (partialInc == 0) {
                            throw new Exception("can't divide by zero");
                        } else {
                            average = partialSum / partialInc;
                            System.out.print("Average " + df.format(average) + " ");
                            System.out.println("Minimum's sublot : " + minimum);
                        }
                        partialSum = 0;
                        partialInc = 0;
                        j = 0;
                        minimum = 0;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            bufferedReader.close();
            fileReader.close();
            if (cantZeros == (canReg - 1) && canReg > 1) {
                System.out.println("Sublots are empty");
            } else if (canReg == 1) {
                System.out.println("Lot is empty");
            } else {
                if (partialInc != 0) {
                    cantSubLotes++;
                    average = partialSum / partialInc;
                }
                System.out.print("Average " + df.format(average) + " ");
                System.out.println("Minimum's sublot : " + minimum);
                System.out.println("Amount of sublotes : " + (cantSubLotes));
                System.out.println("Maximum value : " + maximum + " position : " + posMax);
                System.out.println("Read records : " + canReg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
