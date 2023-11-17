/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.ArrayList;

/**
 * @author Priscyla de Paula
 */ 
public class Node {
    float g; //distância
    float h; //heuristica
    int x = 0;
    int y = 0;
    Node pai; //antecessor do nó atual
    
    Node cima;
    Node baixo;
    Node esquerda;
    Node direita;
    Node diagonalSuperiorDireito;
    Node diagonalSuperiorEsquerdo;
    Node diagonalInferiorDireito;
    Node diagonalInferiorEsquerdo;
    boolean entrada;
    boolean saida;
    boolean bloqueio;
    boolean visitado;
    ArrayList<Node> listaVizinhos;
    
    Node(int x, int y){
        this.x = x;
        this.y = y;
        listaVizinhos = new ArrayList<>();
        this.entrada = false;
        this.saida = false;
        this.bloqueio = false;
        this.visitado = false;
        this.g = Float.MAX_VALUE;
    }
    //funções abaixo, para detectar os vizinhos e fazer a lista deles por cada passo no mapa
    void setCima(Node cima){
        this.cima = cima;
        
        if(listaVizinhos.contains(this.cima)){
            listaVizinhos.remove(this.cima);
        }
        listaVizinhos.add(cima);
    }
    
    void setBaixo(Node baixo){
        this.baixo = baixo;
        
        if(listaVizinhos.contains(this.baixo)){
            listaVizinhos.remove(this.baixo);
        }
        listaVizinhos.add(baixo);
    }
    
    void setEsquerda(Node esquerda){
        this.esquerda = esquerda;
        
        if(listaVizinhos.contains(this.esquerda)){
            listaVizinhos.remove(this.esquerda);
        }
        listaVizinhos.add(esquerda);
    }
    
    void setDireita(Node direita){
        this.direita = direita;
        
        if(listaVizinhos.contains(this.direita)){
            listaVizinhos.remove(this.direita);
        }
        listaVizinhos.add(direita);
    }
    
    void setDiagonalSuperiorDireito(Node diagonalSuperiorDireito){
        this.diagonalSuperiorDireito = diagonalSuperiorDireito;
        
        if(listaVizinhos.contains(this.diagonalSuperiorDireito)){
            listaVizinhos.remove(this.diagonalSuperiorDireito);
        }
        listaVizinhos.add(diagonalSuperiorDireito);
    }
    
    void setDiagonalSuperiorEsquerdo(Node diagonalSuperiorEsquerdo){
        this.diagonalSuperiorEsquerdo = diagonalSuperiorEsquerdo;
        
        if(listaVizinhos.contains(this.diagonalSuperiorEsquerdo)){
            listaVizinhos.remove(this.diagonalSuperiorEsquerdo);
        }
        listaVizinhos.add(diagonalSuperiorEsquerdo);
    }
    
    void setDiagonalInferiorDireito(Node diagonalInferiorDireito){
        this.diagonalInferiorDireito = diagonalInferiorDireito;
        
        if(listaVizinhos.contains(this.diagonalInferiorDireito)){
            listaVizinhos.remove(this.diagonalInferiorDireito);
        }
        listaVizinhos.add(diagonalInferiorDireito);
    }
    
    void setDiagonalInferiorEsquerdo(Node diagonalInferiorEsquerdo){
        this.diagonalInferiorEsquerdo = diagonalInferiorEsquerdo;
        
        if(listaVizinhos.contains(this.diagonalInferiorEsquerdo)){
            listaVizinhos.remove(this.diagonalInferiorEsquerdo);
        }
        listaVizinhos.add(diagonalInferiorEsquerdo);
    }
    
    boolean equals(Node no){
        return (no.x == x && no.y == y);
    }
    
    int compareTo(Node o){
        float f = g + h;
        float of = o.g + o.h;
        
        if(f < of){
            return -1;
        }
        else if(f > of){
            return 1;
        }
        else{
            return 0;
        }
    }
}