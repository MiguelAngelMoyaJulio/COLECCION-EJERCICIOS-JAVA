package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Dado un triángulo representado por sus lados lado1, lado2 y lado3,
 * determinar e indicar según corresponda:
 * “equilátero”, “isósceles” o “escálenos”.
 */
public class E3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l1, l2, l3;
        System.out.println("enter the three sides of a triangle");
        l1 = Integer.parseInt(s.nextLine());
        l2 = Integer.parseInt(s.nextLine());
        l3 = Integer.parseInt(s.nextLine());
        if (l1 == l2 && l3 == l2) {
            System.out.println("equilateral");
        } else if (l1 == l2 || l3 == l2 || l3 == l1) {
            System.out.println("isosceles");
        } else {
            System.out.println("scalene");
        }
    }
}
