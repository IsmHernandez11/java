public class Rectangulo {

    private double base;
    private double altura;

    // Constructor
    private Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método para calcular perímetro
    private double calcularPerimetro() {
        return 2 * (base + altura);
    }
}