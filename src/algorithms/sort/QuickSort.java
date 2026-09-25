package algorithms.sort;

import interfaces.Sorter;

public class QuickSort implements Sorter {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            // O partition coloca o pivô na posição correta e retorna esse índice
            int indicePivot = partition(array, inicio, fim);

            // Ordena a metade esquerda e a metade direita recursivamente
            quickSort(array, inicio, indicePivot - 1);
            quickSort(array, indicePivot + 1, fim);
        }
    }

    private int partition(int[] array, int inicio, int fim) {
        // Estratégia clássica de Lomuto: escolhe o último elemento como pivô
        int pivot = array[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivot) {
                i++;
                // Troca array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Coloca o pivô na sua posição definitiva
        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}
