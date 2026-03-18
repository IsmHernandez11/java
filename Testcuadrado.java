public class TestCuadrado {

    public static void main(String[] args) {

        Cuadrado c1 = new Cuadrado(3);
        Cuadrado c2 = new Cuadrado(5);
        Cuadrado c3 = new Cuadrado(8);

        System.out.println("Área c1: " + c1.calcularArea());
        System.out.println("Perímetro c1: " + c1.calcularPerimetro());

        System.out.println("Área c2: " + c2.calcularArea());
        System.out.println("Perímetro c2: " + c2.calcularPerimetro());

        System.out.println("Área c3: " + c3.calcularArea());
        System.out.println("Perímetro c3: " + c3.calcularPerimetro());
    }
}