import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap; // no permite numeros duplicados
import java.util.Map;

public class Estadistica {


    public static ResultadoEstadisticas calcularEstadisticas(ArrayList<Integer> dataset) {
        ResultadoEstadisticas resultado = new ResultadoEstadisticas();
        resultado.media = calcularMedia(dataset);
        resultado.mediana = (int) calcularMediana(dataset, true);
        resultado.moda = calcularModa(dataset);
        return resultado;
    }


    public static double calcularMedia(ArrayList<Integer> dataset) {
        int sum = 0;
        for (int value : dataset) {
            sum += value;
        }
        return (double) sum / dataset.size();
    }

    public static double calcularMediana(ArrayList<Integer> dataset, boolean ordenado) {
        if (!ordenado) {
            Collections.sort(dataset);
        }
        int n = dataset.size();
        if (n % 2 == 0) {
            return (dataset.get(n / 2 - 1) + dataset.get(n / 2)) / 2.0;
        } else {
            return dataset.get(n / 2);
        }
    }

    public  static ArrayList<Integer> calcularModa(ArrayList<Integer> dataset) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int value : dataset) {
            freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
        }
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        ArrayList<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modeList.add(entry.getKey());
            }
        }
        return modeList;
    }
    public static class ResultadoEstadisticas {
        public double media;
        public int mediana;
        public ArrayList<Integer> moda;
    }

}