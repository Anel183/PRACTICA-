/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer1;

public class Charango {
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas = new boolean[10]; 

    public Charango(String material, int nroCuerdas) {
        this.material = material;
        this.nroCuerdas = Math.min(nroCuerdas, 10);
        for (int i = 0; i < 10; i++) {
            cuerdas[i] = i < this.nroCuerdas;
        }
    }

    public boolean tieneMasDe6Rotas() {
        int rotas = 0;
        for (boolean c : cuerdas) if (!c) rotas++;
        return rotas > 6;
    }

    public boolean tiene10Cuerdas() {
        return nroCuerdas == 10;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        int rotas = 0;
        for (boolean c : cuerdas) if (!c) rotas++;
        return String.format("Charango Material=%-12s Cuerdas buenas=%2d/10  Rotas=%d",
                material, nroCuerdas, rotas);
    }
}