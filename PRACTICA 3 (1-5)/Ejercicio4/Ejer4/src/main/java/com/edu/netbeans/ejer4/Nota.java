/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer4;
public class Nota {
    private String materia;
    private double notaFinal;
    private Estudiante estudiante;

    public Nota(String materia, double notaFinal, Estudiante estudiante) {
        this.materia = materia;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    public String getMateria() { return materia; }
    public double getNotaFinal() { return notaFinal; }
    public Estudiante getEstudiante() { return estudiante; }

    @Override
    public String toString() {
        return estudiante.getRu() + " | " + estudiante.getNombre() + " " + estudiante.getPaterno() + 
               " | " + materia + " | Nota: " + notaFinal;
    }
}