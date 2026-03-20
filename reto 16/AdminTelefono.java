public class AdminTelefono {

    public void activarMensajeria(Telefono tel) {
        if (tel.operador.equals("movil")) {
            tel.tieneWhatsapp = true;
        }
    }

    public int contarMovil(Telefono t1, Telefono t2, Telefono t3) {
        int contador = 0;

        if (t1.operador.equals("movil")) contador++;
        if (t2.operador.equals("movil")) contador++;
        if (t3.operador.equals("movil")) contador++;

        return contador;
    }

    public int contarClaro(Telefono t1, Telefono t2, Telefono t3, Telefono t4) {
        int contador = 0;

        if (t1.operador.equals("claro")) contador++;
        if (t2.operador.equals("claro")) contador++;
        if (t3.operador.equals("claro")) contador++;
        if (t4.operador.equals("claro")) contador++;

        return contador;
    }
}