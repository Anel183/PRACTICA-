/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.netbeans.ejer6;

import java.util.*;

public class ArchLibro {
    private String nomArchLibro;
    private List<Libro> libros = new ArrayList<>();

    public ArchLibro(String nomArchLibro) {
        this.nomArchLibro = nomArchLibro;
    }

    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    public List<Libro> getLibros() { return libros; }

    public Libro buscarLibro(int cod) {
        return libros.stream().filter(l -> l.getCodLibro() == cod).findFirst().orElse(null);
    }
}