package Introduccion.Ejercicio5.ejer05;
public class ejer05 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Ana", "García", "López", 20, "123456");
        Persona p2 = new Persona("Luis", "García", "Martínez", 16, "789012");

        p1.mostrarDatos();
        p2.mostrarDatos();

        System.out.println(p1.getNombre() + " es mayor de edad: " + p1.mayorDeEdad());
        System.out.println(p2.getNombre() + " es mayor de edad: " + p2.mayorDeEdad());

        p2.modificarEdad(18);
        System.out.println("Nueva edad de " + p2.getNombre() + ": " + p2.getEdad());
        System.out.println(p2.getNombre() + " es mayor de edad: " + p2.mayorDeEdad());

        if (p1.getPaterno().equalsIgnoreCase(p2.getPaterno())) {
            System.out.println("Ambas personas tienen el mismo apellido paterno: " + p1.getPaterno());
        } else {
            System.out.println("Los apellidos paternos son diferentes.");
        }
    }
}

class Persona {
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    private String ci;

    public Persona(String nombre, String paterno, String materno, int edad, String ci) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        this.ci = ci;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " " + paterno + " " + materno);
        System.out.println("Edad: " + edad + " años");
        System.out.println("CI: " + ci);
        System.out.println("");
    }

    public boolean mayorDeEdad() {
        return edad >= 18;
    }

    public void modificarEdad(int nuevo) {
        if (nuevo > 0) {
            this.edad = nuevo;
        } else {
            System.out.println("Edad inválida.");
        }
    }

    public String getNombre() { return nombre; }
    public String getPaterno() { return paterno; }
    public String getMaterno() { return materno; }
    public int getEdad() { return edad; }
    public String getCi() { return ci; }
}

