import java.util.*;
import java.text.SimpleDateFormat;

// ===================== DIRECCION (TU CÓDIGO) =====================
class Direccion {

    private String callePrincipal;
    private String calleSecundaria;

    // Constructor
    public Direccion(String callePrincipal, String calleSecundaria) {
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
    }

    // Getters y Setters
    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }
}

// ===================== TELEFONO =====================
class Telefono {
    private String numero;
    private String tipo;
    private String estado;

    public Telefono(String numero, String tipo, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
}

// ===================== CONTACTO =====================
class Contacto {
    private String cedula;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private ArrayList<Telefono> telefonos;

    public Contacto(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        telefonos = new ArrayList<>();
    }

    public String getCedula() { return cedula; }
    public Direccion getDireccion() { return direccion; }
    public ArrayList<Telefono> getTelefonos() { return telefonos; }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // REQ 5
    public void agregarTelefono(Telefono t) {
        telefonos.add(t);
    }

    // Mostrar teléfonos con estado C
    public void mostrarTelefonos() {
        System.out.println("Teléfonos con estado 'C':");
        for (Telefono t : telefonos) {
            if (t.getEstado().equals("C")) {
                System.out.println("Número: " + t.getNumero() + ", Tipo: " + t.getTipo());
            }
        }
    }

    // REQ 6
    public ArrayList<Telefono> recuperarIncorrectos() {
        ArrayList<Telefono> lista = new ArrayList<>();
        for (Telefono t : telefonos) {
            if (t.getEstado().equals("E")) {
                lista.add(t);
            }
        }
        return lista;
    }

    public void imprimir() {
        System.out.println("***" + nombre + " " + apellido + "***");
        if (direccion != null) {
            System.out.println("Dirección: " +
                    direccion.getCallePrincipal() + " y " +
                    direccion.getCalleSecundaria());
        } else {
            System.out.println("No tiene asociada una dirección");
        }
    }
}

// ===================== DIRECTORIO =====================
class Directorio {
    private ArrayList<Contacto> contactos;
    private Date fechaModificacion;

    private ArrayList<Contacto> correctos;
    private ArrayList<Contacto> incorrectos;

    public Directorio() {
        contactos = new ArrayList<>();
        correctos = new ArrayList<>();
        incorrectos = new ArrayList<>();
    }

    // REQ 8
    public boolean agregarContacto(Contacto c) {
        if (buscarPorCedula(c.getCedula()) != null) {
            return false;
        }
        contactos.add(c);
        fechaModificacion = new Date();
        return true;
    }

    // REQ 7
    public Contacto buscarPorCedula(String cedula) {
        for (Contacto c : contactos) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    // REQ 9
    public String consultarUltimaModificacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(fechaModificacion);
    }

    // REQ 10
    public int contarPerdidos() {
        int c = 0;
        for (Contacto con : contactos) {
            if (con.getDireccion() == null) {
                c++;
            }
        }
        return c;
    }

    // REQ 11
    public int contarFijos() {
        int c = 0;
        for (Contacto con : contactos) {
            for (Telefono t : con.getTelefonos()) {
                if (t.getTipo().equalsIgnoreCase("Convencional")
                        && t.getEstado().equals("C")) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }

    // REQ 12
    public void depurar() {
        correctos.clear();
        incorrectos.clear();

        for (Contacto c : contactos) {
            if (c.getDireccion() != null) {
                correctos.add(c);
            } else {
                incorrectos.add(c);
            }
        }
    }

    public ArrayList<Contacto> getCorrectos() { return correctos; }
    public ArrayList<Contacto> getIncorrectos() { return incorrectos; }
}

// ===================== MAIN =====================
public class Main {
    public static void main(String[] args) {

        Directorio dir = new Directorio();

        Contacto c1 = new Contacto("123", "Juan", "Perez");
        Contacto c2 = new Contacto("456", "Ana", "Gomez");
        Contacto c3 = new Contacto("123", "Pedro", "Lopez");

        c1.setDireccion(new Direccion("Calle A", "Calle B"));

        c1.agregarTelefono(new Telefono("9876543210", "Movil", "C"));
        c1.agregarTelefono(new Telefono("1112233", "Convencional", "C"));
        c1.agregarTelefono(new Telefono("999999", "Movil", "E"));

        System.out.println("Agregar c1: " + dir.agregarContacto(c1));
        System.out.println("Agregar c2: " + dir.agregarContacto(c2));
        System.out.println("Agregar duplicado c3: " + dir.agregarContacto(c3));

        System.out.println("\nBuscar cédula 123:");
        Contacto buscado = dir.buscarPorCedula("123");
        if (buscado != null) buscado.imprimir();

        System.out.println("\nTeléfonos:");
        c1.mostrarTelefonos();

        System.out.println("\nIncorrectos: " + c1.recuperarIncorrectos().size());

        System.out.println("\nPerdidos: " + dir.contarPerdidos());

        System.out.println("Fijos: " + dir.contarFijos());

        System.out.println("\nÚltima modificación:");
        System.out.println(dir.consultarUltimaModificacion());

        dir.depurar();
        System.out.println("\nCorrectos: " + dir.getCorrectos().size());
        System.out.println("Incorrectos: " + dir.getIncorrectos().size());
    }
}