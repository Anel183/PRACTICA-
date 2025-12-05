/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer7;
public class Ejer7 {
    public static void main(String[] args) {
        ArchNiño registro = ArchNiño.cargar();

        if (registro.niños.isEmpty()) {
            registro.crear(new Niño(1001, "Juan Carlos", "Perez", "Gomez", "8765432", 24, 12.5, 88));
            registro.crear(new Niño(1002, "Maria Elena", "Lopez", "Rojas", "9876543", 36, 15.0, 98));
            registro.crear(new Niño(1003, "Carlos Alberto", "Quispe", "Condori", "7654321", 18, 8.0, 75));
            registro.crear(new Niño(1004, "Ana Maria", "Flores", "Mamni", "6543210", 30, 18.0, 95));
            registro.crear(new Niño(1005, "Luis Fernando", "Mamani", "Torrez", "5432109", 42, 16.5, 105));
            System.out.println("Datos de prueba creados\n");
        }

        registro.listar();
        System.out.println();
        registro.contarPesoAdecuado();
        System.out.println();
        registro.mostrarConProblemasNutricion();
        System.out.println();
        registro.promedioEdad();
        System.out.println();
        Niño encontrado = registro.buscarPorCarnet(1003);
        if (encontrado != null) System.out.println("→ " + encontrado);
        System.out.println();
        registro.niñosMasAltos();
        System.out.println();
        registro.guardar();
    }
}