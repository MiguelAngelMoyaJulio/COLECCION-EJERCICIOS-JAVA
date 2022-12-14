package org.ar.miguel.FILES.CONTROL_CUT.E32;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Una empresa tiene la siguiente información por cada uno de sus empleados: código empleado, código
 * sección, código de departamento, código de la sucursal y salario del empleado. Hacer un algoritmo que
 * muestre el código y el salario de cada empleado dando totales por sección, departamento y sucursal, y el
 * total del salario a pagar por parte de la empresa.
 */
public class E32 {
    private static final String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\CONTROL_CUT\\E32\\LOTE.txt";

    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String[] record = new String[0];
        String sucAnt = "", depAnt = "", secAnt = "", readRecord = null;
        double totalSuc = 0, totalDep = 0, totalSec = 0, totalEmp = 0;
        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);
            readRecord = bufferedReader.readLine();
            while (readRecord != null) {
                record = readRecord.split(";");
                totalSuc = 0;
                sucAnt = record[0];
                System.out.println("COD.EMPLEADO" + "           " + "SALARIO");
                while (sucAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                    totalDep = 0;
                    depAnt = record[1];
                    while (depAnt.equalsIgnoreCase(record[1]) && sucAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                        totalSec = 0;
                        secAnt = record[2];
                        while (secAnt.equalsIgnoreCase(record[2]) && depAnt.equalsIgnoreCase(record[1]) && sucAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                            System.out.println("      " + record[3] + "               $" + df.format(Double.parseDouble(record[4])));
                            totalSec = totalSec + Double.parseDouble(record[4]);
                            readRecord = bufferedReader.readLine();
                            if (readRecord != null) {
                                record = readRecord.split(";");
                            }
                        }
                        System.out.println("TOTAL SECCION " + secAnt + " :      $" + df.format(totalSec));
                        totalDep = totalDep + totalSec;
                    }
                    System.out.println("TOTAL DEPARTAMENTO " + depAnt + " : $" + df.format(totalDep));
                    totalSuc = totalSuc + totalDep;
                }
                System.out.println("TOTAL SUCURSAL " + sucAnt + " :     $" + df.format(totalSuc));
                totalEmp = totalEmp + totalSuc;
                System.out.println("");
            }
            System.out.println("TOTAL A PAGAR :        $" + df.format(totalEmp));
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
