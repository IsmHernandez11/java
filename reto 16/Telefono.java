public class Telefono {
    String operador;
    String numero;
    int codigo;
    boolean tieneWhatsapp;

    public Telefono(String operador, String numero, int codigo) {
        this.operador = operador;
        this.numero = numero;
        this.codigo = codigo;
        this.tieneWhatsapp = false;
    }
}