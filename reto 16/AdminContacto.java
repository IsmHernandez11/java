public class AdminContactos {

    public Contacto buscarMasPesado(Contacto c1, Contacto c2) {
        if (c1.peso > c2.peso) {
            return c1;
        } else {
            return c2;
        }
    }

    public boolean compararOperadoras(Contacto c1, Contacto c2) {
        return c1.telefono.operador.equals(c2.telefono.operador);
    }

    public void activarUsuario(Contacto c) {
        c.activo = true;

        if (c.telefono.operador.equals("movil")) {
            c.telefono.tieneWhatsapp = true;
        }
    }
}