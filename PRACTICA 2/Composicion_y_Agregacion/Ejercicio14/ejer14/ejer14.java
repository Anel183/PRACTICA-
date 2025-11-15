package Composicion_y_Agregacion.Ejercicio14.ejer14;

import java.util.ArrayList;
class Empleado {
    String nombre;
    String puesto;
    double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre +"  Puesto: " + puesto +"  Salario: Bs. " + String.format("%.2f", salario);
    }
}

class Empresa {
    String nombre;
    ArrayList<Empleado> empleados; 

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado emp) {
        if (empleados.contains(emp)) {
            System.out.println("El empleado " + emp.nombre + " ya está en la empresa.");
        } else {
            empleados.add(emp);
            System.out.println("Empleado agregado: " + emp.nombre);
        }
    }
    public void mostrarInformacion() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           EMPRESA: " + nombre.toUpperCase());
        System.out.println("=".repeat(60));
        if (empleados.isEmpty()) {
            System.out.println("  No hay empleados registrados.");
        } else {
            System.out.println("  Total empleados: " + empleados.size());
            for (Empleado e : empleados) {
                System.out.println("  → " + e);
            }
        }
        System.out.println("=".repeat(60) + "\n");
    }

    public Empleado buscarEmpleado(String nombre) {
        for (Empleado e : empleados) {
            if (e.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Empleado encontrado: " + e);
                return e;
            }
        }
        System.out.println("No se encontró empleado con nombre: " + nombre);
        return null;
    }
    public boolean eliminarEmpleado(String nombre) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Empleado eliminado: " + empleados.get(i).nombre);
                empleados.remove(i);
                return true;
            }
        }
        System.out.println("No se encontró empleado para eliminar: " + nombre);
        return false;
    }

    public double calcularPromedioSalarial() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para calcular promedio.");
            return 0;
        }
        double suma = 0;
        for (Empleado e : empleados) {
            suma += e.salario;
        }
        double promedio = suma / empleados.size();
        System.out.println("Promedio salarial: Bs. " + String.format("%.2f", promedio));
        return promedio;
    }

    public void listarEmpleadosSalarioMayor(double valor) {
        System.out.println("\nEmpleados con salario > Bs. " + String.format("%.2f", valor) + ":");
        boolean encontrado = false;
        for (Empleado e : empleados) {
            if (e.salario > valor) {
                System.out.println("  → " + e);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("  No hay empleados con salario mayor a Bs. " + String.format("%.2f", valor));
        }
        System.out.println();
    }
}

public class ejer14 {
    public static void main(String[] args) {

        Empresa empresa = new Empresa("TechSolutions S.A.");

        Empleado e1 = new Empleado("Juan Pérez", "Desarrollador", 8500.00);
        Empleado e2 = new Empleado("María López", "Diseñadora UX", 7200.50);
        Empleado e3 = new Empleado("Carlos Ruiz", "Gerente de Proyectos", 12000.00);
        Empleado e4 = new Empleado("Ana Gómez", "Analista", 6800.00);
        Empleado e5 = new Empleado("Luis Torres", "Desarrollador Senior", 9500.00);

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);
        empresa.agregarEmpleado(e4);
        empresa.agregarEmpleado(e5);
        empresa.mostrarInformacion();
        System.out.println("c) Búsqueda de empleado:");
        empresa.buscarEmpleado("María López");
        empresa.buscarEmpleado("Pedro Sánchez"); 
        System.out.println("\nd) Eliminación de empleado:");
        empresa.eliminarEmpleado("Carlos Ruiz");
        empresa.eliminarEmpleado("Pedro Sánchez"); 
        empresa.mostrarInformacion();
        System.out.println("e) Cálculo de promedio salarial:");
        empresa.calcularPromedioSalarial();
        System.out.println("e) Empleados con salario > 8000:");
        empresa.listarEmpleadosSalarioMayor(8000.00);

        Empleado independiente = new Empleado("Sofía Díaz", "Consultora", 10000.00);
        System.out.println("Empleado independiente (no en la empresa): " + independiente);
    }
}
