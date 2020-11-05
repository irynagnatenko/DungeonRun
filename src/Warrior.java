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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
