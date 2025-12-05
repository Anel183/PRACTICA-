/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer10;

import java.util.List;

public class GestionJuego {
    ArchJugadores archivo;

    public GestionJuego() {
        this.archivo = new ArchJugadores();
    }

    public Jugador crearJugador(String nombre, int nivel, int puntaje) {
        Jugador j = new Jugador(nombre, nivel, puntaje);
        archivo.guardarJugador(j);
        return j;
    }

    public void mostrarTodos() {
        System.out.println("\nJUGADORES DEL VIDEOJUEGO");
        List<Jugador> lista = archivo.listarJugadores();
        if (lista.isEmpty()) {
            System.out.println("No hay jugadores registrados");
        } else {
            lista.forEach(System.out::println);
        }
    }

    public void buscarPorNombre(String nombre) {
        System.out.println("\nBúsqueda: " + nombre);
        Jugador j = archivo.buscarJugador(nombre);
        if (j != null) {
            System.out.println("Encontrado " + j);
        } else {
            System.out.println("Jugador no encontrado");
        }
    }
}