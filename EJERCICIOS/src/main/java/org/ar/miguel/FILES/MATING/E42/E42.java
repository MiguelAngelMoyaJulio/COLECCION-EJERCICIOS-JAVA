package org.ar.miguel.FILES.MATING.E41;

import java.io.*;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * Se tiene un archivo maestro de facturas de gas de una localidad del Gran Buenos Aires y otro con las novedades
 * de pagos del mes de dichas facturas, ordenados en forma ascendente por Nº de medidor. Se desea imprimir un
 * listado con el detalle de los deudores, y los siguientes totales de Control: cant total de deudores y monto total
 * adeudado.
 */
public class E42 {
    private static final String FILE_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E42\\MASTER.txt";
    private static final String FILE_NEWS = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E42\\NEWS.txt";
    private static final String FILE_OUTPUT_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E42\\MASTER_UPDATE.txt";

    public static void main(String[] args) {
        FileWriter fwMaster = null;
        BufferedWriter bwMaster = null;

        FileReader frMaster = null;
        BufferedReader brMaster = null;

        FileReader frNews = null;
        BufferedReader brNews = null;
        String recordMaster = null,recordNews = null,output = "";
        String[] master = new String[0];
        String[] news = new String[0];

        int nroMedidorAnt = 0, cantDeudores = 0;
        double deudaTotal = 0,montoTotalDeuda = 0;

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

            System.out.println("");
            while (recordMaster != null && recordNews != null) {
                master = recordMaster.split(";");
                news = recordNews.split(";");
                if (Integer.parseInt(master[0]) == Integer.parseInt(news[0])) {
                    deudaTotal = 0;
                    while (Integer.parseInt(master[0]) == Integer.parseInt(news[0]) && recordNews != null) {
                        deudaTotal = deudaTotal + Double.parseDouble(news[1]);
                        recordNews = brNews.readLine();
                        if (recordNews == null) {
                            news[0] = Integer.toString(Integer.MAX_VALUE);
                        } else {
                            news = recordNews.split(";");
                        }
                    }
                    String saldoActual = Double.toString(Double.parseDouble(master[2]) - deudaTotal);
                    if ((Double.parseDouble(master[2]) - deudaTotal) > 0d) {
                        montoTotalDeuda = montoTotalDeuda + (Double.parseDouble(master[2]) - deudaTotal);
                        output = "";
                        output = master[0] + ";" + master[1] + ";" + saldoActual + ";" + "\n";
                        bwMaster.write(output);
                        cantDeudores++;
                    } else {
                        output = "";
                        output = master[0] + ";" + master[1] + ";" + saldoActual + ";" + "\n";
                        bwMaster.write(output);
                    }
                    recordMaster = brMaster.readLine();
                } else if (Integer.parseInt(master[0]) > Integer.parseInt(news[0])) {
                    nroMedidorAnt = Integer.parseInt(news[0]);
                    while (nroMedidorAnt == Integer.parseInt(news[0]) && recordNews != null) {
                        recordNews = brNews.readLine();
                        if (recordNews != null) {
                            news = recordNews.split(";");
                        }
                    }
                    recordNews = brNews.readLine();
                } else {
                    recordMaster = brMaster.readLine();
                    if (Double.parseDouble(master[2]) > 0) {
                        montoTotalDeuda = montoTotalDeuda + (Double.parseDouble(master[2]));
                        output = "";
                        output = master[0] + ";" + master[1] + ";" + master[2] + ";" + "\n";
                        bwMaster.write(output);
                        cantDeudores++;
                    }
                }
            }
            System.out.println("CANTIDAD DE DEUDORES : " + cantDeudores);
            System.out.println("MONTO TOTAL DEUDA : " + montoTotalDeuda);
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

        listarDeudores(FILE_OUTPUT_MASTER);
    }

    static void listarDeudores(String masterFile) {
        FileReader frMaster = null;
        BufferedReader brMaster = null;
        String master = "";
        String[] masterRecord = new String[0];
        try {
            frMaster = new FileReader(masterFile);
            brMaster = new BufferedReader(frMaster);
            System.out.println("NRO.MEDIDOR" + "  " + "CLIENTE" + "  " + "DEUDA");
            while ((master = brMaster.readLine()) != null) {
                masterRecord = master.split(";");
                System.out.println("     "+masterRecord[0] + "        " + masterRecord[1] + "    " + masterRecord[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                frMaster.close();
                brMaster.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

