package org.ar.miguel.FILES.MATING.E44;

import java.io.*;
import java.text.DecimalFormat;

/**
 * En una compañía aérea , se desea actualizar el cupo de asientos libres del vuelo AR1627 a Ushuaia del
 * Boeing 767-400 con capacidad de 318 asientos para pasajeros. Se recibe la lista de boletos vendidos para un
 * día determinado . Ambos archivos están ordenados por nro de vuelo y nro de asiento en orden ascendente. Se
 * pide listar la disposición completa del avión asignando nro de asiento y nombre de cada pasajero y poniendo la
 * palabra “disponible” en los que no se hayan vendido aún. Al finalizar , mostrar los totales de control de Cantidad
 * de asientos totales, vendidos y disponibles.
 * Entrada
 * Archivo VUELO_AR1627 contiene el detalle del mapa de asientos del vuelo(ordenado secuencial
 * ascendente por NROVUELO, ASIENTO) - En el campo VENDIDO , el valor default es 0 y es 1 si el asiento
 * está asignado.
 * NROVUELO ASIENTO VENDIDO
 * Archivo VENTAS contiene el detalle de los boletos emitidos (ordenado secuencial ascendente por
 * NROVUELO, ASIENTO)
 * NROVUELO ASIENTO NROBOLETO NOMBRE PASAJERO
 */
public class E44 {
    private static final String FILE_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E44\\MASTER.txt";
    private static final String FILE_NEWS = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E44\\NEWS.txt";
    private static final String FILE_OUTPUT_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E44\\MASTER_UPDATE.txt";
    private static final String STATUS_NO = "NO";
    private static final String STATUS_YES = "YES";

    public static void main(String[] args) {
        FileWriter fwMaster = null;
        BufferedWriter bwMaster = null;

        FileReader frMaster = null;
        BufferedReader brMaster = null;

        FileReader frNews = null;
        BufferedReader brNews = null;

        String recordMaster = null;
        String recordNews = null;
        String[] master = new String[0];
        String[] news = new String[0];
        String codeCombineMaster = "";
        String codeCombineNews = "";

        int totalSeats = 0;
        int notAvaliableSeats = 0;
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


            System.out.println("SEAT" + "  " + "PASSENGER'S NAME");
            while (recordMaster != null && recordNews != null) {
                master = recordMaster.split(";");
                news = recordNews.split(";");

                codeCombineMaster = "";
                codeCombineMaster = master[0] + master[1];

                codeCombineNews = "";
                codeCombineNews = news[0] + news[1];

                if (codeCombineMaster.compareTo(codeCombineNews) == 0) {
                    totalSeats++;
                    writeMasterUpdate(master, bwMaster, STATUS_YES);
                    displayDataName(master, news, STATUS_NO);
                    notAvaliableSeats++;
                    recordMaster = brMaster.readLine();
                    recordNews = brNews.readLine();

                } else if (codeCombineMaster.compareTo(codeCombineNews) >= 1) {
                    recordNews = brNews.readLine();
                } else {
                    totalSeats++;
                    writeMasterUpdate(master, bwMaster, STATUS_NO);
                    displayDataName(master, news, STATUS_YES);
                    recordMaster = brMaster.readLine();
                }
            }

            while (recordMaster != null) {
                recordMaster = brMaster.readLine();
            }

            while (recordNews != null) {
                recordNews = brNews.readLine();
            }
            System.out.println("TOTAL SEATS : " + totalSeats);
            System.out.println("AVALIABLE SEATS : " + (totalSeats - notAvaliableSeats));
            System.out.println("OPCCUPIED SEATS : " + notAvaliableSeats);
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

    static void writeMasterUpdate(String[] master, BufferedWriter bw, String update) throws IOException {
        String out = "";
        if (update.equals("yes")) {
            out = "";
            out = master[0] + ";" + master[1] + ";" + "1" + "\n";
            bw.write(out);
        } else {
            out = "";
            out = master[0] + ";" + master[1] + ";" + master[2] + "\n";
            bw.write(out);
        }
    }

    static void displayDataName(String[] master, String[] news, String avaliable) {
        if (avaliable.equalsIgnoreCase("yes")) {
            System.out.println(master[0] + master[1] + "     " + "DISPONIBLE");
        } else {
            System.out.println(master[0] + master[1] + "     " + news[3]);
        }
    }
}

