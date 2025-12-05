/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer8;
import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ArchAlimento {
    private String nombreArch;
    List<Alimento> alimentos = new ArrayList<>();
    private static final String ARCHIVO = "datos/refrigerador.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ArchAlimento(String nombreArch) {
        this.nombreArch = nombreArch;
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try { Files.createDirectories(Paths.get("datos")); }
        catch (IOException e) {}
    }

    // a) 
    public void crear(Alimento a) {
        alimentos.add(a);
        System.out.println("Alimento agregado: " + a.getNombre());
    }

    // a)
    public boolean modificarPorNombre(String nombre, int nuevaCantidad) {
        for (Alimento a : alimentos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                a.setCantidad(nuevaCantidad);
                System.out.println("Modificado: " + nombre + " → nueva cantidad: " + nuevaCantidad);
                return true;
            }
        }
        System.out.println("No se encontró: " + nombre);
        return false;
    }

    // a) 
    public boolean eliminarPorNombre(String nombre) {
        boolean eliminado = alimentos.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
        System.out.println(eliminado ? "Eliminado: " + nombre : "No encontrado: " + nombre);
        return eliminado;
    }

    // b) 
    public void caducadosAntesDe(String fechaX) {
        LocalDate fechaLimite = LocalDate.parse(fechaX, fmt);
        System.out.println("Alimentos que caducaron antes del " + fechaX + ":");
        alimentos.stream()
            .filter(a -> LocalDate.parse(a.getFechaCaducidad(), fmt).isBefore(fechaLimite))
            .forEach(System.out::println);
    }

    // c)
    public void eliminarCantidadCero() {
        int antes = alimentos.size();
        alimentos.removeIf(a -> a.getCantidad() == 0);
        int eliminados = antes - alimentos.size();
        System.out.println("Eliminados " + eliminados + " alimentos con cantidad 0");
    }

    // d) 
    public void alimentosVencidos() {
        LocalDate hoy = LocalDate.now();
        System.out.println("ALIMENTOS VENCIDOS (hoy o antes):");
        alimentos.stream()
            .filter(a -> !LocalDate.parse(a.getFechaCaducidad(), fmt).isAfter(hoy))
            .forEach(System.out::println);
    }

    // e) 
    public void alimentoConMasCantidad() {
        if (alimentos.isEmpty()) {
            System.out.println("No hay alimentos");
            return;
        }
        Alimento max = alimentos.get(0);
        for (Alimento a : alimentos) {
            if (a.getCantidad() > max.getCantidad()) max = a;
        }
        System.out.println("Alimento con MÁS cantidad:");
        System.out.println(max);
    }

    // GUARDAR JSON
    public void guardar() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("\nRefrigerador guardado en datos/refrigerador.json");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    // CARGAR JSON
    public static ArchAlimento cargar() {
        ArchAlimento arch = new ArchAlimento("RefrigeradorUMSA");
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No existe archivo JSON  empezando vacío");
            return arch;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            ArchAlimento temp = gson.fromJson(r, ArchAlimento.class);
            if (temp != null && temp.alimentos != null) {
                arch.alimentos = temp.alimentos;
                System.out.println("CARGA EXITOSA: " + arch.alimentos.size() + " alimentos cargados desde JSON");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON");
        }
        return arch;
    }

    public void listar() {
        System.out.println(" CONTENIDO DEL REFRIGERADOR");
        if (alimentos.isEmpty()) System.out.println("Vacío");
        else alimentos.forEach(System.out::println);
    }
}