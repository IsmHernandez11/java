public class TestRectangulo {

    public static void main(String[] args) {

        Rectangulo r1 = new Rectangulo(4, 2);
        Rectangulo r2 = new Rectangulo(5, 3);
        Rectangulo r3 = new Rectangulo(10, 7);

        System.out.println("Perímetro r1: " + r1.calcularPerimetro());
        System.out.println("Perímetro r2: " + r2.calcularPerimetro());
        System.out.println("Perímetro r3: " + r3.calcularPerimetro());
    }
}