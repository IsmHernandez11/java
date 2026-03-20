public class TestContactos2 {
    public static void main(String[] args) {

        Telefono tel1 = new Telefono("movil", "111111111", 10);
        Telefono tel2 = new Telefono("claro", "222222222", 20);

        Contacto c1 = new Contacto("Ana", "Lopez", tel1, 60.0);
        Contacto c2 = new Contacto("Luis", "Gomez", tel2, 80.0);

        AdminContactos admin = new AdminContactos();

        Contacto mayor = admin.buscarMasPesado(c1, c2);
        System.out.println("Contacto con mayor peso: " + mayor.nombre);

        boolean mismoOperador = admin.compararOperadoras(c1, c2);
        System.out.println("Mismo operador: " + mismoOperador);
    }
}