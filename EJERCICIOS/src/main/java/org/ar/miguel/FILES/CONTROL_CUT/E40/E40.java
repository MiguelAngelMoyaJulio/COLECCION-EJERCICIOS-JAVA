package org.ar.miguel.FILES.CONTROL_CUT.E40;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Dado el archivo ordenado por fecha y para igual fecha por código de materia y
 * para igual materia por número de legajo.
 * Desarrollar el programa que imprima el listado de alumnos inscriptos en cada materia, según se
 */
public class E40 {

    private static String FILE_INPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E40\\LOTE.txt";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String readRecord = null;
        String[] record = new String[0];
        String dateAnt = "";
        String codSubAnt = "";

        try {
            FileReader fileReader = new FileReader(FILE_INPUT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Put the exact location of the file Datos.csv
            readRecord = bufferedReader.readLine();

            while (readRecord != null) {
                record = readRecord.split(";");
                dateAnt = record[2];
                while (dateAnt.equalsIgnoreCase(record[2]) && readRecord != null) {
                    String dateAntFixed = dateAnt.substring(0,4)+"/"+dateAnt.substring(4,6)+"/"+dateAnt.substring(6,8);
                    record = readRecord.split(";");
                    codSubAnt = record[1];
                    System.out.println("MATERIA : " + codSubAnt + "      " + "FECHA : " + dateAntFixed);
                    System.out.println("LEGAJO " + "  " + "NOMBRE " + "  " + "NOTA");
                    while (codSubAnt.equalsIgnoreCase(record[1]) && dateAnt.equalsIgnoreCase(record[2]) && readRecord != null) {
                        System.out.println(record[0] + "   " + record[3] + "   " + record[4]);
                        readRecord = bufferedReader.readLine();
                        if (readRecord != null) {
                            record = readRecord.split(";");
                        }
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
