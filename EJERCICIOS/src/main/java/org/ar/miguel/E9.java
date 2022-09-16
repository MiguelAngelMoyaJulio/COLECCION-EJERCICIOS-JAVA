package org.ar.miguel;

import java.util.Scanner;

/**
 * Dados n valores numéricos, informar el mayor,
 * el menor y en que posición del conjunto fueron
 * ingresados cada uno de ellos.
 */
public class E9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int maxPos=0, negPos=0;
        int n,num , max, min=999999999;
        max = 0;
        System.out.println("enter the amount of numbers you want to enter");
        n = Integer.parseInt(s.nextLine());
        for(int i=0;i<n;i++){
            num = Integer.parseInt(s.nextLine());
            if (num>max) {
                max = num;
                maxPos=i;
            }
            if(num<min){
                min = num;
                negPos=i;
            }
        }
        System.out.println("Max "+max+" "+" position : "+(maxPos+1));
        System.out.println("Min "+min+" "+" position : "+(negPos+1));
    }
}
