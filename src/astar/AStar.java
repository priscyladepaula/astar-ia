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
public class AStar {
    Mapa mapa;
    Node origem;
    Node destino;
    Node parede;
    Caminho caminhos; //variável para acessar a classe Caminho e a lista de caminho criado
    boolean vizinhos; //variável para acessar a lista de vizinhos, na classe Node
    ArrayList<Node> listaAberta = new ArrayList<>();
    ArrayList<Node> listaFechada = new ArrayList<>();
    
    AStar(Mapa mapa, Node origem, Node destino){
        this.mapa = mapa;
        this.origem = origem;
        this.destino = destino;
    }
    
    Caminho melhorCaminho(){
        
        float f; //total do custo acumulado e heurística
        
        mapa.setInicio(origem.x, origem.y);
        mapa.setFim(destino.x, destino.y);
        
        //aonde inicia a lista aberta, já pegando a origem de xy
        mapa.getNodeInicio().g = 0; 
        listaFechada.clear();
        listaAberta.clear();
        listaAberta.add(mapa.getNodeInicio());
        
        //enquanto a lista aberta não estiver vazia, cria-se um nó atual, para
        //fazer o reconhecimento dos vizinhos dele e percorrer pelo mapa
        while(!listaAberta.isEmpty()){
            Node atual = listaAberta.get(0);
            
            //quando chegar no seu destino final, retorna o caminho impresso na saída
            if(atual.x == destino.x && atual.y == destino.y){
                return criaCaminho(atual);
            }
            
            //cada caminho que ele passa, sai da lista aberta e passa para lista fechada
            listaAberta.remove(atual);
            listaFechada.add(atual);
            
            for(Node vizinho : atual.listaVizinhos){
                //se o vizinho foi percorrido e foi para lista fechada, a busca continua
                if(listaFechada.contains(vizinho)){
                    continue;
                }
                //quando não houver bloqueios, cada vizinho vai fazendo o cálculo
                //para achar o menor caminho
                if(!vizinho.bloqueio){
                    f = atual.g + mapa.Distancia(atual, vizinho);
                    
                    if(!listaAberta.contains(vizinho)){
                        listaAberta.add(vizinho);
                        vizinhos = true;
                    }
                    else if(f < atual.g){
                        vizinhos = true;
                    }
                    else{
                        vizinhos = false;
                    }
                    if(vizinhos){
                        vizinho.pai = atual;
                        vizinho.g = f;
                        vizinho.h = heuristicaManhatan(vizinho, mapa.destino);
                    }
                }
            }
        }
        
        return null;
    }
    
    //função pra calcular a distância de cada nó atual percorrido até o destino
    float heuristicaManhatan(Node atual, Node fim){
        float x, y;
        
        x = Math.abs(fim.x - atual.x);
        y = Math.abs(fim.y - atual.y);
        
        return x + y;
    }
   
    void imprimeMapa(){
        for(int i = 0; i < mapa.nlinhas; i++){
            System.out.println("");
            for(int j = 0; j < mapa.ncolunas; j++){
                Node no;
                no = mapa.getNode(i, j);
                
                if(no.entrada){
                    System.out.print("E ");
                }
                else if(no.saida){
                    System.out.print("S ");
                }
                else if(caminhos.contem(no.x, no.y)){
                    System.out.print("C ");
                }
                else if(no.bloqueio){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
        }
        System.out.println("");
    }
    
    Caminho criaCaminho(Node no){
        Caminho caminho = new Caminho();
        
        while(no.pai != null){
            caminho.addCaminho(no); //cada caminho, é adicionado
            no = no.pai; //e cada caminho adicionado, ele se torna o antecessor
        }
        this.caminhos = caminho;
        return caminho;
    }
    
}
