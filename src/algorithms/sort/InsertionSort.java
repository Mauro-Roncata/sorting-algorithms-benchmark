package algorithms.sort;

import interfaces.Sorter;

public class InsertionSort implements Sorter  {
    @Override
    public void sort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;

            // Move os elementos que são maiores que a chave uma posição para a direita
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            // Insere a chave na sua posição correta
            array[j + 1] = chave;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
