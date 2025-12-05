/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer9;
public class Ejer9 {
    public static void main(String[] args) {
        ArchZoo arch = ArchZoo.cargar();  
        if (arch.zoologicos.isEmpty()) {
            Zoologico z1 = new Zoologico(1, "Zoo La Paz");
            Zoologico z2 = new Zoologico(2, "Zoo Santa Cruz");
            Zoologico z3 = new Zoologico(3, "Zoo Cochabamba");
            Zoologico z4 = new Zoologico(4, "Zoo Vacío");

            z1.agregarAnimal(new Animal("León", "Simba", 3));
            z1.agregarAnimal(new Animal("Tigre", "Rajah", 2));
            z1.agregarAnimal(new Animal("Oso", "Baloo", 1));

            z2.agregarAnimal(new Animal("León", "Mufasa", 2));
            z2.agregarAnimal(new Animal("Jirafa", "Melman", 4));
            z2.agregarAnimal(new Animal("Cocodrilo", "Coco", 5));

            arch.crear(z1);
            arch.crear(z2);
            arch.crear(z3);
            arch.crear(z4);
            System.out.println("Datos de prueba creados\n");
        }

        arch.listar();
        System.out.println();

        arch.zoologicosMayorVariedad();
        System.out.println();

        arch.eliminarZoologicosVacios();
        System.out.println();

        arch.animalesDeEspecie("León");
        System.out.println();

        arch.moverAnimales(1, 2);
        System.out.println();

        arch.guardar();
    }
}