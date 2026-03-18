public class Rectangulo {

    private double base;
    private double altura;

    // Constructor
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método para calcular perímetro
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}