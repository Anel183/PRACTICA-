/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer6;
import java.util.*;

public class ArchCliente {
    private String nomArchCliente;
    private List<Cliente> clientes = new ArrayList<>();

    public ArchCliente(String nomArchCliente) {
        this.nomArchCliente = nomArchCliente;
    }

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public List<Cliente> getClientes() { return clientes; }

    public Cliente buscarCliente(int cod) {
        return clientes.stream().filter(c -> c.getCodCliente() == cod).findFirst().orElse(null);
    }
}