public class TestTelefono2 {
    public static void main(String[] args) {

        Telefono tel = new Telefono("movil", "098234234", 20);

        AdminTelefono admin = new AdminTelefono();
        admin.activarMensajeria(tel);

        System.out.println("Operador: " + tel.operador);
        System.out.println("Numero: " + tel.numero);
        System.out.println("Codigo: " + tel.codigo);
        System.out.println("Whatsapp: " + tel.tieneWhatsapp);
    }
}