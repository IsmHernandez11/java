```java
import java.util.ArrayList;

// ===================== CLASE PRODUCTO =====================
class Producto {
    private String nombre;
    private double precio;
    private String codigo;

    public Producto(String nombre, double precio, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    public void incrementarPrecio(int porcentaje) {
        precio += precio * porcentaje / 100.0;
    }

    public void disminuirPrecio(double descuento) {
        precio -= descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }
}

// ===================== CLASE CELDA =====================
class Celda {
    private Producto producto;
    private int stock;
    private String codigo;

    public Celda(String codigo) {
        this.codigo = codigo;
    }

    public void ingresarProducto(Producto producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getStock() {
        return stock;
    }

    public String getCodigo() {
        return codigo;
    }
}

// ===================== CLASE MAQUINA =====================
class MaquinaDulces {

    private ArrayList<Celda> celdas;
    private double saldo;

    public MaquinaDulces() {
        celdas = new ArrayList<>();
        saldo = 0;
    }

    public void agregarCelda(String codigo) {
        celdas.add(new Celda(codigo));
    }

    public void mostrarConfiguracion() {
        for (Celda c : celdas) {
            System.out.println("Celda:" + c.getCodigo());
        }
    }

    public Celda buscarCelda(String codigo) {
        for (Celda c : celdas) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public void cargarProducto(Producto p, String codigoCelda, int stock) {
        Celda c = buscarCelda(codigoCelda);
        if (c != null) {
            c.ingresarProducto(p, stock);
        }
    }

    public void mostrarProductos() {
        for (Celda c : celdas) {
            if (c.getProducto() != null) {
                System.out.println("Celda:" + c.getCodigo() +
                        " Stock:" + c.getStock() +
                        " Producto:" + c.getProducto().getCodigo() +
                        " Precio:" + c.getProducto().getPrecio());
            } else {
                System.out.println("Celda:" + c.getCodigo() +
                        " Stock:" + c.getStock() +
                        " Sin Producto asignado");
            }
        }
    }

    public Producto buscarProductoEnCelda(String codigoCelda) {
        Celda c = buscarCelda(codigoCelda);
        if (c != null) {
            return c.getProducto();
        }
        return null;
    }

    public Double consultarPrecio(String codigoCelda) {
        Celda c = buscarCelda(codigoCelda);
        if (c != null && c.getProducto() != null) {
            return c.getProducto().getPrecio();
        }
        return null;
    }

    public String buscarCeldaProducto(String codigoProducto) {
        for (Celda c : celdas) {
            if (c.getProducto() != null &&
                c.getProducto().getCodigo().equals(codigoProducto)) {
                return c.getCodigo();
            }
        }
        return null;
    }
}

// ===================== MAIN =====================
public class Main {
    public static void main(String[] args) {

        MaquinaDulces m = new MaquinaDulces();

        // Crear celdas
        m.agregarCelda("A");
        m.agregarCelda("B");
        m.agregarCelda("C");
        m.agregarCelda("D");

        // Mostrar configuración
        m.mostrarConfiguracion();

        // Crear productos
        Producto p1 = new Producto("Papitas", 0.85, "KE34");
        Producto p2 = new Producto("Chocolate", 2.54, "BDCR");

        // Cargar productos
        m.cargarProducto(p1, "B", 4);
        m.cargarProducto(p2, "D", 5);

        // Mostrar productos
        m.mostrarProductos();

        // Buscar producto en celda
        Producto encontrado = m.buscarProductoEnCelda("B");
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("Producto encontrado: null");
        }

        // Buscar celda inexistente
        Producto noExiste = m.buscarProductoEnCelda("Z");
        if (noExiste != null) {
            System.out.println("Producto encontrado: " + noExiste.getNombre());
        } else {
            System.out.println("Producto encontrado: null");
        }

        // Consultar precio
        System.out.println("Precio en B: " + m.consultarPrecio("B"));

        // Buscar celda por producto
        System.out.println("Celda del producto KE34: " +
                m.buscarCeldaProducto("KE34"));
    }
}
```
import java.util.ArrayList;

