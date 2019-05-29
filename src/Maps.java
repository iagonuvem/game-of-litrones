package gameoflitrones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe Responsavel pelos mapas, que será modelado através de um grafo
 * @author Iago Nuvem
 */
public class Maps {
    private String name;
    private double difficulty;
    private int graphInfo[];
    private int adjMatrix[][];
    
    /**
     * Construtor com dificuldade por parametro
     * @param d {Nível de dificuldade | entre 0 e 1}
     */
    public Maps(double d){
        this.graphInfo = new int[2];
        this.adjMatrix = null;
        this.difficulty = d;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
   
    public int getVertex(){
        return this.graphInfo[0];
    }
    
    public int getEdges(){
        return this.graphInfo[1];
    }
    
    
    public int[][] getAdjMatrix(){
        return this.adjMatrix;
    }
    public double getDifficulty(){
        return this.difficulty;
    }
    
    public void setAdjMatrix(int[][] m){
        this.adjMatrix = m;
    }
    
    /**
     * Retorna um vetor com as celulas adjacentes
     * @param i {numero da celula}
     * @return 
     */
    public int[] getAdjList(int i){
        List<Integer> ints = new ArrayList<>();
        for(int j = 0; j < this.graphInfo[0]; j++){
            if(this.adjMatrix[i][j] != 0){
                ints.add(j);
            }
        }
        
        int size = ints.size();
        int[] result = new int[size];
        Integer[] temp = ints.toArray(new Integer[size]);
        for (int n = 0; n < size; n++) {
            result[n] = temp[n];
        }

        return result;
    }
    
    /**
     * Função que cria um padrão DIMACS randomico de acordo com o número de vertices e arestas passado
     * @param e {int | numro de vertices}
     * @param d {double | densidade entre 0 e 1}
     * @return 
     */
    public int[][] randomMap(int e, double d){
        Random random = new Random(); // Instancia da class Random

        // Seta dados do grafo
        this.graphInfo[0] = e;
        this.graphInfo[1] = 0;
        
        // Aloca espaço para a matriz
        this.adjMatrix = new int[e][e];
        
        //Preenche matriz de incidencia aleatoriamente
        for(int i = 0; i < this.graphInfo[0]; ++i){
            boolean connected = false; // Prevenção para não haver vértices isolados (não faz sentido no jogo)
            for(int j = 0; j < this.graphInfo[0]; ++j){
                if(i == j){ // Previne a existencia de laços no grafo (serão utilizados para outra finalidade)
                    this.adjMatrix[i][j] = 0;
                }
                else{
                    // Número aleatório de 0 a 1
                    double num = random.nextDouble();
                    
                    // Se numero randomico estiver no intervalo 0 ~ Densidade, gera um valor entre 1 e 100 (prob batalha), senão coloca 0
                    if(num <= d){ 
                        this.adjMatrix[i][j] = 1;
                        this.graphInfo[1]++;
                        connected = true;
                    }
                    else{
                        this.adjMatrix[i][j] = 0;
                    }
                }
            }
            if(connected == false){
                int num = random.nextInt((this.graphInfo[0]-1));
                
                // Prevenção de existencia de laços
                if(num == i && num == 0){
                    num++;
                }
                else if(num == i && num > 1){
                    num--;
                }
                
                this.adjMatrix[i][num] = 1;
                this.graphInfo[1]++;
            }
        }
        return this.adjMatrix;
    }
    
    /**
     * Função que le arquivo txt no formato DIMACS e retorna Matriz de Adjacencia
     * @param path {caminho do arquivo}
     * @return {Matriz de Adjacencia}
     */
    public int[][] fileToAdjMatrix(String path){       
        try{
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            
            // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            String linha = lerArq.readLine();
            
            String stringData[] = new String[2];
            stringData = linha.split(" ");
            
            this.graphInfo[0] = Integer.parseInt(stringData[0]);
            this.graphInfo[1] = Integer.parseInt(stringData[1]);
            
             // Cria matriz de adjacencia V por V
            this.adjMatrix = new int[this.graphInfo[0]][this.graphInfo[0]];
            
            //Preenche matriz de adjacencia com 0
            for(int i = 0; i < this.graphInfo[0]; ++i){
               for(int j = 0; j < this.graphInfo[0]; ++j){
                    this.adjMatrix[i][j] = 0;
               }
            }
            
            // Lê todo o arquivo e vai preenchendo por posição da matriz com o peso
            while((linha = lerArq.readLine()) != null){
                String data[] = new String[3];
                data = linha.split(" ");
                
                this.adjMatrix[Integer.parseInt(data[0])-1][Integer.parseInt(data[1])-1] = Integer.parseInt(data[2]);
            }
           
            arq.close();
            
            return this.adjMatrix;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
            return null;
        }
        
        
    }
    
    public void printAdjMatrix(){
        for(int i = 0; i < this.adjMatrix.length; i++){
            for(int j = 0; j < this.adjMatrix.length; j++){
                System.out.printf(this.adjMatrix[i][j]+"\t");
            }
            System.out.printf("\n");
        }
    }
}
