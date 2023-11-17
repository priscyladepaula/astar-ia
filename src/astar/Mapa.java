/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 * @author Priscyla de Paula
 */ 

public final class Mapa {
    int nlinhas;
    int ncolunas;
    char[][] map; 
    Node[][] newMap;
    Node origem;
    Node destino;
    Node parede;
    
    Mapa(char[][] mapa, int linhas, int colunas){
        this.map = mapa.clone();
        this.nlinhas = linhas;
        this.ncolunas = colunas;

        criaMapa();
        vizinhos();
    }
    //função para pegar o conteúdo do arquivo e passar para uma nova matriz com os nós
    void leMapa(){
        for(int i = 0; i < nlinhas; i++){
            for(int j = 0; j < ncolunas; j++){
                if(map[i][j] == '2'){
                    newMap[i][j].entrada = true;
                    origem = new Node(i,j);
                }
                if(map[i][j] == '3'){
                    newMap[i][j].saida = true;
                    destino = new Node(i,j);
                }
                if(map[i][j] == '1'){
                    newMap[i][j].bloqueio = true;
                }
            }
        }
    }
    
    //depois do mapa criado, cada caracter reconhecido, é um nó no novo mapa
    void criaMapa(){
        Node no;
        newMap = new Node[nlinhas][ncolunas];
        for(int i = 0; i < nlinhas; i++){
            for(int j = 0; j < ncolunas; j++){
                no = new Node(i, j);
                newMap[i][j] = no;
            }
        }
        leMapa();
    }
    
    //função para percorrer nos 8 lados de nada nó
    void vizinhos(){
        Node no;
        for(int i = 0; i < nlinhas-1; i++){
            for(int j = 0; j < ncolunas-1; j++){
                no = newMap[i][j];
                
                if(j != 0){
                    no.setCima(newMap[i][j-1]);
                }
                if(j != ncolunas){
                    no.setBaixo(newMap[i][j+1]);
                }
                if(i != 0){
                    no.setEsquerda(newMap[i-1][j]);
                }
                if(i != nlinhas){
                    no.setDireita(newMap[i+1][j]);
                }
                if(j != 0 && i != ncolunas){
                    no.setDiagonalSuperiorDireito(newMap[i+1][j-1]);
                }
                if(i != 0 && j != 0){
                    no.setDiagonalSuperiorEsquerdo(newMap[i-1][j-1]);
                }
                if(i != ncolunas && j != nlinhas){
                    no.setDiagonalInferiorDireito(newMap[i+1][j+1]);
                }
                if(i != 0 && j != nlinhas){
                    no.setDiagonalInferiorEsquerdo(newMap[i-1][j+1]);
                }
            }
        }
    }
    
    //função para retornar a quantidade da distância do nó inicial até o final do mapa
    float Distancia(Node inicio, Node fim){
        if(inicio.x == fim.x && inicio.y == fim.y){
            return 10 * (nlinhas + ncolunas); //conta em linha reta
        }
        else{
            return 14 * (nlinhas + ncolunas); //conta caso percorrer em diagonal
        }
    }
    
    Node getOrigem(){
        return origem;
    }
    
    Node getDestino(){
        return destino;
    }
    
    Node[][] getNewMap(){
        return newMap;
    }
    
    Node getNode(int x, int y){
        return newMap[x][y];
    }
    
    void setInicio(int x, int y){
        newMap[x][y].entrada = true;
        origem.x = x;
        origem.y = y;
    }
    
    void setFim(int x, int y){
        newMap[x][y].saida = true;
        destino.x = x;
        destino.y = y;
    }
    
    Node getNodeInicio(){
        return newMap[origem.x][origem.y];
    }
    
    int getLocacaoFinalX(){
        return destino.x;
    }
    
    int getLocacaoFinalY(){
        return destino.y;
    }
}
