package src;

public class Mage extends Character {
    
    final String hero = "Mage";
    
    public Mage(String name, int initiative, int endurance, int attack, int flexibility){
           super(name,initiative,endurance,attack,flexibility);
    }
    
     @Override
    public String toString() {
        return this.hero + "\nNamn: " + this.getName() + "\nInitiativ: " + this.getInitiative() + "\nTålighet: " + this.getEndurance() + "\nAttack: " + this.getAttack() + "\nSmidighet: " + this.getFlexibility();
    }
}
