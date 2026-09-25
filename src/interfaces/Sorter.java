package interfaces;

public interface Sorter {
    // Método principal que executará a ordenação in-place
    void sort(int[] array);

    // Retorna o nome do algoritmo para imprimir na tabela final
    String getName();
}
