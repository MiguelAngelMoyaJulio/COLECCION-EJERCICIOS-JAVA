package org.ar.miguel.FILES.CONTROL_CUT.E30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Se cuenta con un archivo de Puntos WiFi públicos de la Ciudad de Buenos Aires, con el siguiente diseño de
 * registro: COMUNA, SITIO, APS, NOMBRE, DIRECCIÓN NORMALIZADA, LAT, LONG
 * Usando corte de control a partir de este archivo, deben generar un listado de puntos wifi agrupando por
 * comuna y luego por sitio (Biblioteca, espacio público, etc).
 */
public class E31 {
    private static final String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\CONTROL_CUT\\E31\\LOTE.txt";

    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String[] record = new String[0];
        String neighborhoodAnt = "", siteAnt = "", readRecord = null;
        int totalWifiPerNeighborhood = 0, totalWifiPerSite = 0;
        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);
            readRecord = bufferedReader.readLine();
            while (readRecord != null) {
                record = readRecord.split(";");
                neighborhoodAnt = record[0];
                totalWifiPerNeighborhood = 0;
                System.out.println("PUNTO WIFI COMUNA : " + neighborhoodAnt);
                while (neighborhoodAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                    siteAnt = record[1];
                    totalWifiPerSite = 0;
                    while (siteAnt.equalsIgnoreCase(record[1]) && neighborhoodAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                        totalWifiPerSite++;
                        readRecord = bufferedReader.readLine();
                        if (readRecord != null) {
                            record = readRecord.split(";");
                        }
                    }
                    System.out.println(siteAnt + ":" + totalWifiPerSite);
                    totalWifiPerNeighborhood = totalWifiPerNeighborhood + totalWifiPerSite;
                }
                System.out.println("TOTAL PUNTOS WIFI COMUNA " + neighborhoodAnt + " : " + totalWifiPerNeighborhood);
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
