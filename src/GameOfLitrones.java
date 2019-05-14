package gameoflitrones;

/**
 *
 * @author iagon
 */
public class GameOfLitrones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("------------------ GAME OF LITRONES ------------------");
        Maps map = new Maps();
        map.randomMap(5, 0.4);
        System.out.println("Qtd Celulas: "+map.getVertex()+"\nQtd Ligações:"+map.getEdges());
    }
    
}
