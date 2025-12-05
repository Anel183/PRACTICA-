/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.netbeans.ejer8;
public class Ejer8 {
    public static void main(String[] args) {
        ArchAlimento refri = ArchAlimento.cargar(); 

        if (refri.alimentos.isEmpty()) {
            refri.crear(new Alimento("Leche", 2, "05/12/2025", "Lácteo"));
            refri.crear(new Alimento("Carne", 1, "01/12/2025", "Carne"));
            refri.crear(new Alimento("Yogurt", 6, "10/12/2025", "Lácteo"));
            refri.crear(new Alimento("Queso", 0, "15/11/2025", "Lácteo"));
            refri.crear(new Alimento("Manzana", 10, "20/12/2025", "Fruta"));
            System.out.println("Datos de prueba creados\n");
        }

        refri.listar();
        System.out.println();

        refri.caducadosAntesDe("08/12/2025");
        System.out.println();

        refri.eliminarCantidadCero();
        System.out.println();

        refri.alimentosVencidos();
        System.out.println();

        refri.modificarPorNombre("Leche", 5);
        refri.eliminarPorNombre("Carne");
        System.out.println();

        refri.alimentoConMasCantidad();
        System.out.println();

        refri.guardar();
    }
}