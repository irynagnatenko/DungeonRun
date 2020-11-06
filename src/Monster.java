package src;

import java.util.Scanner;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Iryna Gnatenko Date 10/27/2020 Time 1:32 PM Project untitled1
 */
public class Monster extends Character {
    public double vanlighet;
    static Scanner sc = new Scanner(System.in);

    public Monster(int initiativ, int tålighet, int attack, int smidighet, double vanlighet) {
        super(initiativ, tålighet, attack, smidighet);
        this.vanlighet = vanlighet;

    }

    public double getVanlighet() {
        return vanlighet;
    }

    public void setVanlighet(double vanlighet) {
        this.vanlighet = vanlighet;
    }

//    @Override
//    public String toString() {
//        return "{" + "initiativ=" + initiativ + ", tålighet=" + tålighet + ", attack=" + attack + ", smidighet="
//                + smidighet + ", vanlighet=" + vanlighet + '}';
//    }

    public static void troll() {
        System.out.println("\nDu gick in i det nordöstra hörnet men där väntar ett troll");
        System.out.println("Efter en tuff kamp går du segrande ur striden och får med dig 10 guldmynt!");
        System.out.println("Var vill du gå nu?\n");

    }

    public static void foundTreasure() {

        System.out.println("Du fortsatte västerut.");
        System.out.println("Yihaa, du hittar en skatt! Ta upp den och du får tio nya guldmynt.");
        System.out.println("Var vill du gå nu?\n");
    }

    public static void gigantSpider() { // Ska läggas in på bestämd plats i kartan
        System.out.println("Du gick söderut.");
        System.out.println("Aaaah! Du blir påhoppad av en jättespindel!");
        System.out.println("Ni slogs ett tag men du förlorade ;-(\n");

    }
    
   /* public static void randomizeMonster() {
        
        //Randomiseat Spindel dyker upp
        int result = 0;
        int min = 1;
        int max = 100;
        
        result = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println("Tärningsresultat: " + result);
        
        if (result >0 && result < 21) {
            System.out.println("En jättespindel dyker upp!");
        } else {
            System.out.println("En jättespindel dyker INTE upp, puuh...");
        }
      */  
//        
//
//    public static int throwDice(int numberOfDice) {
//        int diceSum = 0;
//        int diceResult = 0;
//        int min = 1;
//        int max = 7;
//
//        // För varje tärning, skriv ut "Tärningsresultat: x"
//        for (int i = 0; i < numberOfDice; i++) {
//            diceResult = ThreadLocalRandom.current().nextInt(min, max);
//            System.out.println("Tärningsresultat: " + diceResult);
//        }
//
//        return diceSum;
//    }
   // }

    public static void gameOver() {

        System.out.println("Game over!\n");
        System.out.println("Vad vill du göra?\n");
        System.out.println("1. Spela igen.");
        System.out.println("0. Avsluta.");

        boolean continueLoop = true;
        int exitChoice;

        while (continueLoop) {
            try {
                exitChoice = Integer.parseInt(sc.nextLine());
               // sc.nextLine();
                if (exitChoice == 0) {
                    System.exit(0);
                } else if (exitChoice == 1) {
                    main.readUserInput();
                }

                else {
                    System.out.println("Fel val, du måste välja 1 eller 0.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Fel val, du måste välja 1 eller 0.");
            }

        }
    }

}
