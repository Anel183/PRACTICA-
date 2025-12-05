/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer2;

public class Ejer2 {
    public static void main(String[] args) {
        Empresa empresa = Empresa.cargar();

        if (empresa.trabajadores.isEmpty()) {
            empresa.agregarTrabajador(new Trabajador("1111", "Juan", "Gerente", 10000));
            empresa.agregarTrabajador(new Trabajador("2222", "Maria", "Secretaria", 4000));
            empresa.agregarTrabajador(new Trabajador("3333", "Carlos", "Contador", 7000));
            empresa.agregarTrabajador(new Trabajador("4444", "Ana", "Programadora", 12000));
            System.out.println("Datos de prueba creados");
        }

        empresa.listar();
        empresa.aumentarSalario("4444", 3000);
        System.out.println("Mayor salario: " + empresa.mayorSalario());
        System.out.println("Ordenados:");
        empresa.ordenarPorSalario().forEach(System.out::println);

        empresa.guardar();
    }
}