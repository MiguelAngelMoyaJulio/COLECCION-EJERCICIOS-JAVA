package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Dados n valores numéricos, informar el mayor,
 * el menor y en que posición del conjunto fueron
 * ingresados cada uno de ellos.
 */
public class E9 {
    private static Scanner s = new Scanner(System.in);
    private static int maxPos = 0, negPos = 0;
    private static int n, num, max = 0, min = 999999999;

    public static void main(String[] args) {
        System.out.println("enter the amount of numbers you want to enter");
        n = Integer.parseInt(s.nextLine());
        process(n,num,max,min,maxPos,negPos,s);
    }

    private static void process(int n, int num, int max, int min,int maxPos, int negPos, Scanner s) {
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(s.nextLine());
            if (num > max) {
                max = num;
                maxPos = i;
            }
            if (num < min) {
                min = num;
                negPos = i;
            }
        }
        System.out.println("Max " + max + " " + " position : " + (maxPos + 1));
        System.out.println("Min " + min + " " + " position : " + (negPos + 1));
    }
}
