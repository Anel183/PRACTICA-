/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer5;
public class Medicamento {
    private String nombre;
    private String tipo;
    private double precio;

    public Medicamento(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Bs. " + precio;
    }
}