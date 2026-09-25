package algorithms.search;

import interfaces.Searcher;

public class LinearSearch implements Searcher{
    @Override
    public int search(int[] array, int target) {
        // Percorre elemento por elemento
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Encontrou, retorna a posição
            }
        }
        return -1; // Não encontrou
    }

    @Override
    public String getName() {
        return "Busca Linear";
    }
}
