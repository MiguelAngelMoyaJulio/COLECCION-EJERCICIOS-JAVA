package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 40).
 * A continuación ingresar un conjunto VALOR de N elementos.
 * Determinar e imprimir el valor máximo y
 * la posición del mismo dentro del conjunto. Si el máximo no es
 * único, imprimir todas las posiciones en
 * que se encuentra.
 */
public class E24 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arra;
        int n = 0, num = 0, max = 0;
        System.out.println("enter the size of the array");
        n = Integer.parseInt(s.nextLine());
        if (n < 40) {
            arra = new int[n];
            loadArray(arra, s, num);
            findMax(arra, max);
        } else {
            System.out.println("Try again");
        }
    }

    private static void loadArray(int[] arra, Scanner s, int num) {
        for (int i = 0; i < arra.length; i++) {
            System.out.println("enter a number");
            num = Integer.parseInt(s.nextLine());
            arra[i] = num;
        }
    }

    private static void findMax(int[] arra, int max) {
        max = arra[0];
        for (int i = 0; i < arra.length; i++) {
            if (arra[i] > max) {
                max = arra[i];
            }
        }
        for (int i = 0; i < arra.length; i++) {
            if (arra[i] == max) {
                System.out.println("MAXIMUM " + max);
                System.out.println("POSITION MAXIMUM " + (i + 1));
            }
        }
    }
}
