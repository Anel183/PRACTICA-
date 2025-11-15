package Composicion_y_Agregacion.Ejercicio8.ejer08;

import java.util.ArrayList;
import java.util.Scanner;
class Persona {
    String nombre;
    int edad;
    String ci;

    public Persona(String nombre, int edad, String ci) {
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
    }

    @Override
    public String toString() {
        return nombre + " (CI: " + ci + ", Edad: " + edad + ")";
    }
}

class Bailarin extends Persona {
    Fraternidad fraternidad;
    Facultad facultad;

    public Bailarin(String nombre, int edad, String ci) {
        super(nombre, edad, ci);
    }

    public void asignarFraternidadYFacultad(Fraternidad fraternidad, Facultad facultad) {
        this.fraternidad = fraternidad;
        this.facultad = facultad;
        fraternidad.agregarBailarin(this);
        facultad.agregarBailarin(this);
    }

    @Override
    public String toString() {
        return "Bailarin: " + super.toString() + " | Fraternidad: " + fraternidad.nombre + " | Facultad: " + facultad.nombre;
    }
}

class Encargado extends Persona {
    Fraternidad fraternidad;

    public Encargado(String nombre, int edad, String ci) {
        super(nombre, edad, ci);
    }

    public void asignarFraternidad(Fraternidad fraternidad) {
        this.fraternidad = fraternidad;
        fraternidad.encargado = this;
    }

    @Override
    public String toString() {
        return "Encargado: " + super.toString() +" de la fraternidad " + fraternidad.nombre;
    }
}
class Fraternidad {
    String nombre;
    Encargado encargado;
    ArrayList<Bailarin> bailarines;

    public Fraternidad(String nombre) {
        this.nombre = nombre;
        this.bailarines = new ArrayList<>();
    }

    public void agregarBailarin(Bailarin bailarin) {
        if (bailarines.contains(bailarin)) {
            System.out.println("ERROR: " + bailarin.nombre + " ya pertenece a esta fraternidad.");
            return;
        }
        bailarines.add(bailarin);
    }

    public void mostrarMiembros() {
        System.out.println("\n FRATERNIDAD: " + nombre + "");
        System.out.println("Encargado: " + encargado);
        System.out.println("Bailarines (" + bailarines.size() + "):");
        for (Bailarin b : bailarines) {
            System.out.println("  → " + b.nombre + " (" + b.facultad.nombre + ")");
        }
        System.out.println("---------------------------\n");
    }
}
class Facultad {
    String nombre;
    ArrayList<Bailarin> bailarines;

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.bailarines = new ArrayList<>();
    }

    public void agregarBailarin(Bailarin bailarin) {
        bailarines.add(bailarin);
    }

    public void mostrarBailarines() {
        System.out.println("\nFACULTAD: " + nombre + "");
        System.out.println("Total bailarines: " + bailarines.size());
        for (Bailarin b : bailarines) {
            System.out.println("  • " + b.nombre + " - " + b.fraternidad.nombre);
        }
        System.out.println("--------------------------------\n");
    }
}
public class ejer08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Facultad f1 = new Facultad("Ingeniería Informática");
        Facultad f2 = new Facultad("Arquitectura");

        Fraternidad frat1 = new Fraternidad("Los Tunche");
        Fraternidad frat2 = new Fraternidad("Tawa Tawa");

        Encargado enc1 = new Encargado("Carlos Mendoza", 28, "9876543");
        Encargado enc2 = new Encargado("Laura Vargas", 26, "8765432");
        enc1.asignarFraternidad(frat1);
        enc2.asignarFraternidad(frat2);

        Bailarin b1 = new Bailarin("Juan Pérez", 20, "1111111");
        Bailarin b2 = new Bailarin("María Gómez", 19, "2222222");
        Bailarin b3 = new Bailarin("Luis Torres", 21, "3333333");
        Bailarin b4 = new Bailarin("Ana López", 20, "4444444");
        Bailarin b5 = new Bailarin("Pedro Sánchez", 22, "5555555");

        b1.asignarFraternidadYFacultad(frat1, f1);
        b2.asignarFraternidadYFacultad(frat1, f1);
        b3.asignarFraternidadYFacultad(frat1, f2);
        b4.asignarFraternidadYFacultad(frat2, f2);
        b5.asignarFraternidadYFacultad(frat2, f1);

        System.out.println("\nIntentando duplicar a Juan en Tawa Tawa...");
        b1.asignarFraternidadYFacultad(frat2, f1);  

        System.out.println("\n" + "=".repeat(60));
        System.out.println("        SISTEMA DE ENTRADA UNIVERSITARIA 2025");
        System.out.println("=".repeat(60));

        frat1.mostrarMiembros();
        frat2.mostrarMiembros();

        f1.mostrarBailarines();
        f2.mostrarBailarines();

        System.out.println("Edades de los participantes:");
        ArrayList<Bailarin> todos = new ArrayList<>();
        todos.add(b1); todos.add(b2); todos.add(b3); todos.add(b4); todos.add(b5);
        for (Bailarin b : todos) {
            System.out.println("  → " + b.nombre + ": " + b.edad + " años");
        }

        sc.close();
    }
}