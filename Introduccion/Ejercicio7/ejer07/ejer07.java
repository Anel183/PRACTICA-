package Introduccion.Ejercicio7.ejer07;
public class ejer07 {
    public static void main(String[] args) {
        // c) Crear dos mascotas
        Mascota m1 = new Mascota("Cesar");
        Mascota m2 = new Mascota("Toby");
        m1.mostrarEnergia();
        m2.mostrarEnergia();

        m1.alimentar();
        m2.alimentar();
        System.out.println("Después de alimentar:");
        m1.mostrarEnergia();
        m2.mostrarEnergia();

        m1.jugar();
        m2.jugar();
        System.out.println("Después de jugar:");
        m1.mostrarEnergia();
        m2.mostrarEnergia();
    }
}

class Mascota {
    private String nombre;
    private int energia;

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.energia = 50;
    }

    public void alimentar() {
        energia += 20;
        if (energia > 100) {
            energia = 100;
        }
        System.out.println(nombre + " ha sido alimentado.");
    }

    public void jugar() {
        energia -= 15;
        if (energia < 0) {
            energia = 0;
        }
        System.out.println(nombre + " ha jugado.");
    }

    public void mostrarEnergia() {
        System.out.println(nombre + " tiene " + energia + " de energía.");
    }
}

