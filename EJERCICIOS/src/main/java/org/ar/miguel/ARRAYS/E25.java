package org.ar.miguel.ARRAYS;

import java.util.Scanner;

/**
 * Ingresar un valor entero N (< 40).
 * A continuación ingresar un conjunto A y luego otro conjunto B
 * ambos de N elementos.
 * Generar un arreglo C donde cada elemento se forme de la siguiente forma:
 * C[1] ← A[1]+B[N] C[2] ← A[2]+B[N-1] ... C[N] ← A[N]+B[1]
 */
public class E25 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a;
        int[] b;
        int[] c;
        int n = 0, num = 0;
        System.out.println("enter the size of the array");
        n = Integer.parseInt(s.nextLine());
        if (n < 40) {
            a = new int[n];
            b = new int[n];
            c = new int[n];
            for (int i = 0; i < a.length; i++) {
                System.out.println("enter a number for a and b");
                num = Integer.parseInt(s.nextLine());
                a[i] = num;
                num = Integer.parseInt(s.nextLine());
                b[i] = num;
            }
            for (int i = 0; i < c.length; i++) {
                c[i] = a[i] + b[(n-1)-i];
            }
            for(int i=0;i<c.length;i++){
                System.out.println(c[i]);
            }
        } else {
            System.out.println("Try again");
        }

    }
}
