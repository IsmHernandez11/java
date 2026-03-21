package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {

    private Celda celda1;
    private Celda celda2;
    private Celda celda3;
    private Celda celda4;
    private double saldo;

    public MaquinaDulces() {
    }

    // Configurar celdas
    public void configurarMaquina(String c1, String c2, String c3, String c4) {
        celda1 = new Celda(c1);
        celda2 = new Celda(c2);
        celda3 = new Celda(c3);
        celda4 = new Celda(c4);
    }

    public void mostrarConfiguracion() {
        System.out.println(celda1.getCodigo());
        System.out.println(celda2.getCodigo());
        System.out.println(celda3.getCodigo());
        System.out.println(celda4.getCodigo());
    }

    public Celda buscarCelda(String codigo) {
        if (celda1 != null && celda1.getCodigo().equals(codigo)) return celda1;
        if (celda2 != null && celda2.getCodigo().equals(codigo)) return celda2;
        if (celda3 != null && celda3.getCodigo().equals(codigo)) return celda3;
        if (celda4 != null && celda4.getCodigo().equals(codigo)) return celda4;
        return null;
    }

    public void cargarProducto(Producto producto, String codigoCelda, int stock) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null) {
            celda.ingresarProducto(producto, stock);
        }
    }

    public void mostrarProductos() {
        mostrarCelda(celda1);
        mostrarCelda(celda2);
        mostrarCelda(celda3);
        mostrarCelda(celda4);
        System.out.println("Saldo: " + saldo);
    }

    private void mostrarCelda(Celda c) {
        if (c != null && c.getProducto() != null) {
            System.out.println("CELDA: " + c.getCodigo());
            System.out.println("Nombre Producto: " + c.getProducto().getNombre());
            System.out.println("Precio Producto: " + c.getProducto().getPrecio());
            System.out.println("Codigo Producto: " + c.getProducto().getCodigo());
            System.out.println("STOCK: " + c.getStock());
            System.out.println("****************************");
        }
    }

    public Producto buscarProductoEnCelda(String codigo) {
        Celda c = buscarCelda(codigo);
        if (c != null) {
            return c.getProducto();
        }
        return null;
    }

    public double consultarPrecio(String codigo) {
        Producto p = buscarProductoEnCelda(codigo);
        if (p != null) {
            return p.getPrecio();
        }
        return 0;
    }

    public Celda buscarCeldaProducto(String codigoProducto) {
        if (celda1 != null && celda1.getProducto() != null &&
            celda1.getProducto().getCodigo().equals(codigoProducto)) return celda1;

        if (celda2 != null && celda2.getProducto() != null &&
            celda2.getProducto().getCodigo().equals(codigoProducto)) return celda2;

        if (celda3 != null && celda3.getProducto() != null &&
            celda3.getProducto().getCodigo().equals(codigoProducto)) return celda3;

        if (celda4 != null && celda4.getProducto() != null &&
            celda4.getProducto().getCodigo().equals(codigoProducto)) return celda4;

        return null;
    }

    public void incrementarProductos(String codigoProducto, int cantidad) {
        Celda celda = buscarCeldaProducto(codigoProducto);
        if (celda != null) {
            celda.setStock(celda.getStock() + cantidad);
        }
    }

    public void vender(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getStock() > 0) {
            celda.setStock(celda.getStock() - 1);
            saldo += celda.getProducto().getPrecio();
        }
        mostrarProductos();
    }

    public double venderConCambio(String codigoCelda, double valorIngresado) {
        Celda celda = buscarCelda(codigoCelda);

        if (celda != null && celda.getStock() > 0) {
            double precio = celda.getProducto().getPrecio();
            celda.setStock(celda.getStock() - 1);
            saldo += precio;
            return valorIngresado - precio;
        }
        return 0;
    }
}
public class Main {

