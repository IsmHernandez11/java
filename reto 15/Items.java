package com.cmc.repaso.entidades;

public class Item {
    private String nombre;
    private int productosActuales;
    private int productosVendidos;
    private int productosDevueltos;

    public Item(String nombre) {
        this.nombre = nombre;
    }

    public void setProductosActuales(int productosActuales) {
        this.productosActuales = productosActuales;
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Actuales: " + productosActuales);
        System.out.println("Vendidos: " + productosVendidos);
        System.out.println("Devueltos: " + productosDevueltos);
        System.out.println("-------------------------");
    }

    public void vender(int cantidad) {
        productosActuales -= cantidad;
        productosVendidos += cantidad;
    }

    public void devolver(int cantidad) {
        productosActuales += cantidad;
        productosVendidos -= cantidad;
        productosDevueltos += cantidad;
    }
}