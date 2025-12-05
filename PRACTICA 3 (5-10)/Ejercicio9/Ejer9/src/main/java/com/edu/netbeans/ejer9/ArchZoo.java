/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer9;
import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchZoo {
    private String nombre;
    List<Zoologico> zoologicos = new ArrayList<>();
    private static final String ARCHIVO = "datos/zoologicos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchZoo(String nombre) {
        this.nombre = nombre;
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try { Files.createDirectories(Paths.get("datos")); }
        catch (IOException e) {}
    }

    // a) 
    public void crear(Zoologico z) {
        zoologicos.add(z);
        System.out.println("Zoológico creado: " + z.getNombre());
    }

    // a) 
    public boolean modificarNombre(int id, String nuevoNombre) {
        for (Zoologico z : zoologicos) {
            if (z.getId() == id) {
                z = new Zoologico(id, nuevoNombre); 
                System.out.println("Nombre modificado a: " + nuevoNombre);
                return true;
            }
        }
        System.out.println("Zoológico " + id + " no encontrado");
        return false;
    }

    // a) 
    public boolean eliminar(int id) {
        boolean eliminado = zoologicos.removeIf(z -> z.getId() == id);
        System.out.println(eliminado ? "Zoológico " + id + " eliminado" : "No encontrado");
        return eliminado;
    }

    // b) 
    public void zoologicosMayorVariedad() {
        if (zoologicos.isEmpty()) {
            System.out.println("No hay zoológicos");
            return;
        }
        int max = zoologicos.stream()
                .mapToInt(Zoologico::contarEspeciesDiferentes)
                .max().getAsInt();
        System.out.println("Zoológicos con mayor variedad (" + max + " especies):");
        zoologicos.stream()
                .filter(z -> z.contarEspeciesDiferentes() == max)
                .forEach(System.out::println);
    }

    // c) 
    public void eliminarZoologicosVacios() {
        System.out.println("Zoológicos vacíos:");
        zoologicos.stream()
                .filter(Zoologico::estaVacio)
                .forEach(z -> System.out.println(z));
        int eliminados = (int) zoologicos.stream().filter(Zoologico::estaVacio).count();
        zoologicos.removeIf(Zoologico::estaVacio);
        System.out.println("Eliminados " + eliminados + " zoológicos vacíos");
    }

    // d) 
    public void animalesDeEspecie(String especie) {
        System.out.println("Animales de especie '" + especie + "':");
        zoologicos.forEach(z -> {
            for (int i = 0; i < z.getNroAnimales(); i++) {
                Animal a = z.getAnimales()[i];
                if (a.getEspecie().equalsIgnoreCase(especie)) {
                    System.out.println("  " + z.getNombre() + " → " + a);
                }
            }
        });
    }

    // e) 
    public void moverAnimales(int desdeId, int haciaId) {
        Zoologico origen = null, destino = null;
        for (Zoologico z : zoologicos) {
            if (z.getId() == desdeId) origen = z;
            if (z.getId() == haciaId) destino = z;
        }
        if (origen == null || destino == null) {
            System.out.println("Uno de los zoológicos no existe");
            return;
        }
        origen.vaciarHacia(destino);
        System.out.println("Animales movidos de " + desdeId + " a " + haciaId);
    }

    // JSON
    public void guardar() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("\nArchZoo guardado en datos/zoologicos.json");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }

    public static ArchZoo cargar() {
        ArchZoo arch = new ArchZoo("Zoo Bolivia 2025");
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No existe archivo JSON empezando vacío");
            return arch;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            ArchZoo temp = gson.fromJson(r, ArchZoo.class);
            if (temp != null && temp.zoologicos != null) {
                arch.zoologicos = temp.zoologicos;
                System.out.println("CARGA EXITOSA: " + arch.zoologicos.size() + " zoológicos cargados desde JSON");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON");
        }
        return arch;
    }

    public void listar() {
        System.out.println(" ZOOLÓGICOS REGISTRADOS ");
        zoologicos.forEach(System.out::println);
    }
}