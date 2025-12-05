/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer6;
public class Cliente {
    private int codCliente;
    private String ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, String ci, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() { return codCliente; }
    public String getNombreCompleto() { return nombre + " " + apellido; }

    @Override
    public String toString() {
        return codCliente + " - " + nombre + " " + apellido + " (CI: " + ci + ")";
    }
}