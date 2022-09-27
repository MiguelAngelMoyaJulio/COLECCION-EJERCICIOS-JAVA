package org.ar.miguel.FILES.CONTROL_CUT.E33;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Diseñar el algoritmo de resumen de tarjeta de crédito que liste por fecha los consumos del mes indicando
 * fecha, detalle consumo e importe. Efectuar corte por número de tarjeta y por último indicar el saldo total a
 * pagar y el pago mínimo que es el 20% del saldo total.
 */
public class E33 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String readRecord = null;
        String[] record = new String[0];
        String tarAnt = "";
        double totalTar = 0;
        double totalPagoMinimo = 0;
        try {
            //Put the exact location of the file Datos.csv
            FileReader fileReader = new FileReader("D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\FILES\\CONTROL_CUT\\E33\\LOTE.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            readRecord = bufferedReader.readLine();
            while (readRecord != null) {
                record = readRecord.split(";");
                totalTar = 0;
                tarAnt = record[0];
                System.out.println("TARJETA : " + tarAnt);
                System.out.println("FECHA" + "                " + "CONSUMO"+"          "+"IMPORTE");
                while (tarAnt.equalsIgnoreCase(record[0]) && readRecord != null) {
                    System.out.println(record[1] +"         "+record[2]+ "        $" + df.format(Double.parseDouble(record[3])));
                    totalTar = totalTar + Double.parseDouble(record[3]);
                    readRecord = bufferedReader.readLine();
                    if (readRecord != null) {
                        record = readRecord.split(";");
                    }
                }
                System.out.println("TOTAL TARJETA " + tarAnt + " :     $" + df.format(totalTar));
                totalPagoMinimo = totalTar * 0.2;
                System.out.println("TOTAL PAGO MINIMO :                  $" + df.format(totalPagoMinimo));
                System.out.println("");
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
