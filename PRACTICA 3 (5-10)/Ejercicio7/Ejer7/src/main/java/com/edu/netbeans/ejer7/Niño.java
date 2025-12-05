/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer7;
public class Niño extends Persona {
    private int carnet;
    private int edad;      // en meses
    private double peso;   // en kg
    private double talla;  // en cm

    public Niño(int carnet, String nombre, String apellidoPaterno, String apellidoMaterno,
                String ci, int edad, double peso, double talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.carnet = carnet;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getCarnet() { return carnet; }
    public int getEdad() { return edad; }
    public double getPeso() { return peso; }
    public double getTalla() { return talla; }

    @Override
    public String toString() {
        return carnet + " | " + super.toString() +
               " | Edad: " + edad + " meses | Peso: " + peso + "kg | Talla: " + talla + "cm";
    }
}