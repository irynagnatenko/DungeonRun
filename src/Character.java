public class Character {
    
    private String name;
    private int initiativ;
    private int tålighet;
    private int attack;
    private int smidighet;

    //Hero constructor// HEJ från Johanna
    public Character(String name, int initiativ, int tålighet, int attack, int smidighet) {
        this.name = name;
        this.initiativ = initiativ;
        this.tålighet = tålighet;
        this.attack = attack;
        this.smidighet = smidighet;
    }
    
    //Monster constructor
    public Character(int initiativ, int tålighet, int attack, int smidighet) {
        this.initiativ = initiativ;
        this.tålighet = tålighet;
        this.attack = attack;
        this.smidighet = smidighet;
    }

    public int getInitiativ() {
        return initiativ;
    }

    public void setInitiativ(int initiativ) {
        this.initiativ = initiativ;
    }

    public int getTålighet() {
        return tålighet;
    }

    public void setTålighet(int tålighet) {
        this.tålighet = tålighet;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSmidighet() {
        return smidighet;
    }

    public void setSmidighet(int smidighet) {
        this.smidighet = smidighet;
    }

    @Override
    public String toString() {
        return "{" +
                "initiativ=" + getInitiativ() +
                ", tålighet=" + getTålighet() +
                ", attack=" + getAttack() +
                ", smidighet=" + getSmidighet() +
                '}';
    }
}
