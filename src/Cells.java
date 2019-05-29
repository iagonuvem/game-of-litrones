/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflitrones;

import java.util.Random;

/**
 *
 * @author iagon
 */
public class Cells{
    private int index;
    private Characters[] monsters;
    private double combatProb;
    private int poison;
    
    public Cells(int index, int monsterQtd, double combatProb, int poison) {
        
        this.index = index;
        this.monsters = new Characters[monsterQtd];
        this.poison = poison;
        this.combatProb = combatProb;
        
        for(int i = 0; i < monsterQtd; i++){
            Characters m = new Characters();
            this.monsters[i] = m;
        }
    }
    
    public int getIndex(){return this.index;}
    
    /**
     * Função que "sorteia" se há batalha ou não de acordo com a probabilidade da celula
     * @return 
     */
    public boolean sortBattle(){
        Random random = new Random();
        double num = random.nextDouble();
        return this.combatProb > num;
    }
    
    /**
     * Função que realiza a batalha em turnos
     * @param c {Objeto que representa o personagem}
     */
    public void battle(Characters c){
    
    }
    
    /**
     * Método para imprimir os nomes de monstros dentro de uma celula
     */
    public void printMonstersName(){
        for(Characters monster : this.monsters) {
           System.out.println("["+monster.getName()+"]:\tAtk:"+monster.getName()+"\tDef:"+monster.getName()); 
        }
    }
    
}
