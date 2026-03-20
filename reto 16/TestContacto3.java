public class TestContactos3 {
    public static void main(String[] args) {

        Telefono tel = new Telefono("movil", "333333333", 30);
        Contacto c = new Contacto("Pedro", "Ramirez", tel, 75.0);

        AdminContactos admin = new AdminContactos();
        admin.activarUsuario(c);

        System.out.println("Activo: " + c.activo);
        System.out.println("Whatsapp: " + c.telefono.tieneWhatsapp);
    }
}