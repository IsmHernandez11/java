import java.util.ArrayList;

// -------------------- CLASE MATERIA --------------------
class Materia {
    String codigo;
    String nombre;

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String mostrar() {
        return "Materia[codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}

// -------------------- CLASE NOTA --------------------
class Nota {
    Materia materia;
    double calificacion;

    public Nota(Materia materia, double calificacion) {
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public void mostrar() {
        System.out.println("Nota -> " + materia.mostrar() + ", calificacion=" + calificacion);
    }
}

// -------------------- CLASE ESTUDIANTE --------------------
class Estudiante {
    String nombre;
    String apellido;
    String cedula;
    ArrayList<Nota> listaNotas;

    public Estudiante(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.listaNotas = new ArrayList<>();
    }

    // agregarNota
    public void agregarNota(Nota nuevaNota) {
        if (nuevaNota.calificacion < 0 || nuevaNota.calificacion > 10) {
            System.out.println("Nota inválida");
            return;
        }

        for (Nota n : listaNotas) {
            if (n.materia.codigo.equals(nuevaNota.materia.codigo)) {
                System.out.println("Materia ya existe");
                return;
            }
        }

        listaNotas.add(nuevaNota);
    }

    // modificarNota
    public void modificarNota(String codigo, double nuevaNota) {
        if (nuevaNota < 0 || nuevaNota > 10) {
            System.out.println("Nota inválida");
            return;
        }

        for (Nota n : listaNotas) {
            if (n.materia.codigo.equals(codigo)) {
                n.calificacion = nuevaNota;
                return;
            }
        }

        System.out.println("No se encontró la materia");
    }

    // calcularPromedioNotasEstudiante
    public double calcularPromedioNotasEstudiante() {
        if (listaNotas.size() == 0) return 0;

        double suma = 0;
        for (Nota n : listaNotas) {
            suma += n.calificacion;
        }

        return suma / listaNotas.size();
    }

    // mostrar
    public String mostrar() {
        String resultado = "Estudiante[nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]\n";

        for (Nota n : listaNotas) {
            resultado += "  -> " + n.materia.mostrar() + ", nota=" + n.calificacion + "\n";
        }

        return resultado;
    }
}

// -------------------- CLASE CURSO --------------------
class Curso {
    ArrayList<Estudiante> listaEstudiantes;

    public Curso() {
        listaEstudiantes = new ArrayList<>();
    }

    // buscarEstudiantePorCedula
    public Estudiante buscarEstudiantePorCedula(String cedula) {
        for (Estudiante e : listaEstudiantes) {
            if (e.cedula.equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    // matricularEstudiantes
    public void matricularEstudiantes(Estudiante estudiante) {
        if (buscarEstudiantePorCedula(estudiante.cedula) == null) {
            listaEstudiantes.add(estudiante);
        } else {
            System.out.println("El estudiante ya está matriculado");
        }
    }

    // calcularPromedioCurso
    public double calcularPromedioCurso() {
        if (listaEstudiantes.size() == 0) return 0;

        double suma = 0;
        for (Estudiante e : listaEstudiantes) {
            suma += e.calcularPromedioNotasEstudiante();
        }

        return suma / listaEstudiantes.size();
    }
}

// -------------------- MAIN (PRUEBA) --------------------
public class Main {
    public static void main(String[] args) {

        Curso curso = new Curso();

        Estudiante e1 = new Estudiante("Axel", "Perez", "123");
        Estudiante e2 = new Estudiante("Luis", "Gomez", "456");

        curso.matricularEstudiantes(e1);
        curso.matricularEstudiantes(e2);

        Materia m1 = new Materia("MAT01", "Matemáticas");
        Materia m2 = new Materia("LEN01", "Lengua");

        e1.agregarNota(new Nota(m1, 9));
        e1.agregarNota(new Nota(m2, 8));

        e2.agregarNota(new Nota(m1, 7));
        e2.agregarNota(new Nota(m2, 6));

        e1.modificarNota("MAT01", 10);

        System.out.println(e1.mostrar());
        System.out.println(e2.mostrar());

        System.out.println("Promedio estudiante 1: " + e1.calcularPromedioNotasEstudiante());
        System.out.println("Promedio curso: " + curso.calcularPromedioCurso());
    }
}