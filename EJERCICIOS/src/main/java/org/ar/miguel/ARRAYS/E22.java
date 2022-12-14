package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 25).
 * A continuación ingresar un conjunto VEC de N componentes.
 * Si la suma de las componentes resulta mayor
 * que cero imprimir las de índice par, sino las de índice impar.
 */
public class E22 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arra;
        int n = 0, suma = 0, num = 0;
        System.out.println("enter the size of the array");
        n = Integer.parseInt(s.nextLine());
        if (n < 25) {
            arra = new int[n];

            loadVector(arra, s, num);
            suma = sumVector(arra);
            showOddEven(suma,arra);
        } else {
            System.out.println("Try again");
        }

    }

    private static void showOddEven(int suma, int[] arra) {
        if (suma > 10) {
            System.out.println("even index");
            for (int i = 0; i < arra.length; i++) {
                if (i % 2 == 0) {
                    System.out.println(arra[i]);
                }
            }
        } else {
            System.out.println("odd index");
            for (int i = 0; i < arra.length; i++) {
                if (i % 2 != 0) {
                    System.out.println(arra[i]);
                }
            }
        }
    }

    private static int sumVector(int[] arra) {
        int suma = 0;
        for (int i = 0; i < arra.length; i++) {
            suma = suma + arra[i];
        }
        return suma;
    }

    private static void loadVector(int[] arra, Scanner s, int num) {
        for (int i = 0; i < arra.length; i++) {
            System.out.println("enter a number");
            num = Integer.parseInt(s.nextLine());
            arra[i] = num;
        }
    }

}
