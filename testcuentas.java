package clearminds.cuentas.test;

import clearminds.cuentas.Cuenta;

public class TestCuenta {

    public static void main(String[] args) {

        // Cuenta 1
        Cuenta cuenta1 = new Cuenta("03476");
        cuenta1.setSaldo(675);

        // Cuenta 2
        Cuenta cuenta2 = new Cuenta("03476", "C", 98);

        // Cuenta 3
        Cuenta cuenta3 = new Cuenta("03476");
        cuenta3.setTipo("C");

        // Imprimir iniciales
        System.out.println("------Valores Iniciales------");
        cuenta1.imprimir();
        cuenta2.imprimir();
        cuenta3.imprimir();

        // Modificaciones
        cuenta1.setSaldo(444);
        cuenta3.setSaldo(567);
        cuenta2.setTipo("D");

        // Imprimir modificados
        System.out.println("------Valores Modificados------");
        cuenta1.imprimir();
        cuenta2.imprimir();
        cuenta3.imprimir();

        // Cuenta 4
        Cuenta cuenta4 = new Cuenta("0987");
        cuenta4.setTipo("A");
        cuenta4.setSaldo(10);

        // Cuenta 5
        Cuenta cuenta5 = new Cuenta("0557", "C", 10);

        // Cuenta 6
        Cuenta cuenta6 = new Cuenta("0666");
        cuenta6.setTipo("A");
        cuenta6.setSaldo(0);

        // Imprimir nuevas cuentas
        System.out.println("------Nuevas Cuentas------");
        cuenta4.imprimir();
        cuenta5.imprimir();
        cuenta6.imprimir();
    }
}