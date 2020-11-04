/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */
public class Character {
    public int initiativ;
    public int tålighet;
    public int attack;
    public int smidighet;
    //Github-test Mona

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
