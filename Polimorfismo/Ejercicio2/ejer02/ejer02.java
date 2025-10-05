package Polimorfismo.Ejercicio2.ejer02;

import java.util.*;
class Videojuego {
    private String nombre;
    private String plataforma;
    private int cantidadJugadores;
    public Videojuego(String nombre, String plataforma, int cantidadJugadores) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.cantidadJugadores = cantidadJugadores;
    }
    public Videojuego(String nombre, String plataforma) {
        this(nombre, plataforma, 0);
    }
    public Videojuego(String nombre) {
        this(nombre, "Desconocida", 0);
    }

    public void agregarJugadores() {
        this.cantidadJugadores++;
        System.out.println("Se agregó 1 jugador. Total: " + cantidadJugadores);
    }
    public void agregarJugadores(int cantidad) {
        this.cantidadJugadores += cantidad;
        System.out.println("Se agregaron " + cantidad + " jugadores. Total: " + cantidadJugadores);
    }

    public String getNombre() { return nombre; }
    public String getPlataforma() { return plataforma; }
    public int getCantidadJugadores() { return cantidadJugadores; }

    @Override
    public String toString() {
        return "Videojuego(" +
                "nombre='" + nombre + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", cantidadJugadores=" + cantidadJugadores +
                ')';
    }
}

public class ejer02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Videojuego juego1 = new Videojuego("The Legend of Zelda", "Nintendo Switch", 1);
        Videojuego juego2 = new Videojuego("Minecraft", "PC");    
        Videojuego juego3 = new Videojuego("Pac-Man");           

        System.out.println(juego1);
        System.out.println(juego2);
        System.out.println(juego3);

        juego1.agregarJugadores(); 
        juego2.agregarJugadores(3); 

        System.out.print("Ingresa cantidad de jugadores para " + juego3.getNombre() + ": ");
        int cant = sc.nextInt();
        juego3.agregarJugadores(cant);

        System.out.println("\n--- Estado final ---");
        System.out.println(juego1);
        System.out.println(juego2);
        System.out.println(juego3);

        sc.close();
    }
}
