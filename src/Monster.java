package src;

import java.util.Scanner;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Iryna Gnatenko Date 10/27/2020 Time 1:32 PM Project untitled1
 */
public class Monster extends Character {
    static Scanner sc = new Scanner(System.in);

    public Monster (String name, int initiative, int endurance, int attack, int flexibility) {
        super(name, initiative, endurance, attack, flexibility);
    }

    public static void gameOver() {

        UserInterface save = new UserInterface();

        System.out.println("\nGame over!\n");
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
                    save.saveToFile();
                    System.exit(0);
                } else if (exitChoice == 1) {
                    continueLoop = false;
                }

                else {
                    System.out.println("Fel val, du måste välja 1 eller 0.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Fel val, du måste välja 1 eller 0.");
            }
        }
        }
    @Override
    public String toString() {
        return "hej";
    }

}
