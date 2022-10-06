package org.ar.miguel.FILES.MATING.E43;

import sun.util.resources.cldr.en.CurrencyNames_en_NA;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Se tiene un archivo maestro de cuentas de un Banco y otro con las novedades de depósitos de dichas cuentas,
 * ordenados en forma ascendente por Nº de cuenta. Se desea obtener un listado como el que se muestra en
 * salida, siguiendo las especificaciones del proceso.
 * ENTRADA:
 * Archivo maestro (1 registro por cuenta – ordenado secuencial ascendente por nrocuenta)
 * NROCUENTA NOMBRECLTE SALDO
 * Archivo de novedades: (1, varios o ningún registro por cuenta)
 * NROCUENTA IMPORTE
 * Deberá aparear estos archivos a efectos de:
 * 1. Actualizar el saldo del maestro para lo cual deberá sumar los importes de la novedad.
 * 2. Detectar la cuenta con menor saldo.
 * 3. Realizar el siguiente informe, colocando un “*” en observaciones, para las cuentas sin
 */
public class E43 {
    private static final String FILE_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E43\\MASTER.txt";
    private static final String FILE_NEWS = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E43\\NEWS.txt";
    private static final String FILE_OUTPUT_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E43\\MASTER_UPDATE.txt";

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("###,###,##0.00");
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
        String output = "";

        int cuentaAnt = 0;
        double saldoActual = 0d;
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


            System.out.println("NRO.CUENTA" + "  " + "NOMBRE" + "  " + "SALDO");
            while (recordMaster != null && recordNews != null) {
                master = recordMaster.split(";");
                news = recordNews.split(";");
                if (Integer.parseInt(master[0]) == Integer.parseInt(news[0])) {

                    saldoActual = 0d;
                    while (Integer.parseInt(master[0]) == Integer.parseInt(news[0]) && recordNews != null) {
                        saldoActual = saldoActual + Double.parseDouble(news[1]);
                        recordNews = brNews.readLine();
                        if (recordNews == null) {
                            news[0] = Integer.toString(Integer.MAX_VALUE);
                        } else {
                            news = recordNews.split(";");
                        }
                    }

                    output = "";
                    saldoActual = saldoActual + Double.parseDouble(master[2]);
                    output = master[0] + ";" + master[1] + ";" + saldoActual + "\n";
                    System.out.println("     " + master[0] + "     " + master[1] + "  " + df.format(saldoActual));
                    bwMaster.write(output);
                    recordMaster = brMaster.readLine();

                } else if (Integer.parseInt(master[0]) > Integer.parseInt(news[0])) {
                    cuentaAnt = Integer.parseInt(news[0]);
                    while (cuentaAnt == Integer.parseInt(news[0]) && recordNews != null) {
                        recordNews = brNews.readLine();
                        if (recordNews != null) {
                            news = recordNews.split(";");
                        }
                    }

                    recordNews = brNews.readLine();
                } else {
                    output = "";
                    output = master[0] + ";" + master[1] + ";" + Double.parseDouble(master[2]) + "\n";
                    bwMaster.write(output);
                    System.out.println("     " + master[0] + "     " + master[1] + "  " + df.format(Double.parseDouble(master[2])) + "  " + "*");
                    recordMaster = brMaster.readLine();
                }
            }
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

        cuentaMenorSaldo(FILE_OUTPUT_MASTER, df);
    }

    static void cuentaMenorSaldo(String masterFile, DecimalFormat df) {
        FileReader frMaster = null;
        BufferedReader brMaster = null;
        String master = "";
        String[] masterRecord = new String[0];
        int i = 0;
        double saldoMenor = 0;
        int cuentaMenor = 0;
        try {
            frMaster = new FileReader(masterFile);
            brMaster = new BufferedReader(frMaster);
            while ((master = brMaster.readLine()) != null) {
                masterRecord = master.split(";");
                if (i == 0) {
                    saldoMenor = Double.parseDouble(masterRecord[2]);
                    cuentaMenor = Integer.parseInt(masterRecord[0]);
                    i++;
                }

                if (saldoMenor > Double.parseDouble(masterRecord[2])) {
                    saldoMenor = Double.parseDouble(masterRecord[2]);
                    cuentaMenor = Integer.parseInt(masterRecord[0]);
                }
            }
            System.out.println("CUENTA  : " + cuentaMenor);
            System.out.println("SALDO MENOR : " + df.format(saldoMenor));
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

