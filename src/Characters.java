package gameoflitrones;

/**
 *
 * @author iagon
 */
enum characterType{
    GUERREIRO(1), 
    MAGO(2), 
    NINJA(3), 
    GOBLIN(4), 
    EFOGO(5),
    DRAGÃO(6);
     
    private final int valor;
    characterType(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
public class Characters {
    private int id,hp,mp,exp,atk,esq,rFogo,rGelo,status;
    private int position;
    private String name;
    
    public Characters(){
        this.name = "bot";
        this.hp = 10;
    }
    
    public Characters(String name){
        this.name = name;
    }
    
    /**
     * Métodos Setteres
     */
    public void setName(String s){
        this.name = s;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setMp(int mp){
        this.mp = mp;
    }
    public void setExp(int exp){
        this.exp = exp;
    }
    public void setAtk(int atk){
        this.atk = atk;
    }
    public void setEsq(int esq){
        this.esq = esq;
    }
    public void setRFogo(int rFogo){
        this.rFogo = rFogo;
    }
    public void setRGelo(int rGelo){
        this.rGelo = rGelo;
    }
    public void setPosition(int position){
        this.position = position;
    }
    
    // Métodos Getteres
    public String getName(){return this.name;}
    public int getPosition(){return this.position;}
    public int getHp(){return this.hp;}
    
    public void attack(Characters opponent){
        System.out.println(this.name+" atacou "+ opponent.getName());
        defense(opponent);
    }
    
    public void defense(Characters opponent){
    }
}
