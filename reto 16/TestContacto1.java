public class TestContactos1 {
    public static void main(String[] args) {

        Telefono tel = new Telefono("movil", "099999999", 30);

        Contacto c = new Contacto("Juan", "Perez", tel, 70.5);

        System.out.println("Nombre: " + c.nombre);
        System.out.println("Apellido: " + c.apellido);
        System.out.println("Peso: " + c.peso);
        System.out.println("Operador: " + c.telefono.operador);
        System.out.println("Numero: " + c.telefono.numero);
    }
}