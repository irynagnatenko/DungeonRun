package src;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Randomize {
    public ArrayList<Character> currentCombat = new ArrayList<>();

    public ArrayList<Character> randomizeMonster() // randomizer klass
    {
        int result = 0;
        int min = 1;
        int max = 100;

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result <= 20) {
            System.out.println("En jättespindel dyker upp!");
            Monster spider = new Monster("Jättespindel", 7, 1, 2, 3);
            currentCombat.add(spider);
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result <= 15) {
            System.out.println("Ett skelett dyker upp!");
            Monster skeleton = new Monster("Skelett", 4, 2, 3, 3);
            currentCombat.add(skeleton);
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result <= 10) {
            System.out.println("En orc dyker upp!");
            Monster orc = new Monster("Orc", 6, 3, 4, 4);
            currentCombat.add(orc);
        }
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >= 5) {
            System.out.println("Ett troll dyker upp!");
            Monster oger = new Monster("Troll", 2, 4, 7, 2);
            currentCombat.add(oger);
        }

        return currentCombat;
    }

    public void randomLose() // randomizer
    {
        int result = 0;
        int min = 1;
        int max = 100;
        stillAlive = true;

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 10) {
            System.out.println("WOW du överlevde");
        } else {
            System.out.println("OUPS du dog!");
            stillAlive = false;
        }
    }

    public boolean randomizeFlight() {

        int result = 0;
        int min = 1;
        int max = 100;
        boolean flightSuccessful;

        result = ThreadLocalRandom.current().nextInt(min, max);

        if (result > 0 && result < 51) {
            System.out.println("Du lyckades fly!");
            flightSuccessful = true;
        } else {
            System.out.println("Du lyckads inte fly... du måste stanna och slåss!");
            flightSuccessful = false;
        }

        return flightSuccessful;
    }
}