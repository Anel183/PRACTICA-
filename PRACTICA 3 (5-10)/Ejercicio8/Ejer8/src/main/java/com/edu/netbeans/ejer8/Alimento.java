/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer8;
public class Alimento {
    private String nombre;
    private int cantidad;
    private String fechaCaducidad;         

    public Alimento(String nombre, int cantidad, String fechaCaducidad, String tipo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public String getFechaCaducidad() { return fechaCaducidad; }

    @Override
    public String toString() {
        return nombre + " | Cant: " + cantidad + " | Caduca: " + fechaCaducidad;
    }
}