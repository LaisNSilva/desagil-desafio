package br.pro.hashi.ensino.desagil.desafio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class Board {
    boolean[][] wall;
    int numRows;
    int numCols;

    // Ignore o "throws IOException" por enquanto.
    // Esse trecho será explicado em aulas futuras.
    void load(String name) throws IOException {

        // Estamos supondo que o arquivo está na pasta de recursos.
        // Nesse caso, o código abaixo obtém o endereço (URL) desse
        // arquivo a partir de seu nome e abre ele como um arquivo
        // de entrada (InputStream), ou seja, abre ele para leitura.
        URL url = getClass().getClassLoader().getResource(name);
        InputStream stream = Objects.requireNonNull(url).openStream();

        // Constrói um InputStreamReader a partir do arquivo de entrada. Isso é necessário
        // para ler caracteres desse arquivo. Também constrói um BufferedReader a partir
        // do InputStreamReader. Isso não é necessário mas é conveniente, pois permite usar
        // o método readLine. Sem o BufferedReader, teríamos que ler caractere por caractere.
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        // Estamos supondo que a primeira linha do arquivo é
        // formada por duas palavras separadas por um espaço
        // em branco. Nesse caso, o método readLine lê essa
        // linha e a devolve como uma string e o método split
        // quebra essa string em um vetor de strings, usando
        // como critério de separação um espaço em branco.
        String[] words = reader.readLine().split(" ");

        // Estamos supondo também que essas
        // duas palavras representam inteiros.
        // O primeiro é o número de linhas e
        // o segundo é o número de colunas.
        // Nesse caso, parseInt converte elas
        // para inteiros propriamente ditos.
        numRows = Integer.parseInt(words[0]);
        numCols = Integer.parseInt(words[1]);

        // Sabendo o número de linhas e o de
        // colunas, podemos construir a matriz.
        wall = new boolean[numRows][numCols];

        // Estamos supondo que as linhas restantes do
        // arquivo representam as linhas do tabuleiro.
        // Nesse caso, para cada uma dessas linhas...
        for (int i = 0; i < numRows; i++) {

            // ...usamos o método readLine para ler
            // essa linha e devolvê-la como string...
            String line = reader.readLine();

            // ...e analisamos cada um dos caracteres.
            for (int j = 0; j < numCols; j++) {
                char c = line.charAt(j);

                /*
                 * ESCREVA SEU CÓDIGO AQUI!
                 */
            }
        }
    }
}
