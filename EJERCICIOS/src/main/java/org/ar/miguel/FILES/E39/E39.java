package org.ar.miguel.FILES.E39;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Modificar para que permita agregar mas inscripciones de alumnos a los
 * exámenes de mayo. Para control sólo imprima los agregados.
 */
public class E39 {

    private static String FILE_INPUT = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\E39\\LOTE.txt";

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        List<String> records = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        String[] record = new String[0];
        String res = "", out = "", outList = "", readRecord = null;

        int i = 0;
        System.out.println("ENTER A NEW SUBSCRIPTION? S/N");
        res = s.nextLine();
        try {
            fileWriter = new FileWriter(FILE_INPUT, true);
            bufferedWriter = new BufferedWriter(fileWriter);
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
                outList = "";
                out = "\n" + leg + ";" + cod + ";" + day + ";" + month + ";" + year + ";" + name;
                outList = leg + ";" + cod + ";" + day + ";" + month + ";" + year + ";" + name;
                records.add(outList);
                bufferedWriter.write(out);
                System.out.println("ENTER A NEW SUBSCRIPTION? S/N");
                res = s.nextLine();
            }
            System.out.println("RECORDS ADDED : " + records.size());
            records.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
