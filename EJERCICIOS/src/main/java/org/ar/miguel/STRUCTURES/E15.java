package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Dado un valor entero positivo n que se ingresa por teclado,
 * desarrollar un programa que muestre por
 * consola los primeros n números primos.
 */
public class E15 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, pe=0,i=1;
        System.out.println("enter a number ");
        n = Integer.parseInt(s.nextLine());
        while(pe<n){
            if(isPrimeNumber(i)){
                System.out.println(i);
                pe++;
            }
            i++;
        }
    }

    static boolean isPrimeNumber(int num) {
        boolean prime = false;
        int c = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                c++;
            }
        }
        if (c == 2) {
            prime = true;
        }
        return prime;
    }
}
