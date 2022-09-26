package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 40).
 * Luego ingresar un conjunto A de N elementos reales (ingresan
 * ordenados por magnitud creciente).
 * Finalmente ingresar un valor pesquisa X. Desarrollar el programa
 * que determine e imprima:
 * a) Con cual elemento (posición) del conjunto coincide, o
 * b) Entre cuales dos elementos (posiciones) se encuentra, o
 * c) Si es menor que el primero o mayor que el último.
 */
public class E27 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double[] a;
        int n = 0;
        double num = 0, x = 0;

        boolean found = false;
        int pos = -1;
        System.out.println("enter the size of the array A");
        n = Integer.parseInt(s.nextLine());
        if (n < 40) {
            a = new double[n];
            for (int i = 0; i < a.length; i++) {
                System.out.println("enter a number for a");
                num = Double.parseDouble(s.nextLine());
                a[i] = num;
            }
            System.out.println("search a number");
            x = Double.parseDouble(s.nextLine());

            for (int i = 0; i < a.length; i++) {
                if (a[i] == x) {
                    pos = i;
                }
            }

            if (pos == -1) {
                System.out.println("the number wasn't found");
            } else {
                System.out.println(x + " was found in " + (pos+1));
            }

            if ((pos != 0 && pos != (a.length - 1)) && pos != -1) {
                System.out.println(x + " is between " + (pos + 2) + " and " + (pos));
            }

            if (x < a[0]) {
                System.out.println("it's lower than first element");
            }
            if (x > a[a.length - 1]) {
                System.out.println("it's greater than first element");
            }
        } else {
            System.out.println("Try again");
        }

    }
}
