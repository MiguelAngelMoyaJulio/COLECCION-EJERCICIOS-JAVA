package org.ar.miguel.FILES.E18;

import com.sun.istack.internal.localization.NullLocalizable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * El gobierno de la Ciudad de Buenos Aires realiza una encuesta
 * en casas de familia. De cada familia se conoce:
 * domicilio, tipo de vivienda (‘C’: casa, ‘D’: departamento), y cantidad de integrantes.
 * De cada integrante de la familia se conoce:
 * nombre, apellido, edad, sexo (‘F’, ‘M’),
 * nivel de estudios alcanzados (‘N’: no posee, ‘P’: primario, ‘S’: secundario, ‘T’: terciario, ‘U’: universitario), y un indicador (‘I’: incompleto, ‘C’: completo) que se refiere al ítem anterior.
 * Los datos finalizan cuando la cantidad de integrantes sea igual a cero.
 * Se pide emitir un listado con los resultados:
 * •Los datos de los encuestados que hayan completado los estudios primarios.
 * •El porcentaje de analfabetismo en la ciudad
 * (se considera analfabetos a los mayores de 10 años que no posean estudios).
 * •	El domicilio de la familia con mayor cantidad de
 * integrantes que viven en departamento.
 * •	La edad promedio de cada familia y de la ciudad.
 * •	La cantidad de encuestados en cada tipo de nivel
 * de estudios alcanzados incompletos.
 * •	El porcentaje de encuestados de sexo femenino y masculino.
 */
public class E18 {
    private final static String INPUT_FILE = "D:\\Miguel\\DEVELOPMENT\\JAVA-EJERCICIOS-GIT\\EJERCICIOS\\src\\main\\java\\org\\ar\\miguel\\E18\\LOTE.txt";

    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        DecimalFormat df = new DecimalFormat("##.00");

        Scanner s = new Scanner(System.in);

        String cadenaLectura = null;
        String[] record = new String[0];
        String familyAddressDepartment = "",addressAux = "";

        List<Persona> personas = new ArrayList<>();
        List<Persona> estudiosPrimariosCompletos = new ArrayList<>();

        int totalRecords = 0,amountAnalfa = 0;
        int amountSexFem = 0, amountSexMas = 0;
        int[] statusAllStudies = new int[4];
        int maxAmountMembners = 0, amountMembers = 0, familyAge = 0;

        double porcSexFem = 0d, porcSexMas = 0d;
        double porcAnalfa = 0d;
        double ageAveFamilyCity = 0d, totalAge = 0d, agePerFamily = 0d;

        Persona p = null;
        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader(INPUT_FILE);
            bufferedReader = new BufferedReader(fileReader);
            cadenaLectura = bufferedReader.readLine();
            while ((cadenaLectura) != null) {

                record = cadenaLectura.split(";");
                p = new Persona(record[0],
                        record[1],
                        Integer.parseInt(record[2]),
                        record[3],
                        Integer.parseInt(record[4]),
                        record[5],
                        record[6],
                        record[7]);

                addressAux = "";
                addressAux = p.getAdress();
                amountMembers = 0;
                familyAge = 0;
                agePerFamily = 0d;
                while (addressAux.equals(p.getAdress()) && (cadenaLectura) != null) {
                    familyAge = familyAge + p.getAge();
                    totalRecords++;
                    amountMembers++;

                    if (p.getStudies().equalsIgnoreCase("p") && p.getStatus().equalsIgnoreCase("c")) {
                        estudiosPrimariosCompletos.add(p);
                    }

                    if (p.getAge() > 10 && p.getStudies().equalsIgnoreCase("n")) {
                        amountAnalfa++;
                    }

                    if (p.getLivingPlace().equalsIgnoreCase("d") && p.getMembers() > maxAmountMembners) {
                        maxAmountMembners = p.getMembers();
                        familyAddressDepartment = "";
                        familyAddressDepartment = p.getAdress();
                    }

                    if (p.getSex().equalsIgnoreCase("f")) {
                        amountSexFem++;
                    } else if (p.getSex().equalsIgnoreCase("m")) {
                        amountSexMas++;
                    }
                    if (p.getStudies().equalsIgnoreCase("p") && p.getStatus().equalsIgnoreCase("i")) {
                        statusAllStudies[0]++;
                    } else if (p.getStudies().equalsIgnoreCase("s") && p.getStatus().equalsIgnoreCase("i")) {
                        statusAllStudies[1]++;
                    } else if (p.getStudies().equalsIgnoreCase("t") && p.getStatus().equalsIgnoreCase("i")) {
                        statusAllStudies[2]++;
                    } else if (p.getStudies().equalsIgnoreCase("u") && p.getStatus().equalsIgnoreCase("i")) {
                        statusAllStudies[3]++;
                    }
                    totalAge = totalAge + p.getAge();

                    cadenaLectura = bufferedReader.readLine();
                    if (cadenaLectura != null) {
                        record = cadenaLectura.split(";");
                        p = new Persona(record[0],
                                record[1],
                                Integer.parseInt(record[2]),
                                record[3],
                                Integer.parseInt(record[4]),
                                record[5],
                                record[6],
                                record[7]);
                    }
                }
                agePerFamily = (double) (familyAge / amountMembers);
                System.out.println("average age per family : " + df.format(agePerFamily));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
        System.out.println(" ");
        System.out.println("People who finished primary school");
        estudiosPrimariosCompletos.stream().forEach(System.out::println);
        System.out.println(" ");
        porcAnalfa = (amountAnalfa * 100) / totalRecords;
        System.out.println("illiteracy percentage " + df.format(porcAnalfa) + " %");
        System.out.println(" ");
        System.out.println("max members who live at department : " + familyAddressDepartment);
        porcSexMas = (amountSexMas * 100) / totalRecords;
        porcSexFem = (amountSexFem * 100) / totalRecords;
        System.out.println(" ");
        System.out.println("male percentage : " + df.format(porcSexMas));
        System.out.println("female percentage : " + df.format(porcSexFem));
        System.out.println(" ");
        System.out.println("primary incomplete " + statusAllStudies[0]);
        System.out.println("high school incomplete " + statusAllStudies[1]);
        System.out.println("tertiary incomplete " + statusAllStudies[2]);
        System.out.println("university incomplete " + statusAllStudies[3]);
        System.out.println("");
        ageAveFamilyCity = totalAge / totalRecords;
        System.out.println("average age of the city : " + df.format(ageAveFamilyCity));
    }
}
