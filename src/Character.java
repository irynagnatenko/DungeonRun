
import java.io.Serializable;

public class Character implements Serializable{
    
    private String name;
    private int initiative;
    private int endurance;
    private int attack;
    private int flexibility;

    //Hero constructor// HEJ fr�n Johanna
    Character(String name, int initiative, int endurance, int attack, int flexibility) {
        this.name = name;
        this.initiative = initiative;
        this.endurance = endurance;
        this.attack = attack;
        this.flexibility = flexibility;
    }
    
    //Monster constructor
    Character(int initiative, int endurance, int attack, int flexibility) {
        this.initiative = initiative;
        this.endurance = endurance;
        this.attack = attack;
        this.flexibility = flexibility;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(int flexibility) {
        this.flexibility = flexibility;
    }

    @Override
    public abstract String toString(); 
}
