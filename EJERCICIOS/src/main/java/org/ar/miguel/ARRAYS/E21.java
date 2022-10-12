package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 20).
 * A continuación ingresar un conjunto VEC de N componentes. A
 * partir de este conjunto generar otro
 * FACT en el que cada elemento sea el factorial del elemento
 * homólogo de VEC.
 * Finalmente imprimir ambos vectores a razón de un valor de cada uno por renglón
 */
public class E21 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arra;
        int[] arraFact;
        int n = 0, num = 0;
        System.out.println("enter the size of the array");
        n = Integer.parseInt(s.nextLine());
        if (n < 20) {
            arra = new int[n];
            arraFact = new int[n];
            loadVector(arra, s, num);
            showVectorFactorial(arra, arraFact);
        } else {
            System.out.println("Try again");
        }

    }

    private static void loadVector(int[] arra, Scanner s, int num) {
        for (int i = 0; i < arra.length; i++) {
            System.out.println("enter a number");
            num = Integer.parseInt(s.nextLine());
            arra[i] = num;
        }
    }

    private static void showVectorFactorial(int[] arra, int[] arraFact) {
        for (int i = 0; i < arra.length; i++) {
            arraFact[i] = factorial(arra[i]);
        }
        for (int i = 0; i < arra.length; i++) {
            System.out.println(arraFact[i]);
        }
    }

    private static int factorial(int num) {
        int fac = 1;
        for (int i = 1; i <= num; i++) {
            fac = fac * i;
        }
        return fac;
    }


}
