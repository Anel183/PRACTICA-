/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer6;
import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchPrestamo {
    private String nomArchPrestamo;
    private List<Prestamo> prestamos = new ArrayList<>();
    private static final String ARCHIVO = "datos/prestamos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private ArchLibro archLibro;
    private ArchCliente archCliente;

    public ArchPrestamo(String nomArchPrestamo, ArchLibro archLibro, ArchCliente archCliente) {
        this.nomArchPrestamo = nomArchPrestamo;
        this.archLibro = archLibro;
        this.archCliente = archCliente;
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try { Files.createDirectories(Paths.get("datos")); }
        catch (IOException e) {}
    }

    public void agregarPrestamo(Prestamo p) {
        prestamos.add(p);
    }

    // a) Libros cuyo precio está entre x e y
    public void librosEntrePrecios(double min, double max) {
        System.out.println("Libros con precio entre " + min + " y " + max + ":");
        archLibro.getLibros().stream()
            .filter(l -> l.getPrecio() >= min && l.getPrecio() <= max)
            .forEach(System.out::println);
    }

    // b) Ingreso total por un libro específico
    public double ingresoTotalPorLibro(int codLibro) {
        double total = 0;
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codLibro) {
                Libro l = archLibro.buscarLibro(codLibro);
                if (l != null) total += l.getPrecio() * p.getCantidad();
            }
        }
        System.out.println("Ingreso total del libro " + codLibro + ": Bs. " + total);
        return total;
    }

    // c) Libros nunca prestados
    public void librosNuncaPrestados() {
        System.out.println("Libros que NUNCA fueron prestados:");
        Set<Integer> prestados = new HashSet<>();
        for (Prestamo p : prestamos) prestados.add(p.getCodLibro());

        archLibro.getLibros().stream()
            .filter(l -> !prestados.contains(l.getCodLibro()))
            .forEach(System.out::println);
    }

    // d) Clientes que compraron un libro específico
    public void clientesQuePrestaronLibro(int codLibro) {
        System.out.println("Clientes que prestaron el libro " + codLibro + ":");
        Set<Integer> codClientes = new HashSet<>();
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codLibro) codClientes.add(p.getCodCliente());
        }
        for (int cod : codClientes) {
            Cliente c = archCliente.buscarCliente(cod);
            if (c != null) System.out.println(c);
        }
    }

    // e) Libro más prestado
    public void libroMasPrestado() {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Prestamo p : prestamos) {
            conteo.put(p.getCodLibro(), conteo.getOrDefault(p.getCodLibro(), 0) + p.getCantidad());
        }
        if (conteo.isEmpty()) {
            System.out.println("No hay préstamos");
            return;
        }
        int maxCod = conteo.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .get().getKey();
        Libro l = archLibro.buscarLibro(maxCod);
        System.out.println("Libro más prestado: " + (l != null ? l : "Código " + maxCod));
    }

    // f) Cliente con más préstamos
    public void clienteConMasPrestamos() {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Prestamo p : prestamos) {
            conteo.put(p.getCodCliente(), conteo.getOrDefault(p.getCodCliente(), 0) + p.getCantidad());
        }
        if (conteo.isEmpty()) {
            System.out.println("No hay préstamos");
            return;
        }
        int maxCod = conteo.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .get().getKey();
        Cliente c = archCliente.buscarCliente(maxCod);
        System.out.println("Cliente con más préstamos: " + (c != null ? c : "Código " + maxCod));
    }

    // JSON
    public void guardarEnJSON() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("Préstamos guardados en datos/prestamos.json");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    public static ArchPrestamo cargarDesdeJSON(ArchLibro al, ArchCliente ac) {
        ArchPrestamo ap = new ArchPrestamo("Prestamos2025", al, ac);
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No hay datos previos");
            return ap;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            ArchPrestamo temp = gson.fromJson(r, ArchPrestamo.class);
            if (temp != null && temp.prestamos != null) {
                ap.prestamos = temp.prestamos;
                System.out.println("Cargados " + ap.prestamos.size() + " préstamos");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
        return ap;
    }

}