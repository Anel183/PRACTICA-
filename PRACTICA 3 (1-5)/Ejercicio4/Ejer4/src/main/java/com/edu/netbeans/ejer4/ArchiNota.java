/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer4;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchiNota {
    private String nombreArchi;
    private List<Nota> notas = new ArrayList<>();
    private static final String ARCHIVO = "datos/notas.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try {
            Files.createDirectories(Paths.get("datos"));
        } catch (IOException e) {}
    }

    // b) 
    public void agregarNota(Nota nota) {
        notas.add(nota);
        System.out.println("Nota agregada: " + nota.getEstudiante().getNombre() + " - " + nota.getMateria());
    }

    // c) 
    public double promedioNotas() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (Nota n : notas) suma += n.getNotaFinal();
        return suma / notas.size();
    }

    // d) 
    public List<Nota> mejoresNotas() {
        if (notas.isEmpty()) return new ArrayList<>();
        double max = notas.stream().mapToDouble(Nota::getNotaFinal).max().getAsDouble();
        return notas.stream()
                .filter(n -> n.getNotaFinal() == max)
                .toList();
    }

    // e) 
    public void eliminarMateria(String materia) {
        int antes = notas.size();
        notas.removeIf(n -> n.getMateria().equalsIgnoreCase(materia));
        int eliminadas = antes - notas.size();
        System.out.println("Eliminadas " + eliminadas + " notas de la materia: " + materia);
    }

    // Métodos JSON
    public void guardarEnJSON() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("Todas las notas guardadas en datos/notas.json");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    public static ArchiNota cargarDesdeJSON() {
        ArchiNota archi = new ArchiNota("Registro UMSA 2025");
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No hay datos previos");
            return archi;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            ArchiNota temp = gson.fromJson(r, ArchiNota.class);
            if (temp != null && temp.notas != null) {
                archi.notas = temp.notas;
                System.out.println("Cargadas " + archi.notas.size() + " notas desde JSON");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar, empezando nuevo");
        }
        return archi;
    }

    public void listar() {
        System.out.println("=== NOTAS REGISTRADAS ===");
        if (notas.isEmpty()) {
            System.out.println("No hay notas");
            return;
        }
        notas.forEach(System.out::println);
    }

    public List<Nota> getNotas() {
        return notas;
    }
}