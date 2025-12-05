/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Comparator;

public class ArchFarmacia {
    private List<Farmacia> farmacias = new ArrayList<>();
    private static final String ARCHIVO = "datos/farmacias.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchFarmacia() {
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try {
            Files.createDirectories(Paths.get("datos"));
        } catch (IOException e) {
            System.out.println("Error creando carpeta datos");
        }
    }

    public void agregarFarmacia(Farmacia f) {
        farmacias.add(f);
    }

    // a) 
    public void medicamentosTosEnSucursal(int numero) {
        Farmacia f = buscarFarmacia(numero);
        if (f == null) {
            System.out.println("Sucursal " + numero + " no existe");
            return;
        }
        System.out.println("Medicamentos para TOS en " + f + ":");
        f.getMedicamentos().stream()
            .filter(m -> m.getTipo().equalsIgnoreCase("Tos"))
            .forEach(System.out::println);
    }

    // b) 
    public void sucursalesConTapsin() {
        System.out.println("Sucursales con Tapsin:");
        for (Farmacia f : farmacias) {
            boolean tiene = f.getMedicamentos().stream()
                .anyMatch(m -> m.getNombre().equalsIgnoreCase("Tapsin"));
            if (tiene) {
                System.out.println(f.getNumeroSucursal() + " - " + f.getDireccion());
            }
        }
    }

    // c) 
    public void medicamentosPorTipo(String tipo) {
        System.out.println("Medicamentos de tipo: " + tipo);
        farmacias.forEach(f ->
            f.getMedicamentos().stream()
                .filter(m -> m.getTipo().equalsIgnoreCase(tipo))
                .forEach(m -> System.out.println("  Sucursal " + f.getNumeroSucursal() + " → " + m))
        );
    }

    // d) 
    public void ordenarPorDireccion() {
        System.out.println("Farmacias ordenadas por dirección:");
        farmacias.stream()
            .sorted(Comparator.comparing(Farmacia::getDireccion))
            .forEach(f -> System.out.println(f.getNumeroSucursal() + " - " + f.getDireccion()));
    }

    // e)
    public void moverMedicamentos(String tipo, int desde, int hacia) {
        Farmacia origen = buscarFarmacia(desde);
        Farmacia destino = buscarFarmacia(hacia);
        if (origen == null || destino == null) {
            System.out.println("Sucursal origen o destino no existe");
            return;
        }
        List<Medicamento> movidos = origen.extraerPorTipo(tipo);
        movidos.forEach(destino::agregarMedicamento);
        System.out.println("Movidos " + movidos.size() + " medicamentos de tipo '" + tipo +
                         "' de sucursal " + desde + " a " + hacia);
    }

    private Farmacia buscarFarmacia(int numero) {
        return farmacias.stream()
            .filter(f -> f.getNumeroSucursal() == numero)
            .findFirst()
            .orElse(null);
    }

    // GUARDAR EN JSON
    public void guardarEnJSON() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("ArchFarmacia guardada en datos/farmacias.json");
        } catch (Exception e) {
            System.out.println("Error al guardar JSON");
        }
    }

    // CARGAR DESDE JSON
    public static ArchFarmacia cargarDesdeJSON() {
        ArchFarmacia arch = new ArchFarmacia();
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No hay datos previos, empezando vacío");
            return arch;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            ArchFarmacia temp = gson.fromJson(r, ArchFarmacia.class);
            if (temp != null && temp.farmacias != null) {
                arch.farmacias = temp.farmacias;
                System.out.println("ArchFarmacia cargada desde JSON (" + arch.farmacias.size() + " sucursales)");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON, empezando nuevo");
        }
        return arch;
    }

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }
}