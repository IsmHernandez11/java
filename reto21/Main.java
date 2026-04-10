import java.util.*;

// ===== ENTIDADES =====

class Palos {
    private String corazonRojo = "CR";
    private String corazonNegro = "CN";
    private String diamante = "D";
    private String trebol = "TR";

    public String getCorazonRojo() { return corazonRojo; }
    public String getCorazonNegro() { return corazonNegro; }
    public String getDiamante() { return diamante; }
    public String getTrebol() { return trebol; }
}

class Numero {
    String numeroCarta;
    int valor;

    public Numero(String numeroCarta, int valor) {
        this.numeroCarta = numeroCarta;
        this.valor = valor;
    }

    public String mostrar() {
        return numeroCarta + "-" + valor;
    }
}

class Carta {
    Numero numero;
    String palo;
    String estado = "N"; // N = no usado, C = usado

    public Carta(Numero numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public String mostrar() {
        return numero.numeroCarta + "-" + palo;
    }
}

// ===== NAIPES =====

class Naipe {
    ArrayList<Numero> numerosPosibles = new ArrayList<>();
    ArrayList<Carta> cartas = new ArrayList<>();

    public Naipe() {
        // valores
        numerosPosibles.add(new Numero("A", 11));
        numerosPosibles.add(new Numero("2", 2));
        numerosPosibles.add(new Numero("3", 3));
        numerosPosibles.add(new Numero("4", 4));
        numerosPosibles.add(new Numero("5", 5));
        numerosPosibles.add(new Numero("6", 6));
        numerosPosibles.add(new Numero("7", 7));
        numerosPosibles.add(new Numero("8", 8));
        numerosPosibles.add(new Numero("9", 9));
        numerosPosibles.add(new Numero("10", 10));
        numerosPosibles.add(new Numero("J", 10));
        numerosPosibles.add(new Numero("Q", 10));
        numerosPosibles.add(new Numero("K", 10));

        Palos p = new Palos();

        for (Numero n : numerosPosibles) {
            cartas.add(new Carta(n, p.getCorazonRojo()));
            cartas.add(new Carta(n, p.getCorazonNegro()));
            cartas.add(new Carta(n, p.getDiamante()));
            cartas.add(new Carta(n, p.getTrebol()));
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    // EJERCICIO 4
    public ArrayList<Carta> barajar() {
        ArrayList<Carta> auxiliar = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int pos = r.nextInt(cartas.size());
            Carta c = cartas.get(pos);

            if (c.estado.equals("N")) {
                c.estado = "C";
                auxiliar.add(c);
            }
        }

        for (Carta c : cartas) {
            if (c.estado.equals("N")) {
                auxiliar.add(c);
            }
        }

        return auxiliar;
    }
}

// ===== RANDOM =====

class RandomUtil {
    public static int obtenerPosicion() {
        return (int)(Math.random() * 51);
    }
}

// ===== JUGADORES =====

class Jugadores {
    ArrayList<String> jugadores = new ArrayList<>();

    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<String> getJugadores() {
        return jugadores;
    }
}

// ===== JUEGO =====

class Juego {
    Naipe naipe;
    ArrayList<ArrayList<Carta>> cartasJugadores;

    public Juego(ArrayList<String> jugadores) {
        naipe = new Naipe();
        cartasJugadores = new ArrayList<>();

        for (int i = 0; i < jugadores.size(); i++) {
            cartasJugadores.add(new ArrayList<>());
        }
    }

    // EJERCICIO 6
    public void entregarCartas(int cartasPorJugador) {
        ArrayList<Carta> barajado = naipe.barajar();
        int index = 0;

        for (int i = 0; i < cartasPorJugador; i++) {
            for (int j = 0; j < cartasJugadores.size(); j++) {
                cartasJugadores.get(j).add(barajado.get(index));
                index++;
            }
        }
    }

    public int devolverTotal(int jugador) {
        int suma = 0;
        for (Carta c : cartasJugadores.get(jugador)) {
            suma += c.numero.valor;
        }
        return suma;
    }

    // EJERCICIO 8
    public int determinarGanador() {
        int ganador = 0;
        int sumaGanador = devolverTotal(0);

        for (int i = 1; i < cartasJugadores.size(); i++) {
            int suma = devolverTotal(i);
            if (suma >= sumaGanador) {
                ganador = i;
                sumaGanador = suma;
            }
        }
        return ganador;
    }
}

// ===== TEST =====

public class Main {
    public static void main(String[] args) {

        // jugadores
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Jugador 1");
        lista.add("Jugador 2");
        lista.add("Jugador 3");

        Juego juego = new Juego(lista);

        juego.entregarCartas(5);

        // imprimir totales
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Total de jugador " + (i+1) + ": " + juego.devolverTotal(i));
        }

        int ganador = juego.determinarGanador();
        System.out.println("El ganador es: jugador " + (ganador + 1));
    }
}
