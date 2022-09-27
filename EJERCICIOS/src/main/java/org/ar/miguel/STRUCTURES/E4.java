package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Se ingresa un valor numérico entero n,
 * se pide desarrollar un algoritmo que muestre por consola
 * los primeros n números naturales.
 */
public class E4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("program show the n first natural numbers");
        System.out.println("enter the number");
        n = Integer.parseInt(s.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("number " + i);
        }
    }
}
