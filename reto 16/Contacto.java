public class Contacto {
    String nombre;
    String apellido;
    boolean activo;
    Telefono telefono;
    double peso;

    public Contacto(String nombre, String apellido, Telefono telefono, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.peso = peso;
        this.activo = false;
    }
}