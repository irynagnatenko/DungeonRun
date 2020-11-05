/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */
public class Monster extends Character {
    public double vanlighet;

    public Monster (int initiativ, int tålighet, int attack, int smidighet, double vanlighet) {
        super(initiativ,  tålighet,  attack, smidighet);
        this.vanlighet = vanlighet;

    }

    public double getVanlighet() {
        return vanlighet;
    }

    public void setVanlighet(double vanlighet) {
        this.vanlighet = vanlighet;
    }

    @Override
    public String toString() {
        return "{" +
                "initiativ=" + initiativ +
                ", tålighet=" + tålighet +
                ", attack=" + attack +
                ", smidighet=" + smidighet +
                ", vanlighet=" + vanlighet +
                '}';
    }
    
    public static void gigantSpider() { //Ska läggas in på bestämd plats i kartan
        
        System.out.println("\nAaaah! Du blir påhoppad av en jättespindel!");
        System.out.println("\nNi slogs ett tag men du förlorade ;-(");
        
    }
    
    public static void gameOver() {
        
        System.out.println("Game over!\n");
        System.out.println("Vad vill du göra?\n");
        System.out.println("1. Spela igen.");
        System.out.println("0. Avsluta.");
        
    }
}
