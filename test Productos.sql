package com.krakedev;

public class TestProducto {

    public static void main(String[] args) {

        // Crear variables
        Producto productoA;
        Producto productoB;
        Producto productoC;

        // Instanciar objetos
        productoA = new Producto();
        productoB = new Producto();
        productoC = new Producto();

        // Asignar valores (farmacia)
        productoA.nombre = "Paracetamol";
        productoA.descripcion = "Dolor y fiebre";
        productoA.precio = 1.50;
        productoA.stockActual = 100;

        productoB.nombre = "Ibuprofeno";
        productoB.descripcion = "Antiinflamatorio";
        productoB.precio = 2.00;
        productoB.stockActual = 80;

        productoC.nombre = "Jarabe";
        productoC.descripcion = "Para la tos";
        productoC.precio = 3.75;
        productoC.stockActual = 50;

        // Mostrar datos
        System.out.println("PRODUCTO A");
        System.out.println(productoA.nombre + " - " + productoA.descripcion + " - $" + productoA.precio + " - Stock: " + productoA.stockActual);

        System.out.println("\nPRODUCTO B");
        System.out.println(productoB.nombre + " - " + productoB.descripcion + " - $" + productoB.precio + " - Stock: " + productoB.stockActual);

        System.out.println("\nPRODUCTO C");
        System.out.println(productoC.nombre + " - " + productoC.descripcion + " - $" + productoC.precio + " - Stock: " + productoC.stockActual);
    }
}