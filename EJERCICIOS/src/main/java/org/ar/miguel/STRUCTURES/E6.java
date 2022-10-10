package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Se ingresa un valor numérico entero,
 * se pide calcular e informar su factorial.
 */
public class E6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, fac = 1;
        System.out.println("enter a number");
        a = Integer.parseInt(s.nextLine());
        result(a, fac);
    }

    private static void result(int a, int fac) {
        for (int i = 1; i <= a; i++) {
            fac = fac * i;
        }
        System.out.println("factorial of " + a + " is : " + fac);
    }
}
