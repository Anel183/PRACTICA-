/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer3;

public class Ejer3 {
    public static void main(String[] args) {
        Almacen almacen = Almacen.cargarDesdeJSON();

        if (almacen.getProductos().isEmpty()) {
            almacen.guardarProducto(new Producto(101, "Laptop", 8500.50));
            almacen.guardarProducto(new Producto(102, "Mouse", 75.00));
            almacen.guardarProducto(new Producto(103, "Teclado", 250.00));
            almacen.guardarProducto(new Producto(104, "Monitor", 3200.00));
            System.out.println("Productos de prueba creados");
        }

        almacen.listar();

        // c) 
        almacen.buscaProducto(103);

        // d) 
        System.out.println("Promedio de precios: " + almacen.promedioPrecios());

        // e) 
        Producto caro = almacen.productoMasCaro();
        if (caro != null) {
            System.out.println("Producto más caro: " + caro);
        }

        // Guardar todo
        almacen.guardarEnJSON();
    }
}