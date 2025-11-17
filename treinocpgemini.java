import java.util.Scanner;

public class treinocpgemini {

    /**
     * Solução para o exercício de análise de DNA, utilizando modularização.
     * O programa lê duas sequências de DNA e compara a similaridade posicional,
     * usando métodos distintos para validação e comparação.
     */

    /**
     * O método principal (main) é responsável por orquestrar o programa:
     * 1. Ler os dados de entrada.
     * 2. Normalizar os dados.
     * 3. Chamar os métodos de validação.
     * 4. Chamar o método de comparação, se os dados forem válidos.
     * [cite: 34, 36]
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // a) Leitura das strings
        System.out.println("Digite a sequência do suposto pai (A, C, G, T):");
        String dnaPai = teclado.nextLine();
        System.out.println("Digite a sequência do filho (A, C, G, T):");
        String dnaFilho = teclado.nextLine();

        // b) Normalização das entradas (convertendo para maiúsculas)
        dnaPai = dnaPai.toUpperCase();
        dnaFilho = dnaFilho.toUpperCase();

        // c) e d) Validação dos dados

        // 1. Validar comprimento
        if (dnaPai.length() != dnaFilho.length()) {
            System.out.println("\n--- ERRO ---");
            System.out.println("As sequências de DNA devem ter o mesmo comprimento para comparação.");
        }
        // 2. Validar caracteres (usando uma função auxiliar)
        // A chamada da função 'ehSequenciaValida' passa os argumentos [cite: 159]
        else if (!ehSequenciaValida(dnaPai) || !ehSequenciaValida(dnaFilho)) {
            System.out.println("\n--- ERRO ---");
            System.out.println("As sequências devem conter apenas os caracteres A, C, G, ou T.");
        }
        // e) Se tudo estiver válido, realiza a comparação
        else {
            // Chamamos um procedimento para comparar e imprimir o resultado [cite: 374]
            compararEImprimir(dnaPai, dnaFilho);
        }

        teclado.close();
    }

    /**
     * FUNÇÃO para validar a sequência de DNA. [cite: 393]
     * Verifica se a string contém apenas os caracteres 'A', 'C', 'G', 'T'.
     *
     * @param dna A string de DNA a ser validada (parâmetro de entrada) [cite: 100, 103]
     * @return true se a sequência for válida, false caso contrário (tipo de retorno) [cite: 104]
     */
    public static boolean ehSequenciaValida(String dna) {
        // 'i' e 'nucleotideo' são variáveis locais deste método [cite: 170, 735]
        for (int i = 0; i < dna.length(); i++) {
            char nucleotideo = dna.charAt(i);

            // Se o caractere não for um dos válidos, retorna 'false'
            if (nucleotideo != 'A' && nucleotideo != 'C' && nucleotideo != 'G' && nucleotideo != 'T') {
                return false; // O comando 'return' encerra o método [cite: 114, 116]
            }
        }

        // Se o loop terminar sem encontrar erros, a string é válida
        return true;
    }

    /**
     * PROCEDIMENTO para comparar duas sequências de DNA válidas e imprimir o resultado. [cite: 374]
     * Este método tem o tipo de retorno 'void' (procedimento).
     *
     * @param pai   A sequência de DNA do pai (parâmetro) [cite: 173]
     * @param filho A sequência de DNA do filho (parâmetro) [cite: 173]
     */
    public static void compararEImprimir(String pai, String filho) {
        // 'diferencas', 'totalGenes', 'genesIguais' e 'porcentagem'
        // são variáveis locais do método 'compararEImprimir' [cite: 735]
        int diferencas = 0;
        int totalGenes = pai.length(); // Sabemos que têm o mesmo tamanho

        // Compara posição a posição
        for (int i = 0; i < totalGenes; i++) {
            if (pai.charAt(i) != filho.charAt(i)) {
                diferencas++;
            }
        }

        // Imprime os resultados
        System.out.println("\n--- Resultado da Análise ---");

        if (diferencas == 0) {
            System.out.println("Sequências idênticas.");
        } else {
            System.out.println("As sequências não são idênticas.");
            System.out.println("Diferem em " + diferencas + " genes (posições).");
        }

        // Cálculo da porcentagem de similaridade
        int genesIguais = totalGenes - diferencas;

        // (Introdução Java: Conversão para double é necessária para a divisão decimal)
        double porcentagemSimilaridade = ((double) genesIguais / totalGenes) * 100.0;

        // (Introdução Java: String.format para limitar as casas decimais)
        System.out.println("Similaridade = " + String.format("%.2f", porcentagemSimilaridade) + "%.");
    }
}

