package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar dos valores enteros M (< 10) y N (< 15).
 * A continuación ingresar un conjunto A de M
 * elementos y luego otro B de N elementos. Generar e imprimir:
 * a) Un conjunto C resultante de la anexión de A y B.
 * b) Un conjunto D resultante de la anexión de
 * los elementos distintos de cero de A y B.
 */
public class E26 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a;
        int[] b;
        int[] c;
        int[] d;
        int n = 0, m = 0, num = 0, j = 0, zeros = 0;
        System.out.println("enter the size of the array A");
        n = Integer.parseInt(s.nextLine());
        System.out.println("enter the size of the array B");
        m = Integer.parseInt(s.nextLine());
        if (n < 25 && m < 10) {
            a = new int[n];
            b = new int[m];
            c = new int[n + m];
            for (int i = 0; i < a.length; i++) {
                System.out.println("enter a number for a");
                num = Integer.parseInt(s.nextLine());
                a[i] = num;
            }
            for (int i = 0; i < b.length; i++) {
                System.out.println("enter a number for b");
                num = Integer.parseInt(s.nextLine());
                b[i] = num;
            }
            for (int i = 0; i < c.length; i++) {
                if (i < n) {
                    c[i] = a[i];
                } else {
                    c[i] = b[i - a.length];
                }
            }
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 0) {
                    zeros++;
                }
            }
            d = new int[c.length-zeros];
            for (int i = 0; i < c.length; i++) {
                if (c[i] != 0) {
                    d[j] = c[i];
                    j++;
                }
            }
            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i]);
            }
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i]);
            }
        } else {
            System.out.println("Try again");
        }

    }
}
