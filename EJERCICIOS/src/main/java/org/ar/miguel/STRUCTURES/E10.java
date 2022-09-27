package org.ar.miguel.STRUCTURES;

import java.util.Scanner;

/**
 * Dada una serie de caracteres que conforman una
 * oración, donde cada palabra está separada de la
 * siguiente por un carácter blanco y la oración
 * finaliza con un punto. Se pide informar:
 * •	Cantidad de veces que apareció cada vocal.
 * •	Cantidad de palabras que contiene la oración.
 * •	Cantidad de letras que posee la palabra más larga.
 */
public class E10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cantA = 0, cantE = 0, cantI = 0, cantO = 0, cantU = 0, cantWords = 0;
        int max = 0;
        String p = "";
        String[] palabras = new String[0];
        System.out.println("enter a sentence");
        p = s.nextLine();
        palabras = p.split(" ");
        for (int i = 0; i < p.length(); i++) {
            if (p.substring(i, i + 1).equalsIgnoreCase("a")) {
                cantA++;
            } else if (p.substring(i, i + 1).equalsIgnoreCase("e")) {
                cantE++;
            } else if (p.substring(i, i + 1).equalsIgnoreCase("i")) {
                cantI++;
            } else if (p.substring(i, i + 1).equalsIgnoreCase("o")) {
                cantO++;
            } else if (p.substring(i, i + 1).equalsIgnoreCase("u")) {
                cantU++;
            }

            if (p.substring(i, i + 1).equals(" ")) {
                cantWords++;
            }
        }
        for(int i=0;i<palabras.length;i++){
            if(i==0){
                max = palabras[0].length();
            }

            if(palabras[i].length() > max){
                max = palabras[i].length();
            }

        }

        System.out.println("amount of words " + (cantWords + 1));
        System.out.println("A : "+cantA);
        System.out.println("E : "+cantE);
        System.out.println("I : "+cantI);
        System.out.println("O : "+cantO);
        System.out.println("U : "+cantU);
        System.out.println("longest word : "+max);
    }
}
