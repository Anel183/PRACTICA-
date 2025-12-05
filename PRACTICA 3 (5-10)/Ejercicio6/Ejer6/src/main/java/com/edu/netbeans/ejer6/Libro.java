/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer6;
public class Libro {
    private int codLibro;
    private String titulo;
    private double precio;

    public Libro(int codLibro, String titulo, double precio) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getCodLibro() { return codLibro; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return codLibro + " - " + titulo + " (Bs. " + precio + ")";
    }
}