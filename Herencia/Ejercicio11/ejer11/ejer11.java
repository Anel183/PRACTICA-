package Herencia.Ejercicio11.ejer11;
interface Empleado {
    double getSueldo();
    int getAntiguedad();
}

interface Policia {
    String getGrado();
    String getDepartamento();
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
}

class JefePolicia extends Persona implements Empleado, Policia {
    private double sueldo;
    private int antiguedad;
    private String grado;
    private String departamento;
    private String division;
    private int numeroSubordinados;

    public JefePolicia(String nombre, int edad, double sueldo, int antiguedad, String grado, String departamento, String division, int numeroSubordinados) {
        super(nombre, edad);
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
        this.grado = grado;
        this.departamento = departamento;
        this.division = division;
        this.numeroSubordinados = numeroSubordinados;
    }

    @Override
    public double getSueldo() { return sueldo; }
    @Override
    public int getAntiguedad() { return antiguedad; }

    @Override
    public String getGrado() { return grado; }
    @Override
    public String getDepartamento() { return departamento; }

    public String getDivision() { return division; }
    public int getNumeroSubordinados() { return numeroSubordinados; }

    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Sueldo: " + getSueldo());
        System.out.println("Antigüedad: " + getAntiguedad() + " años");
        System.out.println("Grado: " + getGrado());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("División: " + getDivision());
        System.out.println("Número de Subordinados: " + getNumeroSubordinados());
        System.out.println();
    }
}

public class ejer11 {
    public static void main(String[] args) {
        JefePolicia jp1 = new JefePolicia("Maria Chavez", 45, 5000.0, 20, "Comisario", "Investigación", "Anti-Narcóticos", 50);
        JefePolicia jp2 = new JefePolicia("Camila Lopez", 50, 6000.0, 25, "Comisario General", "Seguridad", "Anti-Terrorismo", 100);

        System.out.println("Datos de JefePolicia 1:");
        jp1.mostrarDatos();

        System.out.println("Datos de JefePolicia 2:");
        jp2.mostrarDatos();

        if (jp1.getSueldo() > jp2.getSueldo()) {
            System.out.println("El que tiene mayor sueldo es: " + jp1.getNombre());
        } else if (jp2.getSueldo() > jp1.getSueldo()) {
            System.out.println("El que tiene mayor sueldo es: " + jp2.getNombre());
        } else {
            System.out.println("Ambos tienen el mismo sueldo.");
        }

        if (jp1.getGrado().equals(jp2.getGrado())) {
            System.out.println("Ambos tienen el mismo grado.");
        } else {
            System.out.println("No tienen el mismo grado.");
        }
    }
}