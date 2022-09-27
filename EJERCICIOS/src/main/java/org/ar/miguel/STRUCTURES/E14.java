package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Desarrollar un programa que muestre por pantalla los primeros n términos de
 * la serie numérica de Fibonacci, donde n es un valor que se ingresa por consola.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ..., ti, ti+1, ti+ti+1, ...
 */
public class E14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, currentNumber = 0, nextNumber = 1, aux = 0;
        System.out.println("enter a number ");
        n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(currentNumber);
            aux = currentNumber + nextNumber;
            currentNumber = nextNumber;
            nextNumber = aux;
        }
    }
}
