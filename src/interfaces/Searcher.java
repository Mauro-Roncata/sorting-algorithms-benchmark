package interfaces;

public interface Searcher {

    // Retorna o índice do elemento, ou -1 se não encontrar
    int search(int[] array, int target);

    String getName();
}
