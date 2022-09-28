package org.ar.miguel.ARRAYS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Ingresar dos valores, M (< 30) y N (< 25) y a
 * continuación por filas todos los componentes de una
 * matriz MATRIZA de M filas y N columnas. Desarrollar un programa que:
 * a) Imprima la matriz MATRIZA por columnas.
 * b) Calcule e imprima el valor promedio de los componentes de la matriz.
 * c) Genere e imprima un vector VECSUMCOL donde cada componente sea la suma de la columna
 * homóloga.
 * d) Genere e imprima un vector VECMAXFIL donde cada componente sea el valor máximo de cada
 * fila.
 */
public class E35 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] ma;
        int fil = 0, col = 0;
        int num = 0;
        System.out.println("ENTER THE AMOUNT OF ROWS AND COLUMNS");
        fil = Integer.parseInt(s.nextLine());
        col = Integer.parseInt(s.nextLine());
        if (fil < 30 && col < 25) {
            ma = new int[fil][col];
            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.println("ENTER A NUMBER");
                    num = Integer.parseInt(s.nextLine());
                    ma[i][j] = num;
                }
            }
            showMatrix(ma, fil, col);
            averageMatrix(ma, fil, col);
            maxCol(ma, fil, col);
            maxFil(ma, fil, col);
        }
    }

    private static void showMatrix(int[][] ma, int fil, int col) {
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(ma[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    private static void averageMatrix(int[][] ma, int fil, int col) {
        int sum = 0;
        double average = 0;

        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                sum = sum + ma[i][j];
            }
        }
        average = sum / (fil * col);
        System.out.println("AVERAGE : " + average);
    }

    private static void maxCol(int[][] ma, int fil, int col) {
        int[] colN = new int[col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                colN[i] = colN[i] + ma[j][i];
            }
        }
        for (int i = 0; i < colN.length; i++) {
            System.out.println("Col " + (i + 1) + " : " + colN[i]);
        }
    }

    private static void maxFil(int[][] ma, int fil, int col) {
        int x;
        int max;
        for (int i = 0; i < fil; i++) {
            max = 0;
            x = 0;
            for (int j = 0; j < col; j++) {
                if (x == 0) {
                    max = ma[i][j];
                    x++;
                }
                if (max < ma[i][j]) {
                    max = ma[i][j];
                }
            }
            System.out.println("MAX FIL " + (i + 1) + " : " + max);
        }
    }
}
