package Herencia.Ejercicio7.ejer07;
class Persona {
    protected String nombre;
    protected String paterno;
    protected String materno;
    protected int edad;

    public Persona(String nombre, String paterno, String materno, int edad) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " " + paterno + " " + materno + ", Edad: " + edad);
    }

    public int getEdad() { return edad; }
}

class Docente extends Persona {
    private float sueldo;
    private String regProfesional;

    public Docente(String nombre, String paterno, String materno, int edad, float sueldo, String regProfesional) {
        super(nombre, paterno, materno, edad);
        this.sueldo = sueldo;
        this.regProfesional = regProfesional;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Sueldo: " + sueldo + ", Registro Profesional: " + regProfesional);
    }
}

class Estudiante extends Persona {
    private String ru;
    private String matricula;

    public Estudiante(String nombre, String paterno, String materno, int edad, String ru, String matricula) {
        super(nombre, paterno, materno, edad);
        this.ru = ru;
        this.matricula = matricula;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("RU: " + ru + ", Matricula: " + matricula);
    }

    public void modificarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
        System.out.println("Edad modificada a: " + nuevaEdad);
    }
}

public class ejer07 {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Carla", "Mamani", "Vargas", 20, "RU001", "MAT001");
        Estudiante est2 = new Estudiante("Cielo", "Lopez", "Choque", 22, "RU002", "MAT002");
        Docente doc = new Docente("Tom", "Sanchez", "Torres", 40, 5000.0f, "REG001");

        est1.mostrar();
        est2.mostrar();
        doc.mostrar();

        double promedio = (est1.getEdad() + est2.getEdad()) / 2.0;
        System.out.println("Promedio de edades de estudiantes: " + promedio);

        est1.modificarEdad(21);

        boolean mismoEdad = (est1.getEdad() == doc.getEdad()) || (est2.getEdad() == doc.getEdad());
        System.out.println("¿Algún estudiante tiene la misma edad que el docente? " + mismoEdad);
    }
}
