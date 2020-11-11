package src;

import java.util.concurrent.ThreadLocalRandom;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author sunni
 */
public class Randomize {
    boolean stillAlive = true;
   
    public boolean randomizeMonster() //randomizer klass
    {
        int result = 0;
        int min = 1;
        int max = 100;
        boolean ifMonster = false;                  //bolean för att kolla om ett monster dykt upp
        stillAlive = true;
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 21) {
            System.out.println("En jättespindel dyker upp!");
            randomLose(); // en metod
            ifMonster = true;
        }
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 16 && stillAlive == true) {
            System.out.println("Ett skelett dyker upp!");
            randomLose(); // en metod
            ifMonster = true;
        }
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 11 && stillAlive == true) {
            System.out.println("En orc dyker upp!");
            randomLose(); // en metod
            ifMonster = true;
        }
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 6 && stillAlive == true) {
            System.out.println("Ett troll dyker upp!");
            randomLose(); // en metod
            ifMonster = true;
        }
 
        if (ifMonster == false) {
            System.out.println("Ã…hhh skönt det finns inge monster! ");
        }
       
        return stillAlive;
    }
 
    public void randomizeTreasure() //randomizer
    {
 
        int result = 0;
        int min = 1;
        int max = 100;
        boolean ifTreassure = false;
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 41) {
            System.out.println("Wow, en hel nÃ¤ve lÃ¶sa slantar!");
            ifTreassure = true;
        }
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 21) {
            System.out.println("Wow, en hel pengapung!");
            ifTreassure = true;
        }
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 16) {
            System.out.println("Wow, guldsmycken!");
            ifTreassure = true;
        }
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 11) {
            System.out.println("Wow, en fin Ã¤delsten!");
            ifTreassure = true;
        }
 
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 6) {
            System.out.println("Wow, en liten skattkista!");
            ifTreassure = true;
        }
 
        if (ifTreassure == false) {
            System.out.println("TyvÃ¤rr, ingen skatt fÃ¶r dig den hÃ¤r gÃ¥ngen...");
        }
    }
 
    public void randomLose() //randomizer
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
}