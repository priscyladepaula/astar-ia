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
public class Caminho {
    ArrayList<Node> listaCaminho = new ArrayList<>();
    
    Caminho(){
    }
    
    //função acessível para adicionar os nós
    void addCaminho(Node no){
        listaCaminho.add(0, no);
    }
    
    boolean contem(int x, int y){
        for(Node node : listaCaminho){
            if(node.x == x && node.y == y){
                return true;
            }
        }
        return false;
    }
}
