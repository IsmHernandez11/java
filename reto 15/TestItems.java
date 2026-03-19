package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {
    public static void main(String[] args) {

        Item item1 = new Item("Laptop");
        item1.setProductosActuales(20);

        item1.imprimir();

        item1.vender(5);
        item1.imprimir();

        item1.devolver(2);
        item1.imprimir();

        // Otro producto
        Item item2 = new Item("Mouse");
        item2.setProductosActuales(50);

        item2.vender(10);
        item2.devolver(3);
        item2.imprimir();
    }
}