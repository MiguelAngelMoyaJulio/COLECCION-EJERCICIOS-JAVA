package org.ar.miguel;

import java.util.Scanner;

/**
 * Dados dos valores numéricos enteros,
 * calcular e informar su producto mediante sumas sucesivas.
 */
public class E5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b, suma = 0;
        System.out.println("enter two numbers");
        a = Integer.parseInt(s.nextLine());
        b = Integer.parseInt(s.nextLine());
        for (int i = 1; i <= b; i++) {
            suma = suma + a;
        }
        System.out.println("multiplication a and b : " + suma);
    }
}
