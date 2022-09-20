package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor N (< 25). Generar un arreglo
 * de N componentes en el cual las mismas contengan los
 * primeros números naturales pares e imprimirlo.
 */
public class E19 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arra;
        int n = 0, i = 1, j = 0;
        System.out.println("enter a number");
        n = Integer.parseInt(s.nextLine());
        arra = new int[n];
        while (j < n) {
            if (i % 2 == 0) {
                arra[j] = i;
                j++;
            }
            i++;
        }
        for (int x = 0; x < arra.length; x++) {
            System.out.println(arra[x]);
        }
    }

}
