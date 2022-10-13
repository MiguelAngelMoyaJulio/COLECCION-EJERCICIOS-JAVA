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
public class E37 {

    private static String FILE_INPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E37\\LOTE.txt";
    private static String FILE_OUTPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E37\\SALIDA.txt";

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        //Put the exact location of the file Datos.csv
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        Scanner s = new Scanner(System.in);
        String readRecord = null, codSubject = "";
        String[] record = new String[0];
        System.out.println("enter subject's code ");
        codSubject = s.nextLine();

        try {
            fileWriter = new FileWriter(FILE_OUTPUT);
            bufferedWriter = new BufferedWriter(fileWriter);
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(FILE_INPUT);
            bufferedReader = new BufferedReader(fileReader);

            while ((readRecord = bufferedReader.readLine()) != null) {
                record = readRecord.split(";");
                if (record[1].equalsIgnoreCase(codSubject)) {
                    bufferedWriter.write(readRecord + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();

                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
