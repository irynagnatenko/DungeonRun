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
        return "hej";
    }
}
