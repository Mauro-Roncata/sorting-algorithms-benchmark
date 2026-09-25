package algorithms.search;

import interfaces.Searcher;

public class BinarySearch implements Searcher {
    @Override
    public int search(int[] array, int target) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            // Evita overflow se o vetor for gigantesco
            int meio = inicio + (fim - inicio) / 2;

            if (array[meio] == target) {
                return meio; // Encontrou
            }

            if (array[meio] < target) {
                inicio = meio + 1; // Busca na metade superior
            } else {
                fim = meio - 1; // Busca na metade inferior
            }
        }
        return -1; // Não encontrou
    }

    @Override
    public String getName() {
        return "Busca Binária";
    }
}
