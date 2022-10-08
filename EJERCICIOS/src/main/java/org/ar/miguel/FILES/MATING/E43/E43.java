package org.ar.miguel.FILES.MATING.E43;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Se tiene un archivo maestro de cuentas de un Banco y otro con las novedades de depósitos de dichas cuentas,
 * ordenados en forma ascendente por Nº de cuenta. Se desea obtener un listado como el que se muestra en
 * salida, siguiendo las especificaciones del proceso.
2 * ENTRADA:
 * Archivo maestro (1 registro por cuenta – ordenado secuencial ascendente por nrocuenta)
 * NROCUENTA NOMBRECLTE SALDO
 * Archivo de novedades: (1, varios o ningún registro por cuenta)
 * NROCUENTA IMPORTE
 * Deberá aparear estos archivos a efectos de:
 * 1. Actualizar el saldo del maestro para lo cual deberá sumar los importes de la novedad.
 * 2. Detectar la cuenta con menor saldo.
 * 3. Realizar el siguiente informe, colocando un “*” en observaciones, para las cuentas sin
 * movimientos
 */
public class E43 {
    private static final String FILE_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E43\\MASTER.txt";
    private static final String FILE_NEWS = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E43\\NEWS.txt";
    private static final String FILE_OUTPUT_MASTER = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\MATING\\E43\\MASTER_UPDATE.txt";
    private static final String STATUS_YES = "YES";
    private static final String STATUS_NO = "NO";

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
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

        double balance = 0;
        String minAccount = "";
        double minBalance = 0;
        int accountAnt = 0;
        int i = 0;

        try {

            fwMaster = new FileWriter(FILE_OUTPUT_MASTER);
            bwMaster = new BufferedWriter(fwMaster);

            frMaster = new FileReader(FILE_MASTER);
            brMaster = new BufferedReader(frMaster);

            frNews = new FileReader(FILE_NEWS);
            brNews = new BufferedReader(frNews);

            recordMaster = brMaster.readLine();
            recordNews = brNews.readLine();
            System.out.println("NUM.ACCOUNT" + "     " + "CLIENT" + "     " + "BALANCE" + "     " + "OBSERVATIONS");
            while (recordMaster != null && recordNews != null) {
                master = recordMaster.split(";");
                news = recordNews.split(";");
                if (i == 0) {
                    minAccount = "";
                    minAccount = master[0];
                    minBalance = Double.parseDouble(master[2]);
                    i++;
                }
                if (Integer.parseInt(master[0]) == Integer.parseInt(news[0])) {

                    balance = Double.parseDouble(master[2]);
                    while (Integer.parseInt(master[0]) == Integer.parseInt(news[0])) {
                        balance = balance + Double.parseDouble(news[1]);
                        recordNews = brNews.readLine();
                        if (recordNews != null) {
                            news = recordNews.split(";");
                        } else {
                            news[0] = Integer.toString(Integer.MAX_VALUE);
                        }
                    }
                    if (balance < minBalance) {
                        minAccount = "";
                        minAccount = master[0];
                        minBalance = balance;
                    }
                    master[2] = Double.toString(balance);
                    writeMasterUpdate(master, bwMaster, STATUS_YES);
                    displayDataAccount(master, STATUS_YES, df);
                    recordMaster = brMaster.readLine();

                } else if (Integer.parseInt(master[0]) > Integer.parseInt(news[0])) {
                    accountAnt = Integer.parseInt(news[0]);
                    while (accountAnt == Integer.parseInt(news[0]) && recordNews != null) {
                        recordNews = brNews.readLine();
                        if (recordNews != null) {
                            news = recordNews.split(";");
                        }
                    }
                    recordNews = brNews.readLine();
                } else {
                    if (Double.parseDouble(master[2]) < minBalance) {
                        minAccount = "";
                        minAccount = master[0];
                        minBalance = Double.parseDouble(master[2]);
                    }

                    displayDataAccount(master, STATUS_NO, df);
                    writeMasterUpdate(master, bwMaster, STATUS_NO);
                    recordMaster = brMaster.readLine();
                }
            }
            System.out.println("MIN BALANCE : " + df.format(minBalance));
            System.out.println("ACCOUNT : " + minAccount);
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
        if (update.equalsIgnoreCase("yes")) {
            out = "";
            out = master[0] + ";" + master[1] + ";" + master[2] + "\n";
            bw.write(out);
        } else {
            out = "";
            out = master[0] + ";" + master[1] + ";" + master[2] + "\n";
            bw.write(out);
        }
    }

    static void displayDataAccount(String[] master, String update, DecimalFormat df) {
        if (update.equalsIgnoreCase("yes")) {
            System.out.println("    " + master[0] + "          " + master[1] + "     " + df.format(Double.parseDouble(master[2])));
        } else {
            System.out.println("    " + master[0] + "          " + master[1] + "     " + df.format(Double.parseDouble(master[2])) + "         " + "*");
        }
    }
}

