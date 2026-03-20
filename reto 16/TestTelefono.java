public class TestTelefono {
    public static void main(String[] args) {

        Telefono tel = new Telefono("movil", "0991234123", 10);

        System.out.println("Operador: " + tel.operador);
        System.out.println("Numero: " + tel.numero);
        System.out.println("Codigo: " + tel.codigo);
        System.out.println("Whatsapp: " + tel.tieneWhatsapp);
    }
}