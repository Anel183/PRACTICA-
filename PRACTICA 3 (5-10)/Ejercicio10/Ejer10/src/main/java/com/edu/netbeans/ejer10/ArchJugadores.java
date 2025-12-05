/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer10;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.*;

public class ArchJugadores {
    private String nombreArchivo = "datos/jugadores.json";
    private List<Jugador> jugadores = new ArrayList<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchJugadores() {
        crearCarpetaDatos();
        cargarDesdeJSON();
    }

    private void crearCarpetaDatos() {
        try { Files.createDirectories(Paths.get("datos")); }
        catch (IOException e) { System.out.println("Error creando carpeta datos"); }
    }

    private void cargarDesdeJSON() {
        if (!Files.exists(Paths.get(nombreArchivo))) {
            System.out.println("No existe jugadores.json lista vacía");
            return;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(nombreArchivo))) {
            Type tipo = new TypeToken<List<Jugador>>(){}.getType();
            List<Jugador> lista = gson.fromJson(r, tipo);
            if (lista != null) jugadores = lista;
            System.out.println("CARGADOS " + jugadores.size() + " jugadores desde JSON");
        } catch (Exception e) {
            System.out.println("Error al cargar JSON");
        }
    }

    public void guardarJugador(Jugador j) {
        jugadores.add(j);
        guardarEnJSON();
        System.out.println("Jugador guardado: " + j.getNombre());
    }

    public List<Jugador> listarJugadores() {
        return new ArrayList<>(jugadores);
    }

    public Jugador buscarJugador(String nombre) {
        return jugadores.stream()
                .filter(j -> j.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    private void guardarEnJSON() {
        try (Writer w = Files.newBufferedWriter(Paths.get(nombreArchivo))) {
            gson.toJson(jugadores, w);
        } catch (Exception e) {
            System.out.println("Error al guardar JSON");
        }
    }
}