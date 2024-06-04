import java.util.List;

public class CalculadoraConjuntosMain {
    public static void main(String[] args) {
        // Generación de Permutaciones
        char[] caracteres = {'A', 'B', 'C'};
        List<String> permutaciones = Permutaciones.generarPermutaciones(caracteres);

        System.out.println("Permutaciones:");
        for (String permutacion : permutaciones) {
            System.out.println(permutacion);
        }


        // Cálculo de Probabilidades
        System.out.println("\nCalculando Probabilidades:");
        Probabilidades.calcularProbabilidades();
    }
}
