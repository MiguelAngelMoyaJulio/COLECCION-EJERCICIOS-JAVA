package org.ar.miguel.ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 30) y a continuación
 * un conjunto de N elementos. Si el último elemento
 * del conjunto tiene un valor menor que 10
 * imprimir los negativos y en caso contrario los demás.
 */
public class E20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arra;
        int n = 0, num = 0;
        System.out.println("enter the size of the array");
        n = Integer.parseInt(s.nextLine());
        if (n < 30) {
            arra = new int[n];
            for (int i = 0; i < arra.length; i++) {
                System.out.println("enter a number");
                num = Integer.parseInt(s.nextLine());
                arra[i] = num;
            }
            if (arra[arra.length - 1] < 10) {
                System.out.println("elements' array");
                for(int i:arra){
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Try again");
        }


    }

}
