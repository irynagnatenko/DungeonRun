public class Thief extends Character {
    
    final String hero = "Thief";

    public Thief(String name, int initiative, int endurance, int attack, int flexibility){
           super(name,initiative,endurance,attack,flexibility);
     }
    
    @Override
    public String toString() {
        return this.hero + "\nNamn: " + this.getName() + "\nInitiativ: " + this.getInitiative() + "\nTålighet: " + this.getEndurance() + "\nAttack: " + this.getAttack() + "\nSmidighet: " + this.getFlexibility();
    }
}
