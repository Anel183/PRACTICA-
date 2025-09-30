package Polimorfismo.Ejercicio3.ejer03;

import java.util.*;
class Matriz {
    private float[][] matriz;
    public Matriz() {
        matriz = new float[10][10];
        for (int i = 0; i < 10; i++) {
            matriz[i][i] = 1.0f;
        }
    }

    public Matriz(float[][] datos) {
        matriz = new float[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = datos[i][j];
            }
        }
    }

    public Matriz sumar(Matriz otra) {
        float[][] resultado = new float[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                resultado[i][j] = this.matriz[i][j] + otra.matriz[i][j];
            }
        }
        return new Matriz(resultado);
    }

    public Matriz restar(Matriz otra) {
        float[][] resultado = new float[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                resultado[i][j] = this.matriz[i][j] - otra.matriz[i][j];
            }
        }
        return new Matriz(resultado);
    }

    public boolean igual(Matriz otra) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.matriz[i][j] != otra.matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class ejer03 {
    public static void main(String[] args) {

        Matriz identidad = new Matriz();
        System.out.println("Matriz identidad:");
        identidad.mostrar();

        float[][] datos = new float[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(datos[i], 2.0f);
        }
        Matriz personalizada = new Matriz(datos);
        System.out.println("Matriz personalizada:");
        personalizada.mostrar();

        Matriz suma = identidad.sumar(personalizada);
        System.out.println("Suma:");
        suma.mostrar();

        Matriz resta = personalizada.restar(identidad);
        System.out.println("Resta:");
        resta.mostrar();

        System.out.println("¿Identidad = Personalizada?: "
                + identidad.igual(personalizada));
        System.out.println("¿Suma?: "
                + suma.igual(suma));
    }
}

