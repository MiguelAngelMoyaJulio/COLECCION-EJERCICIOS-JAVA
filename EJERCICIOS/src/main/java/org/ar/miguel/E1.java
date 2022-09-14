package org.ar.miguel;

import java.util.Scanner;

/**
 * Dados dos valores numéricos enteros a y b, calcular e informar la suma: a+b,
 * la diferencia: a-b, y el producto: a*b entre dichos valores.
 */
public class E1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b;
        System.out.println("enter two numbers");
        a = Integer.parseInt(s.nextLine());
        b = Integer.parseInt(s.nextLine());
        System.out.println("addition "+(a+b));
        System.out.println("substraction "+(a-b));
        System.out.println("multiplication "+(a*b));
    }
}
