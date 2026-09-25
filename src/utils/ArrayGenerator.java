package utils;

import java.util.Random;

public class ArrayGenerator {
    private static final Random random = new Random();

    // 1. Caso Aleatório
    public static int[] gerarAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(tamanho * 10); // Espalha bem os valores
        }
        return array;
    }

    // 2. Caso Já Ordenado (Crescente)
    public static int[] gerarOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // 3. Caso Inversamente Ordenado (Decrescente)
    public static int[] gerarInversamenteOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

    // 4. Caso com Duplicatas (Pouca variação de números)
    public static int[] gerarComDuplicatas(int tamanho) {
        int[] array = new int[tamanho];
        // Usa apenas 5 valores diferentes para forçar alta repetição
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(5);
        }
        return array;
    }
}
