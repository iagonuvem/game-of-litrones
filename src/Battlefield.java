package gameoflitrones;

import java.util.*;

/**
 * Classe que representa o campo de batalha
 * @author Iago Nuvem
 */
public class Battlefield {
    private Maps map;
    private Cells[] cells;
    private Characters[] players;

    public Battlefield(){
        
    }
    
    // Construtor de acordo com o mapa
    public Battlefield(Maps m){
        this.map = m;
        Random random = new Random(); // Instancia da class Random
        
        int qtdCells = this.map.getVertex();
        
        int maxMonsterPerCell = 0;
        
        if(this.map.getDifficulty() <= 0.3){
            maxMonsterPerCell = 1;
        }
        else if(this.map.getDifficulty() <= 0.6){
            maxMonsterPerCell = 2;
        }
        else if(this.map.getDifficulty() <= 0.9){
            maxMonsterPerCell = 3;
        }
        else{
            maxMonsterPerCell = 6; // Modo hardcore
        }
        
        int[] monsters = new int[qtdCells];
        double[] prob = new double[qtdCells];
        this.cells = new Cells[qtdCells];
        
        for(int i = 0; i < qtdCells; ++i){
            if(random.nextDouble() <= this.map.getDifficulty()){
                monsters[i] = random.nextInt(maxMonsterPerCell);
            }
            else{
                monsters[i] = 0;
            }
            
            prob[i] = random.nextDouble();
            
            Cells c = new Cells(i,monsters[i],prob[i],0);
            this.cells[i] = c;
        }
        
    }
    
    public Characters newPlayer(String name, int type){
        Random random = new Random();
        int startCell = random.nextInt(this.cells.length);
        
        Characters p = new Characters(name,type);
        p.setPosition(startCell);
        
        return p;
    }
    
    /**
     * Verifica se um movimento é válido
     * @param start {Vértice de onde se deseja iniciar o movimento}
     * @param destination {Vértice onde se deseja chegar}
     * @return boolean
     */
    public Boolean checkMovement(int start, int destination){
        int[] adjList = this.map.getAdjList(start);
        for(int item: adjList){
            if(item == destination){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Move o personagem e retorna se houve batalha ou não
     * @param c {Characters | obj do personagem}
     * @param destination {int | celula destino}
     * @return 
     */
    public Boolean movePlayer(Characters c, int destination){
        Cells cell = getCell(destination);
        c.setPosition(destination);
        return cell.sortBattle(); //Se houver batalha
    }
    
    public Cells getCell(int i){
        return this.cells[i];
    }
    
    public void lockCell(int i){
        int[][] m = this.map.getAdjMatrix();
        if(m != null){
            m[i][i] = 1;
        }
        this.map.setAdjMatrix(m);
    }
    
    public void unlockCell(int i){
        int[][] m = this.map.getAdjMatrix();
        if(m != null){
            m[i][i] = 1;
        }
        this.map.setAdjMatrix(m);
    }
    
    public void printAdjList(int index){
        int[] a = this.map.getAdjList(index);
        for(int j = 0; j < a.length; j++){
            System.out.printf("[%d] ", a[j]);
        }
    }
    
}
