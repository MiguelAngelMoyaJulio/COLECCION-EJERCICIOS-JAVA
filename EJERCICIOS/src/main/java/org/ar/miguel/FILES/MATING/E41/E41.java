package org.ar.miguel.FILES.MATING.E41;

import java.io.*;
import java.util.Scanner;

/**
 * En una farmacia, se desea actualizar el stock de medicamentos con la llegada de un lote reciente de un
 * laboratorio determinado. Ambos archivos se encuentran ordenados en forma ascendente por Código de
 * Producto.
 */
public class E41 {
    private final static String FILE_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E41\\MASTER.txt";
    private final static String FILE_NEWS = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E41\\NEWS.txt";
    private final static String FILE_OUTPUT_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E41\\MASTER_UPDATE.txt";

    public static void main(String[] args) {
        FileWriter fwMaster = null;
        BufferedWriter bwMaster = null;

        FileReader frMaster = null;
        BufferedReader brMaster = null;

        FileReader frNews = null;
        BufferedReader brNews = null;

        String recordMaster = null, recordNews = null, output = "";
        String[] master = new String[0];
        String[] news = new String[0];


        try {

            fwMaster = new FileWriter(FILE_OUTPUT_MASTER);
            bwMaster = new BufferedWriter(fwMaster);

            frMaster = new FileReader(FILE_MASTER);
            brMaster = new BufferedReader(frMaster);

            frNews = new FileReader(FILE_NEWS);
            brNews = new BufferedReader(frNews);
            //Put the exact location of the file Datos.csv
            recordMaster = brMaster.readLine();
            recordNews = brNews.readLine();

            while (recordMaster != null && recordNews != null) {
                master = recordMaster.split(";");
                news = recordNews.split(";");
                if (Integer.parseInt(master[0]) == Integer.parseInt(news[0])) {
                    System.out.println(master[0] + " " + (Integer.parseInt(master[2]) + Integer.parseInt(news[2])));
                    output = "";
                    output = master[0] + ";" + master[1] + ";" + Integer.toString(Integer.parseInt(master[2]) + Integer.parseInt(news[2])) + "\n";
                    bwMaster.write(output);
                    recordMaster = brMaster.readLine();
                    recordNews = brNews.readLine();
                } else if (Integer.parseInt(master[0]) > Integer.parseInt(news[0])) {
                    output = "";
                    output = news[0] + ";" + news[1] + ";" + news[2] + "\n";
                    bwMaster.write(output);
                    recordNews = brNews.readLine();
                } else {
                    output = "";
                    output = master[0] + ";" + master[1] + ";" + master[2] + "\n";
                    bwMaster.write(output);
                    recordMaster = brMaster.readLine();
                }
            }

            closeMaster(master, recordMaster, brMaster, bwMaster);
            closeNews(news, recordNews, brNews, bwMaster);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                brMaster.close();
                frMaster.close();

                brNews.close();
                frNews.close();

                bwMaster.close();
                fwMaster.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeMaster(String[] master, String recordMaster, BufferedReader brMaster, BufferedWriter bwMaster) throws IOException {
        String output = "";
        while (recordMaster != null) {
            master = recordMaster.split(";");
            output = "";
            output = master[0] + ";" + master[1] + ";" + master[2] + "\n";
            bwMaster.write(output);
            recordMaster = brMaster.readLine();
        }
    }

    private static void closeNews(String[] news, String recordNews, BufferedReader brNews, BufferedWriter bwMaster) throws IOException {
        String output = "";
        while (recordNews != null) {
            news = recordNews.split(";");
            output = "";
            output = news[0] + ";" + news[1] + ";" + news[2] + "\n";
            bwMaster.write(output);
            recordNews = brNews.readLine();
        }
    }
}
