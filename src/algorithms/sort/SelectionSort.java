package algorithms.sort;

import interfaces.Sorter;

public class SelectionSort implements Sorter {
    @Override
    public void sort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            // Procura o menor elemento na parte não ordenada
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Troca o menor elemento encontrado com o primeiro elemento não ordenado
            if (indiceMenor != i) {
                int temp = array[indiceMenor];
                array[indiceMenor] = array[i];
                array[i] = temp;
            }
        }
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}
