package com.krakedev;

public class TestAuto {

    public static void main(String[] args) {

        // Crear objetos
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        // Asignar valores
        auto1.marca = "Toyota";
        auto1.anio = 2020;
        auto1.precio = 20000;

        auto2.marca = "Chevrolet";
        auto2.anio = 2022;
        auto2.precio = 25000;

        // Mostrar datos
        System.out.println("AUTO 1");
        System.out.println("Marca: " + auto1.marca);
        System.out.println("Año: " + auto1.anio);
        System.out.println("Precio: " + auto1.precio);

        System.out.println("\nAUTO 2");
        System.out.println("Marca: " + auto2.marca);
        System.out.println("Año: " + auto2.anio);
        System.out.println("Precio: " + auto2.precio);
    }
}