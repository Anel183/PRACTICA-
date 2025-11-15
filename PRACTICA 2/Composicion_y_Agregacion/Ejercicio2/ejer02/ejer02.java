package Composicion_y_Agregacion.Ejercicio2.ejer02;

import java.util.ArrayList;
class Empleado {
    public String nombre;
    public String cargo;
    public double sueldo;

    public Empleado(String nombre, String cargo, double sueldo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public void cambioSalarial(double nuevoSueldo) {
        this.sueldo = nuevoSueldo;
    }

    public String toString() {
        return "Empleado: " + nombre + ", Cargo: " + cargo + ", Sueldo: " + sueldo;
    }
}

class Departamento {
    public String nombre;
    public String area;
    public ArrayList<Empleado> empleados; 

    public Departamento(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
        this.empleados = new ArrayList<>();
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados del Departamento: " + nombre + "");
        if (empleados.isEmpty()) {
            System.out.println("  [No hay empleados]");
        } else {
            for (Empleado e : empleados) {
                System.out.println("  " + e);
            }
        }
        System.out.println("");
    }

    public void cambioSalarial(double nuevoSueldo) {
        for (Empleado e : empleados) {
            e.cambioSalarial(nuevoSueldo);
        }
    }

    public void agregarEmpleado(Empleado emp) {
        this.empleados.add(emp);
    }

    public void moverEmpleadosA(Departamento otro) {
        for (Empleado e : this.empleados) {
            otro.agregarEmpleado(e);
        }
        this.empleados.clear();
    }

    public boolean contieneEmpleado(Empleado emp) {
        return this.empleados.contains(emp);
    }

    public String toString() {
        return "Departamento: " + nombre + ", Área: " + area;
    }
}

public class ejer02 {
    public static void main(String[] args) {
        // a) Instanciar 2 departamentos
        Departamento depto1 = new Departamento("Recursos Humanos", "Administración");
        Departamento depto2 = new Departamento("Tecnología", "Informática");

        Empleado e1 = new Empleado("Ana López", "Analista", 2500.0);
        Empleado e2 = new Empleado("Carlos Ruiz", "Jefe de Área", 4500.0);
        Empleado e3 = new Empleado("María Gómez", "Asistente", 1800.0);
        Empleado e4 = new Empleado("Luis Torres", "Desarrollador", 3500.0);
        Empleado e5 = new Empleado("Sofía Díaz", "Coordinadora", 3000.0);

        depto1.agregarEmpleado(e1);
        depto1.agregarEmpleado(e2);
        depto1.agregarEmpleado(e3);
        depto1.agregarEmpleado(e4);
        depto1.agregarEmpleado(e5);

        System.out.println("\nESTADO INICIAL");
        depto1.mostrarEmpleados();
        depto2.mostrarEmpleados();

        System.out.println("\nMOSTRAR EMPLEADOS");
        depto1.mostrarEmpleados();

        System.out.println("\nCAMBIO SALARIAL EN DEPTO 1");
        depto1.cambioSalarial(4000.0);
        depto1.mostrarEmpleados();

        System.out.println("\nVERIFICACIÓN DE PERTENENCIA");
        boolean pertenece = depto2.contieneEmpleado(e1);
        System.out.println("¿" + e1.nombre + " pertenece al depto2? " + (pertenece ? "Sí" : "No"));

        System.out.println("\nMOVIENDO EMPLEADOS DE DEPTO1 A DEPTO2");
        depto1.moverEmpleadosA(depto2);

        System.out.println("\nESTADO FINAL");
        depto1.mostrarEmpleados();
        depto2.mostrarEmpleados();
    }
}
