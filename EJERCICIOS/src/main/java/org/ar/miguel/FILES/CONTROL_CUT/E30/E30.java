package org.ar.miguel.FILES.CONTROL_CUT.E30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * En las últimas elecciones, se desea conocer los totales para cada candidato por provincia.
 */
public class E30 {
    private static final String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\CONTROL_CUT\\E30\\LOTE.txt";
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        String readRecord = null, candidateAnt = "";
        String[] record = new String[0];

        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);
            readRecord = bufferedReader.readLine();

            while (readRecord != null) {
                record = readRecord.split(";");
                candidateAnt = record[0];
                System.out.println("CANDIDATE " + candidateAnt);
                System.out.println("PROVINCE " + "                           " + "TOTAL");
                while (candidateAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                    System.out.println(record[1] + "     " + record[2]);
                    readRecord = bufferedReader.readLine();
                    if (readRecord != null) {
                        record = readRecord.split(";");
                    }
                }
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