    public static void main(String[] args) {

        Maquina maquina = new Maquina();

        // Cargar producto
        Producto p1 = new Producto("Papitas", 0.85, "KE34");
        maquina.cargarProducto("B1", p1, 4);

        // Buscar celda
        System.out.println("Celda Encontrada: " + maquina.buscarCelda("A2"));
        System.out.println(maquina.buscarCelda("Z1") == null ? "no existe la celda" : "");

        // Buscar producto
        Producto encontrado = maquina.buscarProducto("Papitas");
        System.out.println("Producto encontrado: " + (encontrado != null ? encontrado.getNombre() : "null"));

        Producto noExiste = maquina.buscarProducto("Doritos");
        System.out.println("Producto encontrado: " + (noExiste != null ? noExiste.getNombre() : "null"));

        // Consultar precio
        System.out.println("Precio en B1: " + maquina.consultarPrecio("B1"));

        // Buscar celda por producto
        System.out.println("Celda que contiene el producto: " + maquina.buscarCeldaPorProducto("Papitas"));

        // Incrementar stock
        maquina.incrementarStock("B1", 8);

        // Mostrar estado
        maquina.mostrar();

        // Vender
        maquina.vender("B1", 2, 2.0);

        System.out.println("Saldo: " + maquina.getSaldo());
    }
}

// ------------------ CLASE PRODUCTO ------------------
class Producto {
    private String nombre;
    private double precio;
    private String codigo;

    public Producto(String nombre, double precio, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCodigo() { return codigo; }
}

// ------------------ CLASE CELDA ------------------
class Celda {
    private String codigo;
    private Producto producto;
    private int stock;

    public Celda(String codigo) {
        this.codigo = codigo;
        this.stock = 0;
    }

    public String getCodigo() { return codigo; }
    public Producto getProducto() { return producto; }
    public int getStock() { return stock; }

    public void setProducto(Producto producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    public void incrementar(int cantidad) {
        stock += cantidad;
    }

    public void vender(int cantidad) {
        stock -= cantidad;
        if (stock < 0) stock = 0;
    }
}

// ------------------ CLASE MAQUINA ------------------
class Maquina {
    private Celda[] celdas;
    private double saldo;

    public Maquina() {
        celdas = new Celda[4];
        celdas[0] = new Celda("A1");
        celdas[1] = new Celda("A2");
        celdas[2] = new Celda("B1");
        celdas[3] = new Celda("B2");
        saldo = 0;
    }

    public Celda buscarCelda(String codigo) {
        for (Celda c : celdas) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public void cargarProducto(String codigo, Producto p, int stock) {
        Celda c = buscarCelda(codigo);
        if (c != null) {
            c.setProducto(p, stock);
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Celda c : celdas) {
            if (c.getProducto() != null &&
                c.getProducto().getNombre().equals(nombre)) {
                return c.getProducto();
            }
        }
        return null;
    }

    public double consultarPrecio(String codigo) {
        Celda c = buscarCelda(codigo);
        if (c != null && c.getProducto() != null) {
            return c.getProducto().getPrecio();
        }
        return 0;
    }

    public String buscarCeldaPorProducto(String nombre) {
        for (Celda c : celdas) {
            if (c.getProducto() != null &&
                c.getProducto().getNombre().equals(nombre)) {
                return c.getCodigo();
            }
        }
        return null;
    }

    public void incrementarStock(String codigo, int cantidad) {
        Celda c = buscarCelda(codigo);
        if (c != null) {
            c.incrementar(cantidad);
        }
    }

    public void vender(String codigo, int cantidad, double dinero) {
        Celda c = buscarCelda(codigo);

        if (c != null && c.getProducto() != null && c.getStock() >= cantidad) {
            double total = c.getProducto().getPrecio() * cantidad;

            if (dinero >= total) {
                c.vender(cantidad);
                saldo += total;
            }
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void mostrar() {
        for (Celda c : celdas) {
            System.out.println("***********CELDA " + c.getCodigo());

            if (c.getProducto() != null) {
                System.out.println("Stock:" + c.getStock());
                System.out.println("Nombre Producto:" + c.getProducto().getNombre());
                System.out.println("Precio Producto:" + c.getProducto().getPrecio());
                System.out.println("Código Producto:" + c.getProducto().getCodigo());
            } else {
                System.out.println("Stock:0");
                System.out.println("La celda no tiene producto!!!");
            }
        }
    }
}