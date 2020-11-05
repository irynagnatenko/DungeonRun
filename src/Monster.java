public class Monster extends Character {
    public double vanlighet;

    public Monster (int initiative, int endurance, int attack, int flexibility) {
        super(initiative, endurance, attack, flexibility);
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