public class Main {

    // ===== CLASE PRODUCTO =====
    static class Producto {
        String nombre;
        double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }

    // ===== CLASE CELDA =====
    static class Celda {
        String codigo;
        Producto producto;
        int stock;

        public Celda(String codigo) {
            this.codigo = codigo;
            this.stock = 0;
            this.producto = null;
        }
    }

    // ===== CLASE MAQUINA =====
    static class MaquinaDulces {
        ArrayList<Celda> celdas = new ArrayList<>();
        double saldo = 0;

        // Buscar celda
        public Celda buscarCelda(String codigo) {
            for (Celda c : celdas) {
                if (c.codigo.equals(codigo)) {
                    return c;
                }
            }
            return null;
        }

        // Mostrar productos
        public void mostrarProductos() {
            for (Celda c : celdas) {
                if (c.producto != null) {
                    System.out.println("Celda: " + c.codigo +
                            " Stock: " + c.stock +
                            " Producto: " + c.producto.nombre +
                            " Precio: " + c.producto.precio);
                } else {
                    System.out.println("Celda: " + c.codigo +
                            " Stock: " + c.stock +
                            " Sin Producto asignado");
                }
            }
            System.out.println("Saldo: " + saldo);
            System.out.println("--------------------------------");
        }

        // ===== vender =====
        public void vender(String codigo) {
            Celda c = buscarCelda(codigo);

            if (c != null && c.producto != null && c.stock > 0) {
                c.stock--;
                saldo += c.producto.precio;
            }
        }

        // ===== vender con cambio =====
        public double venderConCambio(String codigo, double dinero) {
            Celda c = buscarCelda(codigo);

            if (c == null || c.producto == null || c.stock <= 0) {
                System.out.println("No disponible");
                return dinero;
            }

            if (dinero < c.producto.precio) {
                System.out.println("Dinero insuficiente");
                return dinero;
            }

            c.stock--;
            saldo += c.producto.precio;

            return dinero - c.producto.precio;
        }

        // ===== buscar menores =====
        public ArrayList<Producto> buscarMenores(double limite) {
            ArrayList<Producto> lista = new ArrayList<>();

            for (Celda c : celdas) {
                if (c.producto != null && c.producto.precio <= limite) {
                    lista.add(c.producto);
                }
            }
            return lista;
        }
    }

    // ===== MAIN (PRUEBAS) =====
    public static void main(String[] args) {

        MaquinaDulces m = new MaquinaDulces();

        // Crear celdas
        Celda c1 = new Celda("A1");
        c1.producto = new Producto("Doritos", 0.7);
        c1.stock = 6;

        Celda c2 = new Celda("A2");

        Celda c3 = new Celda("B1");
        c3.producto = new Producto("Papitas", 0.85);
        c3.stock = 3;

        Celda c4 = new Celda("B2");

        // Agregar a la máquina
        m.celdas.add(c1);
        m.celdas.add(c2);
        m.celdas.add(c3);
        m.celdas.add(c4);

        // Mostrar estado inicial
        m.mostrarProductos();

        // ===== PROBAR venderConCambio =====
        double cambio = m.venderConCambio("A1", 1.0);
        System.out.println("SU CAMBIO ES: " + cambio);

        m.mostrarProductos();

        // ===== PROBAR buscarMenores =====
        // Agregamos más productos
        Celda c5 = new Celda("C1");
        c5.producto = new Producto("Jet", 0.25);

        Celda c6 = new Celda("C2");
        c6.producto = new Producto("DeTodito", 0.6);

        m.celdas.add(c5);
        m.celdas.add(c6);

        ArrayList<Producto> menores = m.buscarMenores(0.85);

        System.out.println("Productos Menores: " + menores.size());
        for (Producto p : menores) {
            System.out.println("Nombre: " + p.nombre + " Precio: " + p.precio);
        }
    }
}