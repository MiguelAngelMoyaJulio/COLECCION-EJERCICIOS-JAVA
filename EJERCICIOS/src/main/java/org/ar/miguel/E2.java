package org.ar.miguel;

import java.util.Scanner;

/**
 * Dados dos valores numéricos enteros a y b
 * calcular e informar el cosiente a/b. Considere que b puede ser cero.
 * En ese caso mostrar el correspondiente mensaje de error.
 */
public class E2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b;
        System.out.println("enter two numbers");
        a = Integer.parseInt(s.nextLine());
        b = Integer.parseInt(s.nextLine());
        if (b != 0) {
            System.out.println("division " + (a / b));
        } else {
            System.out.println("b must not be zero");
        }
    }
}
