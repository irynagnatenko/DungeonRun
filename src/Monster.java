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
