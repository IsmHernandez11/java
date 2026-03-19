public class Test {
    public static void main(String[] args) {

        Persona p = new Persona("Juan", 20);
        Auto a = new Auto("Toyota", 2022);
        Estudiante e = new Estudiante("Ana", 9.5);

        System.out.println("Persona: " + p.nombre + " - " + p.edad);
        System.out.println("Auto: " + a.marca + " - " + a.año);
        System.out.println("Estudiante: " + e.nombre + " - " + e.promedio);
    }
}