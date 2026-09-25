# Relatório de Análise de Algoritmos (Unidade 1)
**Estudante:** Mauro Pezzetta Roncata | **Instituição:** UNIJUÍ

## 1. Fundamentação Teórica e Complexidade (Big-O)

### Algoritmos de Busca
*   **Busca Linear (Sequencial):** Varre o vetor do início ao fim comparando cada elemento com o alvo. É o método mais simples, não exige ordenação prévia, mas é ineficiente para grandes volumes.
*   **Busca Binária:** Utiliza o paradigma de divisão e conquista para buscar elementos em **vetores previamente ordenados**. A cada iteração, compara o alvo com o elemento central e descarta a metade do vetor onde o alvo definitivamente não está.

### Algoritmos de Ordenação
*   **Bubble Sort (com flag):** Compara pares adjacentes e os troca de posição se estiverem na ordem errada, "borbulhando" o maior valor para o final. A versão implementada possui uma *flag* (sinalizador `trocou`) que interrompe o algoritmo se nenhuma troca for realizada em uma varredura, otimizando o caso em que o vetor já está ordenado.
*   **Selection Sort:** Percorre a parte não ordenada do vetor para encontrar o menor elemento e o aloca na primeira posição disponível. Ele sempre realiza o mesmo número de comparações, independentemente da organização inicial dos dados.
*   **Insertion Sort:** Constrói o vetor ordenado um elemento por vez, pegando o próximo elemento e inserindo-o na posição correta em relação aos elementos já analisados (semelhante a ordenar cartas na mão).
*   **Quick Sort:** Algoritmo de divisão e conquista. Escolhe um pivô (nesta implementação, o último elemento via particionamento de Lomuto) e particiona o vetor de forma que elementos menores fiquem à esquerda e maiores à direita, chamando a si mesmo recursivamente para as partições.

### Tabela de Complexidade Teórica

| Algoritmo | Complexidade de Tempo (Melhor) | Tempo (Médio) | Tempo (Pior) | Complexidade de Espaço |
| :--- | :--- | :--- | :--- | :--- |
| **Busca Linear** | $O(1)$ | $O(N)$ | $O(N)$ | $O(1)$ |
| **Busca Binária** | $O(1)$ | $O(\log N)$ | $O(\log N)$ | $O(1)$ |
| **Bubble Sort** | $O(N)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Selection Sort** | $O(N^2)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Insertion Sort** | $O(N)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Quick Sort** | $O(N \log N)$ | $O(N \log N)$ | $O(N^2)$ | $O(\log N)$ méd. / $O(N)$ pior |

---

## 2. Tabelas Comparativas de Resultados (Benchmarking Real)

### 2.1. Desempenho dos Algoritmos de Ordenação

| Algoritmo | Vetor N | Aleatório | Já Ordenado | Inverso Ordenado | C/ Duplicatas |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Bubble Sort | 1.000 | 2,15 ms | 0,01 ms | 0,99 ms | 1,38 ms |
| Bubble Sort | 10.000 | 33,19 ms | 0,00 ms | 76,04 ms | 39,54 ms |
| Bubble Sort | 50.000 | 1148,43 ms | 0,01 ms | 1773,82 ms | 888,15 ms |
| Bubble Sort | 500.000 | > Demorado | > Demorado | > Demorado | > Demorado |
| Bubble Sort | 1.000.000 | > Demorado | > Demorado | > Demorado | > Demorado |
| Selection Sort | 1.000 | 1,21 ms | 2,23 ms | 0,19 ms | 0,17 ms |
| Selection Sort | 10.000 | 14,33 ms | 14,17 ms | 17,86 ms | 14,57 ms |
| Selection Sort | 50.000 | 362,26 ms | 352,17 ms | 441,37 ms | 353,14 ms |
| Selection Sort | 500.000 | > Demorado | > Demorado | > Demorado | > Demorado |
| Selection Sort | 1.000.000 | > Demorado | > Demorado | > Demorado | > Demorado |
| Insertion Sort | 1.000 | 0,96 ms | 0,00 ms | 0,84 ms | 0,15 ms |
| Insertion Sort | 10.000 | 12,95 ms | 0,01 ms | 7,25 ms | 2,82 ms |
| Insertion Sort | 50.000 | 87,82 ms | 0,03 ms | 179,43 ms | 71,45 ms |
| Insertion Sort | 500.000 | > Demorado | > Demorado | > Demorado | > Demorado |
| Insertion Sort | 1.000.000 | > Demorado | > Demorado | > Demorado | > Demorado |
| Quick Sort | 1.000 | 0,20 ms | 0,88 ms | 0,90 ms | 0,23 ms |
| Quick Sort | 10.000 | 0,47 ms | 17,03 ms | 15,14 ms | 3,59 ms |
| Quick Sort | 50.000 | 1,86 ms | StackOverflow | StackOverflow | 92,69 ms |
| Quick Sort | 500.000 | 23,24 ms | StackOverflow | StackOverflow | StackOverflow |
| Quick Sort | 1.000.000 | 48,37 ms | StackOverflow | StackOverflow | StackOverflow |

### 2.2. Desempenho dos Algoritmos de Busca (Pior Caso: Alvo não existente)

| Algoritmo | Vetor N | Tempo (Pior Caso) |
| :--- | :--- | :--- |
| Busca Linear | 1.000 | 0,0079 ms |
| Busca Linear | 10.000 | 0,0508 ms |
| Busca Linear | 50.000 | 0,2445 ms |
| Busca Linear | 500.000 | 0,6270 ms |
| Busca Linear | 1.000.000 | 0,6272 ms |
| Busca Binária | 1.000 | 0,0012 ms |
| Busca Binária | 10.000 | 0,0006 ms |
| Busca Binária | 50.000 | 0,0005 ms |
| Busca Binária | 500.000 | 0,0006 ms |
| Busca Binária | 1.000.000 | 0,0010 ms |

---


## Conclusão:
*   **Insertion Sort / Bubble (otimizado):** São excelentes e econômicos em memória para vetores pequenos ou conjuntos que estão rotineiramente quase ordenados.
*   **Quick Sort:** É a escolha definitiva para conjuntos de dados massivos e distribuídos aleatoriamente. Para evitar as falhas de *StackOverflow* em produção com dados pré-ordenados, seria necessário implementar estratégias de mitigação, como a escolha de pivô aleatório ou a técnica da "mediana de três".
*   **Busca:** A Busca Binária prova que investir recurso computacional para ordenar os dados previamente é fundamental. Para procurar um dado num vetor com 1 milhão de posições, a Busca Binária precisou de meros 0,0010 ms contra os já perceptíveis 0,6272 ms da Busca Linear – e essa disparidade cresce de forma acentuada em cenários de banco de dados e arquivos massivos.