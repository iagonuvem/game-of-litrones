package gameoflitrones;

import java.util.Random;

/**
 *
 * @author iagon
 */

public class Characters {
    public enum characterType{
        GUERREIRO(1), 
        MAGO(2), 
        NINJA(3), 
        GOBLIN(4), 
        EFOGO(5),
        DRAGÃO(6);

        private final int valor;
        private int hp,mp,exp,atk,esq,rFogo,rGelo;
        
        characterType(int valorOpcao){
            valor = valorOpcao;

            switch(valorOpcao) {
                case 1: // Guerreiro
                  this.hp = 100;
                  this.exp = 10;
                  this.mp = 10;
                  this.atk = 100;
                  this.esq = 100;
                  this.rFogo = 100;
                  this.rGelo = 100;
                  break;
                case 2: // Mago
                  this.hp = 100;
                  this.exp = 10;
                  this.mp = 10;
                  this.atk = 120;
                  this.esq = 100;
                  this.rFogo = 100;
                  this.rGelo = 100;
                  break;
                case 3: // Ninja
                  this.hp = 100;
                  this.exp = 10;
                  this.mp = 10;
                  this.atk = 100;
                  this.esq = 100;
                  this.rFogo = 100;
                  this.rGelo = 100;
                  break;
                case 4: // Goblin
                  this.hp = 100;
                  this.exp = 10;
                  this.mp = 10;
                  this.atk = 100;
                  this.esq = 100;
                  this.rFogo = 100;
                  this.rGelo = 100;
                  break;
                case 5: // Efogo
                  this.hp = 100;
                  this.exp = 10;
                  this.mp = 10;
                  this.atk = 100;
                  this.esq = 100;
                  this.rFogo = 100;
                  this.rGelo = 100;
                  break;
                case 6: // Dragão
                  this.hp = 100;
                  this.exp = 10;
                  this.mp = 10;
                  this.atk = 100;
                  this.esq = 100;
                  this.rFogo = 100;
                  this.rGelo = 100;
                  break;
            }
        }
        public int getValor(){
            return valor;
        }
    }
    private int id,hp,mp,exp,atk,esq,rFogo,rGelo;
    private int position;
    private String name;
    private char status;
    private characterType type;
    
    public Characters(){
        Random random = new Random();
        this.name = "bot";
        this.hp = 10;
        this.exp = random.nextInt(10);
        this.status = 'v';
    }
    
    public Characters(String name){
        this.name = name;
        this.hp = 10;
        this.exp = 10;
        this.status = 'v';
    }
    public Characters(String name, int charType){
        this.name = name;
        this.exp = 10;
        this.status = 'v';
        
        switch(charType) {
            case 1:
              this.type = characterType.GUERREIRO;
              this.mp = characterType.GUERREIRO.mp;
              this.hp = characterType.GUERREIRO.hp;
              this.atk = characterType.GUERREIRO.atk;
              this.esq = characterType.GUERREIRO.esq;
              this.rFogo = characterType.GUERREIRO.rFogo;
              this.rGelo = characterType.GUERREIRO.rGelo;
              break;
            case 2:
              this.type = characterType.MAGO;
              this.mp = characterType.MAGO.mp;
              this.hp = characterType.MAGO.hp;
              this.atk = characterType.MAGO.atk;
              this.esq = characterType.MAGO.esq;
              this.rFogo = characterType.MAGO.rFogo;
              this.rGelo = characterType.MAGO.rGelo;
              break;
            case 3:
              this.type = characterType.NINJA;
              this.type = characterType.NINJA;
              this.mp = characterType.NINJA.mp;
              this.hp = characterType.NINJA.hp;
              this.atk = characterType.NINJA.atk;
              this.esq = characterType.NINJA.esq;
              this.rFogo = characterType.NINJA.rFogo;
              this.rGelo = characterType.NINJA.rGelo;
              break;
            case 4:
              this.type = characterType.GOBLIN;
              break;
            case 5:
              this.type = characterType.EFOGO;
              break;
            case 6:
              this.type = characterType.DRAGÃO;
              break;
        }
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
    public int getAtk(){return this.atk;}
    public int getExp(){return this.exp;}
    public int getEsq(){return this.esq;}
    public int getMp(){return this.mp;}
    public int getRfogo(){return this.rFogo;}
    public int getRgelo(){return this.rGelo;}
    public int getStatus(){return this.status;}
    
    public void attack(Characters opponent){
        System.out.println(this.name+" atacou "+ opponent.getName());
        opponent.setHp(opponent.getHp()-2);
        defense(opponent);
    }
    
    public void defense(Characters opponent){
    }
}
