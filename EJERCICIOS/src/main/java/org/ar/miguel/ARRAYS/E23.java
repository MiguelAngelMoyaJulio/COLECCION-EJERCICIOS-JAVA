package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 30).
 * A continuación ingresar un conjunto UNO y luego otro conjunto DOS,
 * ambos de N componentes.
 * Generar e imprimir otro conjunto TRES intercalando
 * los valores de posición impar de DOS y los valores
 * de posición par de UNO.
 * Diseñar un procedimiento que rellene un
 * arreglo en posiciones salteadas con las componentes de
 * otro y usarlo para cada conjunto.
 */
public class E23 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] uno;
        int[] dos;
        int[] tres;
        int n = 0, suma = 0, num = 0;
        System.out.println("enter the size of the array");
        n = Integer.parseInt(s.nextLine());
        if (n < 30) {
            uno = new int[n];
            dos = new int[n];
            tres = new int[2 * n];
            loadArrays(uno, dos, s, num);
            mixArrays(uno,dos,tres,n);
            for (int i : tres) {
                System.out.println(i);
            }
        } else {
            System.out.println("Try again");
        }
    }

    private static void loadArrays(int[] uno, int[] dos, Scanner s, int num) {
        for (int i = 0; i < uno.length; i++) {
            System.out.println("enter a number");
            num = Integer.parseInt(s.nextLine());
            uno[i] = num;
        }
        for (int i = 0; i < dos.length; i++) {
            System.out.println("enter a number");
            num = Integer.parseInt(s.nextLine());
            dos[i] = num;
        }
    }

    private static void mixArrays(int[] uno, int[] dos, int[] tres, int n) {
        int j = 0, k = 0;
        for (int i = 0; i < 2 * n; i++) {

            if (i % 2 == 0) {
                tres[i] = uno[j];
                j++;
            } else {
                tres[i] = dos[k];
                k++;
            }

        }
    }
}

