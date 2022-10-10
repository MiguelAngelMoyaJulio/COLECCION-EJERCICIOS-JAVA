package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Desarrollar un programa tal que,
 * dado un valor entero positivo que se ingresa
 * por teclado indique si se trata de un número primo o no.
 */
public class E11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = 0, n = 0;
        System.out.println("enter a number ");
        n = Integer.parseInt(s.nextLine());
        isPrimeOrNot(n, c);
    }

    private static void isPrimeOrNot(int n, int c) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                c++;
            }
        }
        if (c == 2) {
            System.out.println("it's prime number");
        } else {
            System.out.println("it's not prime number");
        }
    }
}

