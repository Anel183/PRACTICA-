/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Empresa {
    private String nombre;
    List<Trabajador> trabajadores = new ArrayList<>();
    private static final String ARCHIVO = "datos/empresa.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Empresa(String nombre) {
        this.nombre = nombre;
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try {
            Files.createDirectories(Paths.get("datos"));
        } catch (IOException e) {}
    }

    public void agregarTrabajador(Trabajador t) {
        trabajadores.add(t);
    }

    public void aumentarSalario(String ci, double monto) {
        for (Trabajador t : trabajadores) {
            if (t.getCi().equals(ci)) {
                t.setSalario(t.getSalario() + monto);
                System.out.println("Salario aumentado: " + t.getNombre());
                return;
            }
        }
        System.out.println("No encontrado: " + ci);
    }

    public Trabajador mayorSalario() {
        return trabajadores.stream()
                .max(Comparator.comparingDouble(Trabajador::getSalario))
                .orElse(null);
    }

    public List<Trabajador> ordenarPorSalario() {
        return trabajadores.stream()
                .sorted(Comparator.comparingDouble(Trabajador::getSalario).reversed())
                .toList();
    }

    public void guardar() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("Datos guardados en datos/empresa.json");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    public static Empresa cargar() {
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No hay datos previos");
            return new Empresa("Mi Empresa");
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            Empresa e = gson.fromJson(r, Empresa.class);
            System.out.println("Datos cargados desde JSON");
            return e != null ? e : new Empresa("Mi Empresa");
        } catch (Exception e) {
            System.out.println("Error al cargar, empezando nuevo");
            return new Empresa("Mi Empresa");
        }
    }

    public void listar() {
        System.out.println("Trabajadores:");
        trabajadores.forEach(t -> System.out.println(t));
    }
}