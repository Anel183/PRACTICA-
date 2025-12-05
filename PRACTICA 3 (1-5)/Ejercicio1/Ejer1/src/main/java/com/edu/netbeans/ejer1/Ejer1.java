/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer1;
import java.util.*;
import java.util.stream.Collectors;

public class Ejer1 {
    public static void main(String[] args) {
        List<Charango> charangos = CharangoJSON.cargar();

        if (charangos.isEmpty()) {
            charangos.add(new Charango("Palo santo", 10));
            charangos.add(new Charango("Naranjillo", 8));
            charangos.add(new Charango("Palo santo", 5));
            charangos.add(new Charango("Jacarandá", 10));
            charangos.add(new Charango("Pino", 3));
            charangos.add(new Charango("Jacarandá", 9));
            charangos.add(new Charango("Cedro", 7));
            System.out.println("Datos de prueba creados.\n");
        }

        System.out.println("TODOS LOS CHARANGOS");
        charangos.forEach(System.out::println);

        // b) 
        long eliminados = charangos.stream().filter(Charango::tieneMasDe6Rotas).count();
        charangos.removeIf(Charango::tieneMasDe6Rotas);
        System.out.println("\nEliminados: " + eliminados + " charangos con más de 6 rotas.\n");

        // c) 
        System.out.println(" CHARANGOS DE PALO SANTO");
        charangos.stream()
                 .filter(c -> c.getMaterial().equalsIgnoreCase("Palo santo"))
                 .forEach(System.out::println);

        // d) 
        System.out.println("\n CHARANGOS CON 10 CUERDAS ");
        charangos.stream()
                 .filter(Charango::tiene10Cuerdas)
                 .forEach(System.out::println);

        // e) 
        System.out.println("\nORDENADOS POR MATERIAL");
        List<Charango> ordenados = charangos.stream()
                .sorted(Comparator.comparing(Charango::getMaterial, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
        ordenados.forEach(System.out::println);

        CharangoJSON.guardar(ordenados);
    }
}