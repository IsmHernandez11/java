package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {
    public static void main(String[] args) {
        Validacion val = new Validacion();

        System.out.println(val.validarMonto(10));  // true
        System.out.println(val.validarMonto(-5));  // false
    }
}