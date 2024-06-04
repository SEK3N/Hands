import java.util.ArrayList;
import java.util.Collections;

public class Dataset {

    public static void main(String[] args) {
        ArrayList<Integer> dataset = new ArrayList<>();
        // Agregar el dataset
        Collections.addAll(dataset, 38, 15, 10, 12, 62, 46, 25, 56, 27, 24, 23, 21, 20, 25, 38, 27, 48, 35, 50, 65, 59, 58, 47, 42, 37, 35, 32, 40, 28, 14, 12, 24, 66, 73, 72, 70, 68, 65, 54, 48, 34, 33, 21, 19, 61, 59, 47, 46, 30, 30);
        Collections.sort(dataset);
        int valorMaximo = Collections.max(dataset);

        // Imprimir el dataset ordenado
        System.out.println("[Datos del dataset ordenados de menor a mayor:");
        for (int value : dataset) {
            System.out.print(value + " ");
        }
        System.out.println();

        double rango = dataset.get(dataset.size() - 1) - dataset.get(0);

        // Calcula el número de clases utilizando la regla de Sturges
        int numClases = (int) Math.ceil(1 + 3.322 * Math.log10(dataset.size()));

        double amplitudIntervalo = rango / numClases;

        ArrayList<Intervalo> intervalos = getIntervalos(dataset, numClases, amplitudIntervalo);

        // Llamada a los métodos de Estadisticas.
        Estadistica.ResultadoEstadisticas resultado = Estadistica.calcularEstadisticas(dataset);

        // Calcular la mediana con datos ordenados
        double medianaOrdenada = Estadistica.calcularMediana(dataset, true);


        // Imprimir los resultados
        System.out.println("[Medidas de Tendencia Central");
        System.out.println("Media (promedio): " + resultado.media);
        System.out.println("Mediana: " + medianaOrdenada);
        System.out.println("Moda: " + resultado.moda);
        System.out.println("[Datos de salida desde la clase Dataset");
        // System.println();
        // Imprimir la tabla
        System.out.println("La amplitud del intervalo es: " + amplitudIntervalo);
        System.out.println("El Rango es: " + rango);
        System.out.println("El número de clases son: " + numClases);
        System.out.println("Datos de salida desde la clase Intervalo");
        System.out.println("Frecuencia Absoluta (freabs)");
        System.out.println("Punto Medio (pm) ");
        System.out.println("Frecuencia Acumulada (freacum)");
        System.out.println("Frecuencia Relativa (frerel)");
        System.out.println("Porcentaje de la Frecuencia Relativa (%frerel)");
        System.out.println("Frecuencia Relativa Acumulada (frereacum)");
        System.out.println("Porcentaje de Frecuencia Relativa Acumulada (%frereacum)");
        System.out.println("|   Intervalo   |  Freabs |   Pm   | Freacum |  Frerel | %frerel | Frereacum | %frereacum |");

        System.out.println("------------------------------------------------------------------------------------------");

        // Agregar los datos de la clase intervalo
        for (Intervalo intervalo : intervalos) {
            System.out.println(intervalo.toString());
        }
    }

    public static ArrayList<Intervalo> getIntervalos(ArrayList<Integer> dataset, int numClases, double amplitudIntervalo) {
        ArrayList<Intervalo> intervalos = new ArrayList<>();
        double limiteInferior = dataset.get(0);
        int total = dataset.size();
        int frecuenciaAcumulada = 0;
        double frecuenciaRelativaAcumulada = 0.0;
//genera el numero de clases y limite inferior inicializada en 0
        for (int i = 0; i < numClases; i++) {
            double limiteSuperior = limiteInferior + amplitudIntervalo;
            int frecuenciaAbsoluta = 0;



            for (int data : dataset) {
                int valorMaximo = Collections.max(dataset);
                if (data >= limiteInferior && data < limiteSuperior) {
                    frecuenciaAbsoluta++;
                } else if (limiteSuperior == valorMaximo && data == limiteSuperior) {
                    frecuenciaAbsoluta++;
                }
            }
            frecuenciaAcumulada += frecuenciaAbsoluta;
            double frecuenciaRelativa = ((double)frecuenciaAbsoluta / total);
            frecuenciaRelativaAcumulada +=((double ) frecuenciaRelativa);

            Intervalo intervalo = new Intervalo(limiteInferior, limiteSuperior, (int) frecuenciaAbsoluta);
            intervalos.add(intervalo);



            intervalo.setFrecuenciaAcumulada(frecuenciaAcumulada);
            intervalo.setFrecuenciaRelativaAcumulada(frecuenciaRelativaAcumulada);
            intervalo.calcularPuntoMedio();
            intervalo.calcularFrecuenciaRelativa(total);
            intervalo.calcularPorcentajeFrecuenciaRelativa();
            intervalo.calcularPorcentajeFrecuenciaRelativaAcumulada();

            limiteInferior = limiteSuperior;
            // Manejo especial para el último intervalo
            if (i == numClases - 1) {
                intervalo.setFrecuenciaAcumulada(total);
                intervalo.setFrecuenciaRelativaAcumulada(1.0);
                intervalo.calcularPorcentajeFrecuenciaRelativa();
                intervalo.calcularPorcentajeFrecuenciaRelativaAcumulada();
            }
        }
        return intervalos;
    }
}