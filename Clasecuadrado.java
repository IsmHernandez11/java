public class Cuadrado {

    private double lado;

    // Constructor
    public Cuadrado(double lado) {
        this.lado = lado;
    }

    // Método calcular área
    public double calcularArea() {
        return lado * lado;
    }

    // Método calcular perímetro
    public double calcularPerimetro() {
        return lado * 4;
    }
}