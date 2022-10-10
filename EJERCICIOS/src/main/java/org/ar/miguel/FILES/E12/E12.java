package org.ar.miguel.FILES.E12;

import sun.nio.cs.ext.MSISO2022JP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Un buque de carga traslada 100 contenedores a 3 diferentes
 * puertos del paísidentificados con los números 1, 2 y 3.
 * Por cada uno de los contenedores trasladados por el
 * buque se registran los siguientes datos:
 * •	Identificación del contenedor: idCont.
 * •	Peso del contenedor en (en kilos): peso.
 * •	Puerto de arribo (un valor de 1 a 3): idPuerto. Se pide calcular e informar:
 * •	El peso total que el buque debe trasladar.
 * •	El contenedor de mayor peso.
 * •	La cantidad de contenedores que se trasladarán a cada puerto.
 */
public class E12 {
    private final static int PUERTO_1 = 1;
    private final static int PUERTO_2 = 2;
    private final static int PUERTO_3 = 3;

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###.##");
        double pesoTotal = 0d, contMayorPeso = 0d;
        int p1 = 0, p2 = 0, p3 = 0, i = 0;
        String idPesoMax = "";
        String cadenaLectura = null;
        String[] stringsArray = new String[0];

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            //Put the exact location of the file Datos.csv
            fileReader = new FileReader("file's location");
            bufferedReader = new BufferedReader(fileReader);
            while ((cadenaLectura = bufferedReader.readLine()) != null) {
                stringsArray = cadenaLectura.split(",");

                String idCont = stringsArray[0];
                double peso = Double.parseDouble(stringsArray[1]);
                String idPuerto = stringsArray[2];

                pesoTotal = pesoTotal + peso;
                if (i == 0) {
                    contMayorPeso = peso;
                    i++;
                }
                if (peso > contMayorPeso) {
                    contMayorPeso = peso;
                    idPesoMax = "";
                    idPesoMax = idCont;
                }

                switch (Integer.parseInt(idPuerto)) {
                    case PUERTO_1:
                        p1++;
                        break;
                    case PUERTO_2:
                        p2++;
                        break;
                    case PUERTO_3:
                        p3++;
                        break;
                    default:
                        break;
                }
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
        System.out.println("ID OF THE HEAVIEST CONTAINER " + idPesoMax);
        System.out.println("TOTAL WEIGHT " + df.format(pesoTotal) + " T ");
        System.out.println("PORT 1 : " + p1);
        System.out.println("PORT 2 : " + p2);
        System.out.println("PORT 3 : " + p3);
    }
}
