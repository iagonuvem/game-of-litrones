package gameoflitrones;

import java.util.*;
import java.io.*;

/**
 *
 * @author iagon
 */
public class Game {
    public Battlefield battlefield;
    
    public Game(Battlefield b){
        this.battlefield = b;
    }
    
    public String readString(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try { 
            s = in.readLine(); 
            return s;
        } catch (IOException ioe) { 
            System.out.println("IO erro tentando ler o nome"); 
            System.exit(1); 
        } 
        return "";
    }
    
    public void playerInfo(Characters c){
        System.out.println("________________________________");
        System.out.println("| "+c.getName());
        System.out.println("| Hp: "+c.getHp()+"\t| Atk: "+c.getAtk()+"\t|");
        System.out.println("| Esq: "+c.getEsq()+"\t| Magia: "+c.getMp()+"\t|");
        System.out.println("| Res.Gelo: "+c.getRgelo()+"\t| Res.Fogo: "+c.getRfogo()+"\t|");
        System.out.println("________________________________");
    }
    
    public int getMove(Characters p){
        int n;
        Scanner ler = new Scanner(System.in);
        
        System.out.println("\nVocê está em: "+p.getPosition());
        System.out.println("Para onde deseja se mover?");
        this.battlefield.printAdjList(p.getPosition());
        n = ler.nextInt();
        while(!(this.battlefield.checkMovement(p.getPosition(),n))){
            System.out.println("ENTRADA INVÁLIDA! Digite novamente...");
            n = ler.nextInt();
        }
        return n;
    }
    
    public boolean confirmMove(int destination){
        Scanner ler = new Scanner(System.in);
        System.out.println("Veja os perigos que te aguardam nessa celula:");
        this.battlefield.getCell(destination).printMonstersName();
        System.out.printf("Deseja continuar? (s/n)");
        char bool = ler.next().charAt(0);
            
        while(!(bool == 's' || bool == 'n')){
            System.out.println("ENTRADA INVÁLIDA! Digite novamente...");
        }
        if(bool == 'n'){
            return false;
        }
        return true;
    }
}
