package org.ar.miguel.FILES.E37;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Desarrollar un programa que solicitando un código de
 * materia permita seleccionar todos los registros
 * de alumnos que se anotaron para rendirla y los grabe
 * en otro archivo
 */
public class E38 {

    private static String FILE_INPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E38\\DIA.txt";
    private static String FILE_OUTPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E38\\ANTERIOR_DIA.txt";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String readRecord = null;
        String[] record = new String[0];
        int i = 0;
        try {
            FileWriter fileWriter = new FileWriter(FILE_OUTPUT, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //Put the exact location of the file Datos.csv
            FileReader fileReader = new FileReader(FILE_INPUT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((readRecord = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    bufferedWriter.write("\n" + readRecord);
                    i++;
                } else {
                    bufferedWriter.write("\n" + readRecord);
                }
            }

            bufferedReader.close();
            fileReader.close();

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
