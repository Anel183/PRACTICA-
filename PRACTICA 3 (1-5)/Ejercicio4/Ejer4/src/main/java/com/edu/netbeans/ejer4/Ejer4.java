/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer4;
public class Ejer4 {
    public static void main(String[] args) {
        ArchiNota registro = ArchiNota.cargarDesdeJSON();

        if (registro.getNotas().isEmpty()) {
            Estudiante e1 = new Estudiante("2023001", "Juan", "Perez", "Gomez", 20);
            Estudiante e2 = new Estudiante("2023002", "Maria", "Lopez", "Rojas", 19);
            Estudiante e3 = new Estudiante("2023003", "Carlos", "Mamni", "Quispe", 21);
            Estudiante e4 = new Estudiante("2023004", "Ana", "Flores", "Condori", 20);

            registro.agregarNota(new Nota("Programación", 95, e1));
            registro.agregarNota(new Nota("Base de Datos", 88, e1));
            registro.agregarNota(new Nota("Programación", 100, e2));
            registro.agregarNota(new Nota("Redes", 75, e3));
            registro.agregarNota(new Nota("Programación", 92, e4));
            System.out.println("Datos de prueba creados");
        }

        registro.listar();
        System.out.println("Promedio general: " + registro.promedioNotas());

        System.out.println("Mejor(es) nota(s):");
        registro.mejoresNotas().forEach(n -> 
            System.out.println(n.getEstudiante().getNombre() + " " + 
                             n.getEstudiante().getPaterno() + " - " + 
                             n.getMateria() + ": " + n.getNotaFinal())
        );

        registro.eliminarMateria("Redes");

        registro.guardarEnJSON();
    }
}