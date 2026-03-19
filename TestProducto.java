package com.krakedev.demo.test;

import com.krakedev.demo.Producto;

public class TestProducto {

    public static void main(String[] args) {

        // Crear objeto usando constructor
        Producto p = new Producto(1, "Laptop");

        // Modificar descripción y peso
        p.setDescripcion("Laptop gamer");
        p.setPeso(2.5);

        // Mostrar valores
        System.out.println("Codigo: " + p.getCodigo());
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Descripcion: " + p.getDescripcion());
        System.out.println("Peso: " + p.getPeso());
    }
}