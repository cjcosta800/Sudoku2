import java.util.Scanner;

public class Sudoku2 {

    public static void main(String[] args) {
        int[][] quadricula = gq();
        imprimirQD(quadricula);
    }
    /**
     * imprime uma matriz no terminal
     * @param matriz matriz a ser impriida
    */
    public static void imprimirQD(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) { // linha
            for (int j = 0; j < matriz.length; j++) // coluna
                System.out.print(matriz[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * Gera uma quadrícula de 9x9 preenchidada com números de 1 a 9
     * @return quadrícula inserida numa matriz
     */public static int[][] gq () {
    int [][] quadricula = new int[9][9]; 
    for(int i = 0; i < quadricula.length; i++) {
        for(int o = 0; o < quadricula.length; o++)
            quadricula[i][o] = (i / 3 + 3 * (i % 3) + o) % 9 + 1;
        System.out.println();
    }
    return quadricula;
}

    /**
     * Faz a permutação dos valores de duas linhas escolhidas numa matriz
     * Obs: Ter em conta que o índice das linhas começa em 0
     * @param matriz matriz a ser modificada
     * @param linha1 primeira linha a permutar
     * @param linha2 segunda linha a permutar
     */
    public static void permutarLinhas(int[][] matriz, int linha1, int linha2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[linha1][i];
            matriz[linha1][i] = matriz[linha2][i];
            matriz[linha2][i] = auxiliar;
        }
    }
    
    /**
     * Faz a permutação dos valores de duas colunas escolhidas numa matriz
     * Obs: Ter em conta que o índice das colunas começa em 0
     * @param matriz matriz a ser modificada
     * @param linha1 primeira coluna a permutar
     * @param linha2 segunda coluna a permutar
     */
    public static void permutarColunas(int[][] matriz, int coluna1, int coluna2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[i][coluna1];
            matriz[i][coluna1] = matriz[i][coluna2];
            matriz[i][coluna2] = auxiliar;
        }
    }
    
    /**
     * Faz a permutação dos valores de duas faixa horizontais escolhidas numa matriz de 9x9.
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a ser permutar
     * @param faixa2 segunda faixa a ser permutar
     * @requires {@code (faixa1 >= 1 && faixa1 <= 3) && (faixa2 >= 1 && faixa2 <=)}
     */
    public static void permutarFaixasHorizontais(int[][] matriz, int faixa1, int faixa2) {
        int auxiliarm, linha1 = 0, coluna2 = 0;
        switch (faixa1) {
            case 2:
                linha1 = 3;
                break;
            case 3:
                linha1 = 6;
                break;
        }
        switch (faixa2) {
            case 2:
                linha2 = 3;
                break;
            case 3:
                linha2 = 6;
                break;
        }
        for (int i = 0; i < matriz.length/3; i++) {
            for (int o = 0; o < matriz.length; o++) {
                auxiliar = matriz[linha1][o];
                matriz[linha1][o] = matriz[linha2][o]; 
                matriz[linha2][o] = auxiliar;
            }
            linha1++;
            linha2++;
        }
    }

    /**
     * Faz a permutação dos valores de duas faixa verticais escolhidas numa matriz de 9x9
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a permutar
     * @param faixa2 segunda faixa a permutar
     * @requires {@code (faixa1 >= 1 && faixa1 <= 3) && (faixa2 >= 1 && faixa2 <=)}
     */
    public static void permutarFaixasVerticais(int[][] matriz, int faixa1, int faixa2) {
        int auxiliar, coluna1 = 0, coluna2 = 0;
        switch (faixa1) {
            case 2:
                coluna1 = 3;
                break;
            case 3:
                coluna1 = 6;
                break;
        }
        switch (faixa2) {
            case 2:
                coluna2 = 3;
                break;
            case 3:
                coluna2 = 6;
                break;
        }
        for (int i = 0; i < matriz.length/3; i++) {
            for (int o = 0; o < matriz.length; o++) {
                auxiliar = matriz[o][coluna1];
                matriz[o][coluna1] = matriz[o][coluna2]; 
                matriz[o][coluna2] = auxiliar;
            }
            coluna1++;
            coluna2++;
        }
    }
}
