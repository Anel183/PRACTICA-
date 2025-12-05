/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer7;
import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchNiño {
    private String nombreArchivo;
    List<Niño> niños = new ArrayList<>();
    private static final String ARCHIVO = "datos/ninos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchNiño(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try { Files.createDirectories(Paths.get("datos")); }
        catch (IOException e) {}
    }

    // a) 
    public void crear(Niño n) {
        niños.add(n);
        System.out.println("Niño agregado: " + n.getCarnet());
    }

    // a) 
    public void listar() {
        System.out.println("=== LISTA DE NIÑOS REGISTRADOS ===");
        if (niños.isEmpty()) {
            System.out.println("No hay niños");
            return;
        }
        niños.forEach(System.out::println);
    }

    // b) 
    public int contarPesoAdecuado() {
        int contador = 0;
        for (Niño n : niños) {
            double pesoIdeal = n.getEdad() * 0.45 + 6; 
            if (Math.abs(n.getPeso() - pesoIdeal) <= 2.5 && n.getTalla() >= 85) {
                contador++;
            }
        }
        System.out.println("Niños con peso y talla ADECUADA: " + contador);
        return contador;
    }

    // c) 
    public void mostrarConProblemasNutricion() {
        System.out.println("Niños con peso o talla NO ADECUADA:");
        for (Niño n : niños) {
            double pesoIdeal = n.getEdad() * 0.45 + 6;
            if (n.getPeso() < pesoIdeal - 2.5 || n.getPeso() > pesoIdeal + 4 || n.getTalla() < 85) {
                System.out.println(n + " → POSIBLE DESNUTRICIÓN O SOBREPESO");
            }
        }
    }

    // d) 
    public double promedioEdad() {
        if (niños.isEmpty()) return 0;
        double suma = niños.stream().mapToInt(Niño::getEdad).sum();
        double prom = suma / niños.size();
        System.out.println("Promedio de edad: " + String.format("%.1f", prom) + " meses");
        return prom;
    }

    // e)
    public Niño buscarPorCarnet(int carnet) {
        return niños.stream()
                .filter(n -> n.getCarnet() == carnet)
                .findFirst()
                .orElse(null);
    }

    // f) 
    public void niñosMasAltos() {
        if (niños.isEmpty()) {
            System.out.println("No hay niños");
            return;
        }
        double max = niños.stream().mapToDouble(Niño::getTalla).max().getAsDouble();
        System.out.println("Niño(s) con mayor talla (" + max + " cm):");
        niños.stream()
             .filter(n -> n.getTalla() == max)
             .forEach(System.out::println);
    }

    // GUARDAR JSON
    public void guardar() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("\nDatos guardados correctamente en datos/ninos.json");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    // CARGAR JSON
    public static ArchNiño cargar() {
        ArchNiño arch = new ArchNiño("ControlPediatrico2025");
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No existe archivo JSON  empezando vacío");
            return arch;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            ArchNiño temp = gson.fromJson(r, ArchNiño.class);
            if (temp != null && temp.niños != null) {
                arch.niños = temp.niños;
                System.out.println("CARGA EXITOSA: " + arch.niños.size() + " niños cargados desde JSON");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON");
        }
        return arch;
    }
}