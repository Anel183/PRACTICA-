/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer9;
public class Zoologico {
    private int id;
    private String nombre;
    private int nroAnimales = 0;
    private Animal[] animales = new Animal[30]; 

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNroAnimales() { return nroAnimales; }
    public Animal[] getAnimales() { return animales; }

    public void agregarAnimal(Animal a) {
        if (nroAnimales < 30) {
            animales[nroAnimales++] = a;
        }
    }

    public boolean estaVacio() {
        return nroAnimales == 0;
    }

    public int contarEspeciesDiferentes() {
        return (int) java.util.Arrays.stream(animales, 0, nroAnimales)
                .map(Animal::getEspecie)
                .distinct()
                .count();
    }


    public void vaciarHacia(Zoologico destino) {
        for (int i = 0; i < nroAnimales; i++) {
            destino.agregarAnimal(animales[i]);
        }
        nroAnimales = 0;
    }

    @Override
    public String toString() {
        return "Zoológico " + id + " - " + nombre + " (" + nroAnimales + " animales)";
    }
}