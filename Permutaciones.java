import java.util.ArrayList;
import java.util.List;

public class Permutaciones {
    public static List<String> generarPermutaciones(char[] caracteres) {
        List<String> resultado = new ArrayList<>();
        permutar(caracteres, 0, resultado);
        return resultado;
    }

    private static void permutar(char[] caracteres, int indice, List<String> resultado) {
        if (indice == caracteres.length - 1) {
            resultado.add(new String(caracteres));
        } else {
            for (int i = indice; i < caracteres.length; i++) {
                intercambiar(caracteres, indice, i);
                permutar(caracteres, indice + 1, resultado);
                intercambiar(caracteres, indice, i);
            }
        }
    }

    private static void intercambiar(char[] caracteres, int i, int j) {
        char temp = caracteres[i];
        caracteres[i] = caracteres[j];
        caracteres[j] = temp;
    }
}

