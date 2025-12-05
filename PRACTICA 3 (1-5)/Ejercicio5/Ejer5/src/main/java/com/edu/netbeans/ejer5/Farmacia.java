/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer5;
import java.util.*;

public class Farmacia {
    private int numeroSucursal;
    private String direccion;
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Farmacia(int numeroSucursal, String direccion) {
        this.numeroSucursal = numeroSucursal;
        this.direccion = direccion;
    }

    public int getNumeroSucursal() { return numeroSucursal; }
    public String getDireccion() { return direccion; }
    public List<Medicamento> getMedicamentos() { return medicamentos; }

    public void agregarMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public List<Medicamento> extraerPorTipo(String tipo) {
        List<Medicamento> extraidos = new ArrayList<>();
        medicamentos.removeIf(m -> {
            if (m.getTipo().equalsIgnoreCase(tipo)) {
                extraidos.add(m);
                return true;
            }
            return false;
        });
        return extraidos;
    }

    @Override
    public String toString() {
        return "Sucursal " + numeroSucursal + " - " + direccion;
    }
}