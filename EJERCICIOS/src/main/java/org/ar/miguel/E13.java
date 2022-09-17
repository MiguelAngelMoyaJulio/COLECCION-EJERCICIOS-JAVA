package org.ar.miguel;

import java.util.Scanner;

/**
 * Desarrollar un programa tal que, dado un valor entero positivo
 * que se ingresa por teclado y que indica
 * la posición de un término dentro de la
 * sucesión de Fibonacci, muestre por
 * consola el valor del término ubicado en dicha posición.
 * Nota: la sucesión de Fibonacci es una serie numérica
 * cuyos primeros dos términos son 1 y los
 * siguientes términos se calculan como la suma de los dos anteriores.
 * Los primeros términos de la serie son los siguientes:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ..., ti, ti+1, ti+ti+1, ...
 */
public class E13 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int pos, currentNumber = 0, nextNumber = 1, aux = 0;
        int numberShow = 0, i;
        i = 1;
        System.out.println("enter a number ");
        pos = Integer.parseInt(s.nextLine());
        while (i <= pos) {
            numberShow = currentNumber;
            i++;
            aux = currentNumber + nextNumber;
            currentNumber = nextNumber;
            nextNumber = aux;
        }
        System.out.println("number in position "+pos+" : "+numberShow);
    }
}
