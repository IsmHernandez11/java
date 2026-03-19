package clearminds.cuentas;

public class Cuenta {

    private String id;
    private String tipo;
    private double saldo;

    // Constructor 1
    public Cuenta(String id) {
        this.id = id;
        this.tipo = "A";
        this.saldo = 0.0;
    }

    // Constructor 2
    public Cuenta(String id, String tipo, double saldo) {
        this.id = id;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    // GETTERS
    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    // SETTERS
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método imprimir
    public void imprimir() {
        System.out.println("********************");
        System.out.println("CUENTA");
        System.out.println("********************");
        System.out.println("Número de Cuenta: " + id);
        System.out.println("Tipo: " + tipo);
        System.out.println("Saldo: USD " + saldo);
        System.out.println("********************");
    }

    // Método estilo libre
    public void imprimirConMiEstilo() {
        System.out.println(">>> Cuenta [" + id + "] | Tipo: " + tipo + " | Saldo: $" + saldo);
    }
}