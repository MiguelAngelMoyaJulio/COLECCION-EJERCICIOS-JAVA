package org.ar.miguel.FILES.CONTROL_CUT.E34;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Se tiene la siguiente información por cada una de las materias que cursa cada estudiante:
 * - Código del estudiante.
 * - Código de la materia.
 * - Nota definitiva.
 * No se conoce el número de estudiantes ni el número de materias cursadas por cada estudiante.
 * Elaborar un algoritmo que muestre:
 * - Código del estudiante.
 * - Número de materias cursadas.
 * - Nota mayor y en qué materia la obtuvo
 */
public class E34 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String readRecord = null;
        String[] record = new String[0];
        String estAnt = "";
        double totalTar = 0;
        double totalPagoMinimo = 0;
        int cantMaterias = 0;
        double notaMax = 0;
        String notaMateriaMax = "";
        int i = 0;
        try {
            //Put the exact location of the file Datos.csv
            FileReader fileReader = new FileReader("D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\CONTROL_CUT\\E34\\LOTE.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            readRecord = bufferedReader.readLine();
            while (readRecord != null) {
                record = readRecord.split(";");
                totalTar = 0;
                estAnt = record[0];
                cantMaterias = 0;
                System.out.println("LEGAJO : " + estAnt);
                System.out.println("COD.MATERIA" + "    " + "NOTA");
                i = 0;
                while (estAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                    cantMaterias++;
                    if (i == 0) {
                        notaMax = Double.parseDouble(record[2]);
                        notaMateriaMax = record[1];
                        i++;
                    }
                    if (Double.parseDouble(record[2]) > notaMax) {
                        notaMax = Double.parseDouble(record[2]);
                        notaMateriaMax = record[1];
                    }
                    System.out.println("    "+record[1] + "         " + record[2]);
                    readRecord = bufferedReader.readLine();
                    if (readRecord != null) {
                        record = readRecord.split(";");
                    }
                }
                System.out.println("MATERIAS CURSADAS : " + (cantMaterias));
                System.out.println("NOTA MAXIMA : " + notaMax + " MATERIA : " + notaMateriaMax);
                System.out.println("");
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
