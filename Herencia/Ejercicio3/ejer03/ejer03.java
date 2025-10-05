package Herencia.Ejercicio3.ejer03;
class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void desplazarse() {
        System.out.println(nombre + " se desplaza de una manera genérica.");
    }

    public String getNombre() { return nombre; }
}

class Leon extends Animal {
    public Leon(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + " camina majestuosamente por la sabana.");
    }
}

class Pinguino extends Animal {
    public Pinguino(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + " nada ágilmente en el agua o camina torpemente en tierra.");
    }
}

class Canguro extends Animal {
    public Canguro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + " salta con grandes zancadas.");
    }
}

public class ejer03 {
    public static void main(String[] args) {
        Animal[] animales = new Animal[3];
        animales[0] = new Leon("Simba", 5);
        animales[1] = new Pinguino("Skipper", 3);
        animales[2] = new Canguro("Kangoo", 4);

        for (Animal animal : animales) {
            animal.desplazarse();
        }
    }
}
