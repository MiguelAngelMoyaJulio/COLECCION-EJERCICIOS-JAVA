package org.ar.miguel.FILES.E39;

import java.io.*;
import java.util.Scanner;

/**
 * Desarrollar un programa que solicitando un código de
 * materia permita seleccionar todos los registros
 * de alumnos que se anotaron para rendirla y los grabe
 * en otro archivo
 */
public class E39 {

    private static String FILE_INPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E39\\LOTE.txt";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String readRecord = null;
        String[] record = new String[0];
        String res = "";
        String out = "";
        int i = 0;
        System.out.println("ENTER A NEW SUBSCRIPTION? S/N");
        res = s.nextLine();
        try {
            FileWriter fileWriter = new FileWriter(FILE_INPUT, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //Put the exact location of the file Datos.csv
            while (res.equalsIgnoreCase("s")) {

                System.out.println("ENTER A ID'S STUDENT");
                String leg = s.nextLine();

                System.out.println("ENTER A SUBJECT'S CODE");
                String cod = s.nextLine();

                System.out.println("ENTER THE DAY, MONTH AND YEAR - 2 DIGITS FOR ALL");
                String day = s.nextLine();
                String month = s.nextLine();
                String year = s.nextLine();

                System.out.println("ENTER STUDENT'S NAME");
                String name = s.nextLine();
                out = "";
                out = "\n" + leg + ";" + cod + ";" + day + ";" + month + ";" + year + ";" + name;
                bufferedWriter.write(out);
                System.out.println("ENTER A NEW SUBSCRIPTION? S/N");
                res = s.nextLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
