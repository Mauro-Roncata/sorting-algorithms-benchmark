package algorithms.sort;


import interfaces.Sorter;

public class BubbleSort implements Sorter {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            // O limite j < n - 1 - i evita comparar os últimos elementos que já estão no lugar certo
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Realiza a troca (swap)
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocou = true;
                }
            }
            // Se não houve nenhuma troca nesta passagem, o vetor já está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
