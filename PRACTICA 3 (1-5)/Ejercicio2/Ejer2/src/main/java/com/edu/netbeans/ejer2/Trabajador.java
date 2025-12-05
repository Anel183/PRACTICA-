/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer2;
public class Trabajador {
    private String ci;
    private String nombre;
    private String cargo;
    private double salario;

    public Trabajador(String ci, String nombre, String cargo, double salario) {
        this.ci = ci;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCi() { return ci; }
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return ci + " " + nombre + " " + cargo + " " + salario;
    }
}