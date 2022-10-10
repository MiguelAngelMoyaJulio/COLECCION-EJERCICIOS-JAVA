package org.ar.miguel.FILES.E17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MulticastSocket;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Desarrollar una función que reciba un número natural de
 * 4 dígitos en formato de hhmm que corresponde a un tiempo determinado
 * en horas y minutos, y retorne ese tiempo en minutos.
 * El prototipo debe ser el siguiente:
 * long toMin(long t);
 * Desarrollar una función void que reciba el costo (expresado en pesos)
 * de un abono telefónico, la cantidad de minutos libres que incluye el
 * abono, el cargo (expresado en pesos) por minuto excedente y
 * la cantidad de minutos utilizados por un abonado y retorne la
 * cantidad de minutos excedidos y el monto (también expresado en pesos)
 * que se debe abonar (costo del abono
 * más minutos excedidos por el costo de minutos excedidos) más el
 * 21% del valor del IVA.
 * El prototipo y posterior desarrollo de esta función queda a cargo del alumno.
 * Utilizando lo anterior, se pide desarrollar un algoritmo que
 * resuelva la siguiente situación problemática:
 * Todos los fines de mes, una empresa de telefonía celular
 * debe confeccionar las facturas con los consumos de todos
 * sus abonados, que se realizan en tres turnos de trabajo: Mañana, Tarde y Noche.
 * Para ello se ingresará por teclado la siguiente información de cada celular:
 * •	Número de celular 9 dígitos ( 0 indica cambio de turno).
 * •	Nombre del abonado 20 caracteres.
 * •	Dirección del abonado 25 caracteres.
 * •	Tiempo utilizado 4 dígitos en formato hhmm.
 * •	Tipo de abono (carácter, A, B, C, D o E).
 * Dependiendo del tipo de abono que se tenga, el usuario tiene cierta cantidad de minutos libres, por los cuales no abona cargo extra, pero por cada minuto que se exceda debe abonar una suma extra según la siguiente tabla:
 * <p>
 * Plan	A	B	C	D	E
 * Costo	$70	$55	$40	$28	$19
 * Minutos Libres	300	200	100	60	40
 * Cargo Min Exced.	$0.09	$0.15	$0.21	$0.29	$0.37.
 */
public class E17 {
    private final static String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\E17\\LOTE.txt";

    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        DecimalFormat df = new DecimalFormat("#,###.##");
        Scanner s = new Scanner(System.in);
        String cadenaLectura = null;
        String[] record = new String[0];
        System.out.print("NAME                         ");
        System.out.print("ADRESS                         ");
        System.out.print("MINUTES_FREE ");
        System.out.print("MINUTES_EXCEDEED ");
        System.out.print("BILING");
        System.out.println("");

        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);

            while ((cadenaLectura = bufferedReader.readLine()) != null) {
                record = cadenaLectura.split(";");
                String cellPhone = record[0];
                String fullName = record[1];
                String address = record[2];
                String time = record[3];
                String plan = record[4];
                System.out.print(fullName);
                System.out.print(" ");
                System.out.print(address);
                System.out.print(" ");
                System.out.print("      " + minutesFree(plan));
                System.out.print(" ");
                System.out.print("          " + minutesExceeded(plan, time));
                System.out.print(" ");
                System.out.println("        $" + df.format(billing(plan, time)));
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

    private static double billing(String plan, String timeUsed) {
        double bill = 0d;
        int minutesUsed = 0, minutesBilling = 0;
        minutesUsed = Integer.parseInt(timeUsed.substring(0, 2)) * 60 + Integer.parseInt(timeUsed.substring(2, 4));
        switch (plan) {
            case "A":
                minutesBilling = minutesUsed - 300;
                if (minutesBilling > 0) {
                    bill = minutesBilling * 0.09 + 70 + (minutesBilling * 0.09 + 70) * 0.21;
                } else if (minutesBilling <= 0) {
                    bill = 70 + 70 * 0.21;
                }
                ;
                break;
            case "B":
                minutesBilling = minutesUsed - 200;
                if (minutesBilling > 0) {
                    bill = minutesBilling * 0.15 + 55 + (minutesBilling * 0.15 + 55) * 0.21;
                } else if (minutesBilling <= 0) {
                    bill = 55 + 55 * 0.21;
                }
                ;
                break;
            case "C":
                minutesBilling = minutesUsed - 100;
                if (minutesBilling > 0) {
                    bill = minutesBilling * 0.21 + 40 + (minutesBilling * 0.21 + 40) * 0.21;
                } else if (minutesBilling <= 0) {
                    bill = 40 + 40 * 0.21;
                }
                ;
                break;
            case "D":
                minutesBilling = minutesUsed - 60;
                if (minutesBilling > 0) {
                    bill = minutesBilling * 0.29 + 28 + (minutesBilling * 0.29 + 28) * 0.21;
                } else if (minutesBilling <= 0) {
                    bill = 28 + 28 * 0.21;
                }
                ;
                break;
            case "E":
                minutesBilling = minutesUsed - 40;
                if (minutesBilling > 0) {
                    bill = minutesBilling * 0.37 + 19 + (minutesBilling * 0.37 + 19) * 0.21;
                } else if (minutesBilling <= 0) {
                    bill = 19 + 19 * 0.21;
                }
                ;
                break;
            default:
                break;
        }
        return bill;
    }

    private static String minutesFree(String plan) {
        String m = "";
        switch (plan) {
            case "A":
                m = "300";
                break;
            case "B":
                m = "200";
                break;
            case "C":
                m = "100";
                break;
            case "D":
                m = "060";
                break;
            case "E":
                m = "040";
                break;
            default:
                break;
        }
        return m;
    }

    private static int minutesExceeded(String plan, String timeUsed) {
        int m = 0, minutesEx = 0;
        switch (plan) {
            case "A":
                minutesEx = Integer.parseInt(timeUsed.substring(0, 2)) * 60 + Integer.parseInt(timeUsed.substring(2, 4)) - 300;
                if (minutesEx < 0) {
                    minutesEx = 0;
                }
                break;
            case "B":
                minutesEx = Integer.parseInt(timeUsed.substring(0, 2)) * 60 + Integer.parseInt(timeUsed.substring(2, 4)) - 200;
                if (minutesEx < 0) {
                    minutesEx = 0;
                }
                break;
            case "C":
                minutesEx = Integer.parseInt(timeUsed.substring(0, 2)) * 60 + Integer.parseInt(timeUsed.substring(2, 4)) - 100;
                if (minutesEx < 0) {
                    minutesEx = 0;
                }
                break;
            case "D":
                minutesEx = Integer.parseInt(timeUsed.substring(0, 2)) * 60 + Integer.parseInt(timeUsed.substring(2, 4)) - 60;
                if (minutesEx < 0) {
                    minutesEx = 0;
                }
                break;
            case "E":
                minutesEx = Integer.parseInt(timeUsed.substring(0, 2)) * 60 + Integer.parseInt(timeUsed.substring(2, 4)) - 40;
                if (minutesEx < 0) {
                    minutesEx = 0;
                }
                break;
            default:
                break;
        }
        return m;
    }
}
