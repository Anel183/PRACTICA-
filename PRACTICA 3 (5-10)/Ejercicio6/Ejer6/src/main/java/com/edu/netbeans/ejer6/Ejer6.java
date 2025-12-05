/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer6;
public class Ejer6 {
    public static void main(String[] args) {
        ArchLibro archLibro = new ArchLibro("LibrosUMSA");
        ArchCliente archCliente = new ArchCliente("ClientesUMSA");
        ArchPrestamo archPrestamo = ArchPrestamo.cargarDesdeJSON(archLibro, archCliente);

        if (archLibro.getLibros().isEmpty()) {
            archLibro.agregarLibro(new Libro(1001, "El Principito", 45.0));
            archLibro.agregarLibro(new Libro(1002, "Cien Años de Soledad", 80.0));
            archLibro.agregarLibro(new Libro(1003, "1984", 60.0));
            archLibro.agregarLibro(new Libro(1004, "Don Quijote", 120.0));
            archLibro.agregarLibro(new Libro(1005, "Harry Potter", 90.0));

            archCliente.agregarCliente(new Cliente(1, "111111", "Juan", "Perez"));
            archCliente.agregarCliente(new Cliente(2, "222222", "Maria", "Lopez"));
            archCliente.agregarCliente(new Cliente(3, "333333", "Carlos", "Mamani"));

            archPrestamo.agregarPrestamo(new Prestamo(1, 1001, "2025-10-01", 2));
            archPrestamo.agregarPrestamo(new Prestamo(2, 1001, "2025-10-05", 1));
            archPrestamo.agregarPrestamo(new Prestamo(1, 1002, "2025-10-10", 1));
            archPrestamo.agregarPrestamo(new Prestamo(3, 1005, "2025-11-01", 3));
            System.out.println("Datos de prueba creados\n");
        }

        archPrestamo.librosEntrePrecios(50, 100);
        System.out.println();
        archPrestamo.ingresoTotalPorLibro(1001);
        System.out.println();
        archPrestamo.librosNuncaPrestados();
        System.out.println();
        archPrestamo.clientesQuePrestaronLibro(1001);
        System.out.println();
        archPrestamo.libroMasPrestado();
        System.out.println();
        archPrestamo.clienteConMasPrestamos();
        System.out.println();
        archPrestamo.guardarEnJSON();
    }
}