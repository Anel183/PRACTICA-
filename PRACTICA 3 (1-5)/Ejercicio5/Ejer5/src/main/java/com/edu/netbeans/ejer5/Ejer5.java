/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer5;

public class Ejer5 {
    public static void main(String[] args) {
        ArchFarmacia arch = ArchFarmacia.cargarDesdeJSON();

        if (arch.getFarmacias().isEmpty()) {
            Farmacia f1 = new Farmacia(101, "Av. Busch #123");
            Farmacia f2 = new Farmacia(102, "Zona Sur, Calle 5");
            Farmacia f3 = new Farmacia(103, "Miraflores, Av. 16 de Julio");

            f1.agregarMedicamento(new Medicamento("Tapsin", "Tos", 25.0));
            f1.agregarMedicamento(new Medicamento("Jarabe Tos", "Tos", 18.0));
            f1.agregarMedicamento(new Medicamento("Paracetamol", "Fiebre", 10.0));

            f2.agregarMedicamento(new Medicamento("Tapsin", "Tos", 25.0));
            f2.agregarMedicamento(new Medicamento("Ibuprofeno", "Dolor", 15.0));

            f3.agregarMedicamento(new Medicamento("Aspirina", "Dolor", 12.0));

            arch.agregarFarmacia(f1);
            arch.agregarFarmacia(f2);
            arch.agregarFarmacia(f3);
            System.out.println("Datos de prueba creados\n");
        }

        arch.medicamentosTosEnSucursal(101);
        System.out.println();
        arch.sucursalesConTapsin();
        System.out.println();
        arch.medicamentosPorTipo("Tos");
        System.out.println();
        arch.ordenarPorDireccion();
        System.out.println();
        arch.moverMedicamentos("Tos", 101, 103);
        System.out.println();
        arch.guardarEnJSON();
    }
}