package Manejo_Excepciones.Ejercicio4.ejer04;

import java.util.ArrayList;
class Estudiante {
    String ru;
    String nombre;
    String paterno;
    String materno;
    int edad;

    public Estudiante(String ru, String nombre, String paterno, String materno, int edad) {
        if (ru == null || ru.isEmpty()) throw new IllegalArgumentException("RU no puede estar vacío.");
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre no puede estar vacío.");
        if (paterno == null || paterno.isEmpty()) throw new IllegalArgumentException("Paterno no puede estar vacío.");
        if (materno == null || materno.isEmpty()) throw new IllegalArgumentException("Materno no puede estar vacío.");
        if (edad <= 0) throw new IllegalArgumentException("Edad debe ser mayor a 0.");

        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "RU: " + ru + " | " + nombre + " " + paterno + " " + materno + " | Edad: " + edad;
    }
}
class Nota {
    String materia;
    double notaFinal;
    Estudiante estudiante;

    public Nota(String materia, double notaFinal, Estudiante estudiante) {
        if (materia == null || materia.isEmpty()) throw new IllegalArgumentException("Materia no puede estar vacía.");
        if (notaFinal < 0 || notaFinal > 100) throw new IllegalArgumentException("Nota debe estar entre 0 y 100.");
        if (estudiante == null) throw new IllegalArgumentException("Estudiante no puede ser nulo.");

        this.materia = materia;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return estudiante + " | Materia: " + materia + " | Nota: " + notaFinal;
    }
}

class ArchiNota {
    String nombreArchi;
    ArrayList<Nota> notas;

    public ArchiNota(String nombreArchi) {
        if (nombreArchi == null || nombreArchi.isEmpty()) throw new IllegalArgumentException("Nombre del archivo no puede estar vacío.");
        this.nombreArchi = nombreArchi;
        this.notas = new ArrayList<>();
    }
    public void agregarNota(Estudiante estudiante, String materia, double notaFinal) {
        try {
            Nota nota = new Nota(materia, notaFinal, estudiante);
            notas.add(nota);
            System.out.println("Nota agregada: " + estudiante.nombre + " en " + materia);
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR al agregar nota: " + e.getMessage());
        }
    }
    public double calcularPromedioGeneral() {
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return 0.0;
        }
        double suma = 0;
        for (Nota n : notas) {
            suma += n.notaFinal;
        }
        double promedio = suma / notas.size();
        System.out.println("Promedio general de notas: " + String.format("%.2f", promedio));
        return promedio;
    }
    public ArrayList<Estudiante> obtenerMejorNota() {
        if (notas.isEmpty()) {
            System.out.println("No hay notas para comparar.");
            return new ArrayList<>();
        }

        double mejor = -1;
        ArrayList<Estudiante> mejores = new ArrayList<>();

        for (Nota n : notas) {
            if (n.notaFinal > mejor) {
                mejor = n.notaFinal;
                mejores.clear();
                mejores.add(n.estudiante);
            } else if (n.notaFinal == mejor) {
                mejores.add(n.estudiante);
            }
        }

        System.out.println("Mejor nota: " + mejor + " (obtenida por " + mejores.size() + " estudiante(s))");
        for (Estudiante e : mejores) {
            System.out.println("  → " + e);
        }
        return mejores;
    }
    public void eliminarPorMateria(String materia) {
        if (materia == null || materia.isEmpty()) {
            System.out.println("Materia no válida para eliminar.");
            return;
        }

        int eliminados = 0;
        for (int i = notas.size() - 1; i >= 0; i--) {
            if (notas.get(i).materia.equalsIgnoreCase(materia)) {
                System.out.println("Eliminando nota en " + materia + ": " + notas.get(i).estudiante.nombre);
                notas.remove(i);
                eliminados++;
            }
        }

        if (eliminados == 0) {
            System.out.println("No se encontraron notas en la materia: " + materia);
        } else {
            System.out.println("Se eliminaron " + eliminados + " nota(s) de la materia '" + materia + "'.");
        }
    }

    public void mostrarNotas() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("            ARCHIVO DE NOTAS: " + nombreArchi.toUpperCase());
        System.out.println("=".repeat(80));
        if (notas.isEmpty()) {
            System.out.println("  No hay notas registradas.");
        } else {
            System.out.println("  Total de notas: " + notas.size());
            for (Nota n : notas) {
                System.out.println("   " + n);
            }
        }
        System.out.println("=".repeat(80) + "\n");
    }
}

public class ejer04 {
    public static void main(String[] args) {
        ArchiNota archivo = new ArchiNota("Notas_2025.txt");
        Estudiante e1 = new Estudiante("2023001", "Juan", "Pérez", "Gómez", 20);
        Estudiante e2 = new Estudiante("2023002", "María", "López", "Ríos", 19);
        Estudiante e3 = new Estudiante("2023003", "Carlos", "Torres", "Mendoza", 21);
        Estudiante e4 = new Estudiante("2023004", "Ana", "Vargas", "Suárez", 18);

        archivo.agregarNota(e1, "Programación", 95.5);
        archivo.agregarNota(e2, "Programación", 88.0);
        archivo.agregarNota(e3, "Programación", 92.0);
        archivo.agregarNota(e1, "Base de Datos", 78.0);
        archivo.agregarNota(e4, "Programación", 99.0);
        archivo.agregarNota(e2, "Redes", 85.5);
        try {
            archivo.agregarNota(e3, "Cálculo", -5); 
        } catch (Exception ex) {
        }
        archivo.mostrarNotas();
        System.out.println("c) Cálculo del promedio general:");
        archivo.calcularPromedioGeneral();
        System.out.println("\nd) Estudiante(s) con la mejor nota:");
        archivo.obtenerMejorNota();

        System.out.println("\ne) Eliminando todos los estudiantes de 'Programación':");
        archivo.eliminarPorMateria("Programación");
        archivo.mostrarNotas();
        try {
            Estudiante invalido = new Estudiante("", "Pedro", "Ruiz", "Díaz", 0);
        } catch (IllegalArgumentException e) {
            System.err.println("EXCEPCIÓN capturada: " + e.getMessage());
        }
    }
}
