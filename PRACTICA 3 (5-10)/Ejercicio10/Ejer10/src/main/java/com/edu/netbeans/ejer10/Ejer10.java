/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer10;

public class Ejer10 {
    public static void main(String[] args) {
        GestionJuego juego = new GestionJuego();

        if (juego.archivo.listarJugadores().isEmpty()) {
            juego.crearJugador("xX_DarkLord_Xx", 87, 2850000);
            juego.crearJugador("ProGamer123", 92, 3200000);
            juego.crearJugador("NoobMaster", 5, 1200);
            juego.crearJugador("LaLeyenda", 99, 5000000);
            System.out.println("¡Jugadores de prueba creados!\n");
        }

        juego.mostrarTodos();
        juego.buscarPorNombre("ProGamer123");
        juego.buscarPorNombre("NoobMaster");

        System.out.println("\n¡Fin del programa! Todo guardado en datos/jugadores.json");
    }
}