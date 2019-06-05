package gameoflitrones;

import java.util.*;
import java.io.*;
/**
 *
 * @author iagon
 */
public class GameOfLitrones {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("-------------------------------------------------");
        System.out.println("|\t\t GAME OF LITRONES \t\t|");
        System.out.println("-------------------------------------------------");
        
        System.out.printf("Selecione um mapa:\n(1) Novo Mapa\t(2) Abrir Mapa\n");
        int n = ler.nextInt();
        
        while(!(n == 1 || n == 2)){
            System.out.println("ENTRADA INVÁLIDA! Digite novamente...");
            n = ler.nextInt();
        }
        
        if(n == 1){
            System.out.println("\nXXXXXXXXXXXXXXX EDIÇÃO DE MAPA XXXXXXXXXXXXXX");
            System.out.printf("Nome do mapa: ");
            String name = null; 
            try { 
               name = in.readLine(); 
            } catch (IOException ioe) { 
               System.out.println("IO erro tentando ler o nome"); 
               System.exit(1); 
            } 
            System.out.printf("Digite a quantidade de celulas: ");
            int cells = ler.nextInt();
            System.out.printf("Digite a densidade de ligações (entre 1 e 100 porcento): ");
            double density = (double)ler.nextInt()/100;
            System.out.printf("Digite a dificuldade do mapa (entre 1 e 100 porcento): ");
            double difficulty = (double)ler.nextInt()/100;
            
            Maps map = new Maps(difficulty);
            map.setName(name);
            map.randomMap(cells, density);
            
            System.out.println("\nXXXXX "+name+" XXXXX");
            /**System.out.println("Qtd Celulas: "+map.getVertex()+"\nQtd Ligações:"+map.getEdges());;
            //map.printAdjMatrix();
            for(int i = 0; i < map.getVertex(); i++){
                System.out.printf("[%d]->",i);
                battlefield.printAdjList(i);
                System.out.printf("\n");
            }*/
            Battlefield battlefield = new Battlefield(map);
            Game game = new Game(battlefield);
            
            System.out.printf("Nome do Jogador: ");
            String player = game.readString();
            System.out.printf("Selecione o seu tipo de jogador:\n(1)Guerreiro\t(2)Mago\t(3)Ninja ");
            int type = ler.nextInt();
            while(!(type == 1 || type == 2 || type == 3)){
                System.out.println("ENTRADA INVÁLIDA! Digite novamente...");
                type = ler.nextInt();
            }
            
            System.out.println("\nIniciando Jogo...");
            Characters p1 = battlefield.newPlayer(player,type);
            game.playerInfo(p1);
            boolean battle = false;
            do{
                int destination = game.getMove(p1);
                boolean confirm = game.confirmMove(destination);
                while(!confirm){
                    destination = game.getMove(p1);
                    confirm = game.confirmMove(destination);
                }
                battle = battlefield.movePlayer(p1, destination);
                System.out.println("Voce esta em: "+p1.getPosition());
                if(battle){
                    Cells currentCell = battlefield.getCell(p1.getPosition());
                    boolean resume = currentCell.battle(p1);
                    if(!resume){
                        System.out.println("XXXXXXXX GAME OVER XXXXXXXX");
                    }else{
                        battle = false;
                    }
                }else{
                    System.out.println("Não houve batalha!");
                }
            }while(!battle);
            
            
            
        }else if(n == 2){
            // leitura do arquivo
        }
        
        
        
        
        
    }
    
}
