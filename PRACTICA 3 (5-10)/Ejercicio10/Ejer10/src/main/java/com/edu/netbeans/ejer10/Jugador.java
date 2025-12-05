/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer10;
public class Jugador {
    private String nombre;
    private int nivel;
    private int puntaje;

    public Jugador() {} 

    public Jugador(String nombre, int nivel, int puntaje) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntaje = puntaje;
    }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPuntaje() { return puntaje; }

    @Override
    public String toString() {
        return String.format("%-15s  Nivel: %3d Puntaje: %,10d", nombre, nivel, puntaje);
    }
}