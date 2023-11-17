/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Priscyla de Paula
 */
public class LerMapa {

    private Scanner scan;
    String nome, linha;
    int nLinhas, nColunas, i;
    char mapa[][];

    boolean lendoArquivo() {
        scan = new Scanner(System.in);

        System.out.print("Nome do arquivo: ");
        nome = scan.nextLine();

        try {
            FileReader arquivo = new FileReader(nome);
            try (BufferedReader lerArquivo = new BufferedReader(arquivo)) {
                linha = lerArquivo.readLine();
                nLinhas++;

                for (int j = 0; j < linha.length(); j++) {
                    nColunas++;
                }
                for (i = 1; linha != null; i++) {
                    linha = lerArquivo.readLine();
                    if (linha != null)
                        nLinhas++;
                }
            }
            arquivo.close();
            mapaMatriz(nome);
            return true;
        } catch (IOException e) {
            System.err.println("Não foi possível abrir o arquivo! " + e.getMessage());
            return false;
        }
    }

    void mapaMatriz(String nome) {
        int j;
        char[][] mapaJogo = new char[nLinhas][nColunas];

        try {
            FileReader arquivo = new FileReader(nome);
            try (BufferedReader lerArquivo = new BufferedReader(arquivo)) {
                String lin = lerArquivo.readLine();

                for (j = 0, i = 0; j < lin.length(); j++) {
                    mapaJogo[i][j] = lin.charAt(j);
                }
                for (i = 1; lin != null; i++) {
                    lin = lerArquivo.readLine();
                    for (j = 0; j < nColunas; j++) {
                        if (i < nLinhas) {
                            mapaJogo[i][j] = lin.charAt(j);
                        }
                    }
                }
            }

            arquivo.close();
        } catch (IOException e) {
            System.err.println("Não foi possível abrir o arquivo! " + e.getMessage());
        }
        mapa = mapaJogo;
    }

    int getLinhas() {
        return nLinhas;
    }

    int getColunas() {
        return nColunas;
    }

    char[][] getMapa() {
        return mapa;
    }

}
