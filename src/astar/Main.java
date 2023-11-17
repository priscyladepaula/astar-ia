/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 * @author Priscyla de Paula
 */
public class Main {
    public static void main(String args[]) {

        LerMapa mapa = new LerMapa();
        boolean arqExiste = mapa.lendoArquivo();

        if (arqExiste) {
            Mapa newMapa = new Mapa(mapa.getMapa(), mapa.nLinhas, mapa.nColunas);

            AStar star = new AStar(newMapa, newMapa.getOrigem(), newMapa.getDestino());
            star.melhorCaminho();
            star.imprimeMapa();
        }
    }
}
