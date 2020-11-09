package src;

public class Warrior extends Character {
    
    final String hero = "Warrior";
   
    public Warrior(String name, int initiativ, int tålighet, int attack, int smidighet) {
        super(name,initiativ,  tålighet,  attack, smidighet);
    }
    
    
    //Specialability();
    //FIRST impact per battle = blockchance 100%
    // from battle call method - hero.SpecialAbility(); - with body??

    @Override
    public String toString() {
        return this.hero + "\nNamn: " + this.getName() + "\nInitiativ: " + this.getInitiative() + "\nTålighet: " + this.getEndurance() + "\nAttack: " + this.getAttack() + "\nSmidighet: " + this.getFlexibility();
    }
    
}
