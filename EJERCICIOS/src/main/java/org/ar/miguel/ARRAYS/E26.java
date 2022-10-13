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
        int n = 0, m = 0, num = 0, lenD = 0;
        System.out.println("enter the size of the array A");
        n = Integer.parseInt(s.nextLine());
        System.out.println("enter the size of the array B");
        m = Integer.parseInt(s.nextLine());
        if (n < 25 && m < 10) {
            a = new int[n];
            b = new int[m];
            c = new int[n + m];
            loadArrays(a, b, s, num);
            lenD = arrayC(a, b, c, n);
            d = new int[c.length - lenD];
            arrayD(c, d);
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

    private static void loadArrays(int[] a, int[] b, Scanner s, int num) {
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
    }

    private static int arrayC(int[] a, int[] b, int[] c, int n) {
        int zeros = 0;
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
        return zeros;
    }
    private static void arrayD(int[] c, int[] d) {
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                d[j] = c[i];
                j++;
            }
        }
    }
}
