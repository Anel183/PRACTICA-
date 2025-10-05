package Herencia.Ejercicio13.ejer13;

abstract class Empleado {
    protected String nombre;
    protected float sueldomes;

    public Empleado(String nombre, float sueldomes) {
        this.nombre = nombre;
        this.sueldomes = sueldomes;
    }

    public abstract float sueldoTotal();

    public String getNombre() { return nombre; }
    public float getSueldomes() { return sueldomes; }
}

class Administrativo extends Empleado {
    private String cargo;

    public Administrativo(String nombre, float sueldomes, String cargo) {
        super(nombre, sueldomes);
        this.cargo = cargo;
    }

    @Override
    public float sueldoTotal() {
        return sueldomes;
    }
}

class Chef extends Empleado {
    private int horaExtra;
    private String tipo;
    private float sueldoHora;

    public Chef(String nombre, float sueldomes, int horaExtra, String tipo, float sueldoHora) {
        super(nombre, sueldomes);
        this.horaExtra = horaExtra;
        this.tipo = tipo;
        this.sueldoHora = sueldoHora;
    }

    @Override
    public float sueldoTotal() {
        return sueldomes + (horaExtra * sueldoHora);
    }
}

class Mesero extends Empleado {
    private double propina;
    private int horaExtra;
    private float sueldoHora;

    public Mesero(String nombre, float sueldomes, double propina, int horaExtra, float sueldoHora) {
        super(nombre, sueldomes);
        this.propina = propina;
        this.horaExtra = horaExtra;
        this.sueldoHora = sueldoHora;
    }

    @Override
    public float sueldoTotal() {
        return sueldomes + (horaExtra * sueldoHora) + (float) propina;
    }
}

public class ejer13 {
    public static void main(String[] args) {
        Chef chef = new Chef("Remy", 2000.0f, 10, "Principal", 15.0f);
        Mesero mesero1 = new Mesero("Linguini", 1000.0f, 200.0, 5, 10.0f);
        Mesero mesero2 = new Mesero("Colette", 1000.0f, 150.0, 8, 10.0f);
        Administrativo admin1 = new Administrativo("Skinner", 1500.0f, "Gerente");
        Administrativo admin2 = new Administrativo("Ego", 1200.0f, "Contador");

        float X = 1000.0f;
        System.out.println("Empleados con sueldomes = " + X + ":");
        if (mesero1.getSueldomes() == X) System.out.println(mesero1.getNombre());
        if (mesero2.getSueldomes() == X) System.out.println(mesero2.getNombre());

        System.out.println("\nSueldos totales:");
        System.out.println(chef.getNombre() + ": " + chef.sueldoTotal());
        System.out.println(mesero1.getNombre() + ": " + mesero1.sueldoTotal());
        System.out.println(mesero2.getNombre() + ": " + mesero2.sueldoTotal());
        System.out.println(admin1.getNombre() + ": " + admin1.sueldoTotal());
        System.out.println(admin2.getNombre() + ": " + admin2.sueldoTotal());
    }
}