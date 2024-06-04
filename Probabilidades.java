public class Probabilidades {
    private static final int TOTAL_DIAS = 18;
    private static final int[][] DATOS = {
            {10, 3, 10}, // Llueve
            {2, 6, 8},  // No llueve
            {9, 9, 18}  // Totales
    };

    public static void calcularProbabilidades() {
        // Probabilidades marginales primer dato es la fila segundo columna
        double pA = (double) DATOS[2][0] / TOTAL_DIAS;
        double pA_complemento = (double) DATOS[2][1] / TOTAL_DIAS;
        double pB = (double) DATOS[0][2] / TOTAL_DIAS;
        double pB_complemento = (double) DATOS[1][2] / TOTAL_DIAS;

        System.out.println("Probabilidades marginales:");
        System.out.println("P(A) esta nublado = " + pA);
        System.out.println("P(A') no esta nublado = " + pA_complemento);
        System.out.println("P(B) llueva  = " + pB);
        System.out.println("P(B') no llueva  = " + pB_complemento);

        // Probabilidades conjuntas
        double pA_interseccion_B = (double) DATOS[0][0] / TOTAL_DIAS;
        double pA_complemento_interseccion_B_complemento = (double) DATOS[1][1] / TOTAL_DIAS;

        System.out.println("Probabilidades conjuntas:");
        System.out.println("P(A ∩ B) esta nublado y llueva = " + pA_interseccion_B);
        System.out.println("P(A' ∩ B') no esta nublado y no llueva = " + pA_complemento_interseccion_B_complemento);

        // Probabilidades condicionales
        double pB_dado_A = (double) DATOS[0][0] / DATOS[2][0];
        double pB_dado_A_complemento = (double) DATOS[0][1] / DATOS[2][1];
        double pB_complemento_dado_A = (double) DATOS[1][0] / DATOS[2][0];
        double pB_complemento_dado_A_complemento = (double) DATOS[1][1] / DATOS[2][1];
        double pA_dado_B = (double) DATOS[0][0] / DATOS[0][2];
        double pA_dado_B_complemento = (double) DATOS[1][0] / DATOS[1][2];

        System.out.println("Probabilidades condicionales:");
        System.out.println("P(B|A) llueva dado que esté nublado = " + pB_dado_A);
        System.out.println("P(B|A') llueva dado que no esté nublado = " + pB_dado_A_complemento);
        System.out.println("P(B'|A) no llueva dado que esté nublado = " + pB_complemento_dado_A);
        System.out.println("P(B'|A') no llueva dado que no esté nublado = " + pB_complemento_dado_A_complemento);
        System.out.println("P(A|B) esté nublado dado que llueva = " + pA_dado_B);
        System.out.println("P(A|B') esté nublado dado que no llueva      = " + pA_dado_B_complemento);
    }
}
