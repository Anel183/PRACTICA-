/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Almacen {
    private List<Producto> productos = new ArrayList<>();
    private static final String ARCHIVO = "datos/productos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Almacen() {
        crearCarpetaDatos();
    }

    private void crearCarpetaDatos() {
        try {
            Files.createDirectories(Paths.get("datos"));
        } catch (IOException e) {}
    }

    // b) 
    public void guardarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto guardado: " + p.getNombre());
    }

    // c) 
    public Producto buscaProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                System.out.println("Encontrado: " + p);
                return p;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado");
        return null;
    }

    // d) 
    public double promedioPrecios() {
        if (productos.isEmpty()) return 0;
        double suma = 0;
        for (Producto p : productos) suma += p.getPrecio();
        return suma / productos.size();
    }

    // e) 
    public Producto productoMasCaro() {
        if (productos.isEmpty()) return null;
        Producto caro = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() > caro.getPrecio()) caro = p;
        }
        return caro;
    }

    // Métodos para JSON
    public void guardarEnJSON() {
        try (Writer w = Files.newBufferedWriter(Paths.get(ARCHIVO))) {
            gson.toJson(this, w);
            System.out.println("Todos los productos guardados en datos/productos.json");
        } catch (Exception e) {
            System.out.println("Error al guardar JSON");
        }
    }

    public static Almacen cargarDesdeJSON() {
        Almacen almacen = new Almacen();
        if (!Files.exists(Paths.get(ARCHIVO))) {
            System.out.println("No hay datos previos");
            return almacen;
        }
        try (Reader r = Files.newBufferedReader(Paths.get(ARCHIVO))) {
            Almacen temp = gson.fromJson(r, Almacen.class);
            if (temp != null) {
                almacen.productos = temp.productos;
                System.out.println("Productos cargados desde JSON");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON");
        }
        return almacen;
    }

    public void listar() {
        System.out.println("Lista de productos:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}