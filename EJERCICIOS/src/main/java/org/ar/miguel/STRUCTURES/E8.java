package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Dado un valor numérico entero m,
 * determinar e imprimir un listado con los m
 * primeros múltiplos de 3 que no sean múltiples de 5.
 */
public class E8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 0, i = 1, me = 0;
        System.out.println("enter a number");
        n = Integer.parseInt(s.nextLine());
        process(n, me, i);
    }

    private static void process(int n, int me, int i) {
        while (me < n) {
            if (i % 3 == 0 && i % 5 != 0) {
                me++;
                System.out.println(i);
            }
            i++;
        }
    }
}
