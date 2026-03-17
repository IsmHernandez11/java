public class TestCalculadora {

    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        // Multiplicar
        double resultadoMultiplicacion = calc.multiplicar(10, 5);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);

        // Dividir
        double resultadoDivision = calc.dividir(10, 2);
        System.out.println("División: " + resultadoDivision);

        // Promediar
        double resultadoPromedio = calc.promediar(10, 8, 9);
        System.out.println("Promedio: " + resultadoPromedio);

        // Mostrar mensaje
        calc.mostrarResultado();
    }
}