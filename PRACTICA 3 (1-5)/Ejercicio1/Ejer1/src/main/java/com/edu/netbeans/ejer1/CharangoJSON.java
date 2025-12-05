/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CharangoJSON {
    private static final String RUTA = "datos/charangos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static {
        try { Files.createDirectories(Paths.get("datos")); }
        catch (IOException e) { System.err.println("Error creando carpeta datos"); }
    }

    public static void guardar(List<Charango> lista) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(RUTA))) {
            gson.toJson(lista, writer);
            System.out.println("Guardado correctamente en " + RUTA);
        } catch (IOException e) {
            System.err.println("Error guardando: " + e.getMessage());
        }
    }

    public static List<Charango> cargar() {
        if (!Files.exists(Paths.get(RUTA))) {
            System.out.println("No existe archivo json, creando lista vacía.");
            return new ArrayList<>();
        }
        try (Reader reader = Files.newBufferedReader(Paths.get(RUTA))) {
            Type tipo = new TypeToken<ArrayList<Charango>>(){}.getType();
            List<Charango> lista = gson.fromJson(reader, tipo);
            System.out.println("Cargados " + lista.size() + " charangos desde json");
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error leyendo json: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}