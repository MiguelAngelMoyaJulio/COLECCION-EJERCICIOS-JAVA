package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Dados 50 números enteros,
 * informar el promedio de los mayores que 100 y la suma de los menores que –10.
 */
public class E7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sumPos = 0, sumNeg = 0;
        int cantPos = 0;
        int n = 0;
        System.out.println("enter a number");
        n = Integer.parseInt(s.nextLine());
        result(n, sumPos, sumNeg, cantPos);
    }

    private static void result(int n, int sumPos, int sumNeg, int cantPos) {
        for (int i = 1; i <= 50; i++) {
            if (n > 100) {
                sumPos += n;
                cantPos++;
            } else if (n < -10) {
                sumNeg += n;
            }
        }
        System.out.println("summation of negative numbers " + sumNeg);
        System.out.println("average of positive numbers " + sumPos / cantPos);
    }
}
