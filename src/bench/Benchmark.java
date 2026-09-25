package bench;

import algorithms.sort.*;
import algorithms.search.*;
import interfaces.Searcher;
import interfaces.Sorter;
import utils.ArrayGenerator;

import java.util.Arrays;

public class Benchmark {

    public static void main(String[] args) {
        System.out.println("INICIANDO BENCHMARK DE ALGORITMOS");
        executarBenchmarkOrdenacao();

        System.out.println("\n");

        executarBenchmarkBusca();
    }

    private static void executarBenchmarkOrdenacao() {
        int[] tamanhos = {1000, 10000, 50000, 500000, 1000000};

        Sorter[] algoritmos = {
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new QuickSort()
        };

        System.out.println("================================================= ORDENAÇÃO =================================================");
        System.out.printf("%-15s | %-8s | %-12s | %-15s | %-18s | %-15s%n",
                "Algoritmo", "Vetor N", "Aleatório", "Já Ordenado", "Inverso Ordenado", "C/ Duplicatas");
        System.out.println("----------------+----------+--------------+-----------------+--------------------+-----------------");

        for (Sorter algoritmo : algoritmos) {
            for (int N : tamanhos) {
                // 1. Gera os vetores originais para o tamanho N
                int[] aleatorio = ArrayGenerator.gerarAleatorio(N);
                int[] ordenado = ArrayGenerator.gerarOrdenado(N);
                int[] inverso = ArrayGenerator.gerarInversamenteOrdenado(N);
                int[] duplicatas = ArrayGenerator.gerarComDuplicatas(N);

                // Pula a execução de algoritmos O(N^2) para N muito grande para evitar travamento
                boolean pularLentos = N >= 500000 && !(algoritmo instanceof QuickSort);

                String tempoAleatorio = pularLentos ? "> Demorado" : medirTempoOrdenacao(algoritmo, aleatorio);
                String tempoOrdenado = pularLentos ? "> Demorado" : medirTempoOrdenacao(algoritmo, ordenado);
                String tempoInverso = pularLentos ? "> Demorado" : medirTempoOrdenacao(algoritmo, inverso);
                String tempoDuplicatas = pularLentos ? "> Demorado" : medirTempoOrdenacao(algoritmo, duplicatas);

                System.out.printf("%-15s | %-8d | %-12s | %-15s | %-18s | %-15s%n",
                        algoritmo.getName(), N, tempoAleatorio, tempoOrdenado, tempoInverso, tempoDuplicatas);
            }
            System.out.println("----------------+----------+--------------+-----------------+--------------------+-----------------");
        }
    }

    private static void executarBenchmarkBusca() {
        int[] tamanhos = {1000, 10000, 50000, 500000, 1000000};

        Searcher[] algoritmosBusca = {
                new LinearSearch(), // Ou BuscaLinear, dependendo de como você nomeou
                new BinarySearch()  // Ou BuscaBinaria
        };

        System.out.println("========================================= BUSCA (Pior Caso) =========================================");
        System.out.printf("%-15s | %-8s | %-15s%n", "Algoritmo", "Vetor N", "Tempo (Pior Caso)");
        System.out.println("----------------+----------+-----------------");

        for (Searcher busca : algoritmosBusca) {
            for (int N : tamanhos) {
                // Para busca binária, o vetor DEVE estar ordenado
                int[] array = ArrayGenerator.gerarOrdenado(N);

                // Buscamos um número que não existe (-1) para forçar o Pior Caso absoluto
                int alvo = -1;

                long inicio = System.nanoTime();
                busca.search(array, alvo);
                long fim = System.nanoTime();

                double tempoMs = (fim - inicio) / 1_000_000.0;
                System.out.printf("%-15s | %-8d | %.4f ms%n", busca.getName(), N, tempoMs);
            }
            System.out.println("----------------+----------+-----------------");
        }
    }

    // Método utilitário para medir o tempo e tratar StackOverflow
    private static String medirTempoOrdenacao(Sorter algoritmo, int[] arrayOriginal) {
        // Precisamos clonar o array para não ordenar o array original e estragar os próximos testes!
        int[] copia = Arrays.copyOf(arrayOriginal, arrayOriginal.length);

        try {
            long inicio = System.nanoTime();
            algoritmo.sort(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;
            return String.format("%.2f ms", tempoMs);

        } catch (StackOverflowError e) {
            return "StackOverflow";
        }
    }
}
