package src;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */

import java.util.Scanner;

class main {

    public static void main(String[] args) {

       // readUserInput();
       // Monster.troll();
       // Monster.foundTreasure();
       // Monster.gigantSpider();
        randomizeMonster();
        randomizeTreasure();
        Monster.gameOver();
    }

    public static void readUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hej och välkommen till Dungeon Run! Börja med att välja din spelkaraktär.");

        System.out.println("1. Riddare");
        System.out.println("2. Trollkarl");
        System.out.println("3. Tjuv");

        int characterChoice = sc.nextInt();
        sc.nextLine();

        if (characterChoice == 1) {
            Character riddaren = new Hero(5, 9, 6, 4);
            System.out.println("Du har valt riddaren. Du har följande attribut: " + riddaren.toString());

        } else if (characterChoice == 2) {
            Character trollkarl = new Hero(6, 4, 9, 5);
            System.out.println("Du har valt trollkarl. Du har följande attribut: " + trollkarl.toString());

        } else if (characterChoice == 3) {
            Character tjuven = new Hero(6, 5, 5, 7);
            System.out.println("Du har valt tjuven. Du har följande attribut: " + tjuven.toString());
        }

        System.out.println("Välj nu ett namn till din spelare");

        String characterName = sc.nextLine();

        Maps mapsObjects = new Maps();  // skapa oblekt av klassen Maps
        mapsObjects.mapsMenu();         // ropa på objektets metod mapsMenu
    }
    
    public static void randomizeMonster() {
        
        //Randomiseat Spindel dyker upp
        int result = 0;
        int min = 1;
        int max = 100;
        
        result = ThreadLocalRandom.current().nextInt(min, max);
        
        if (result >0 && result < 51) {
            System.out.println("En jättespindel dyker upp!");
        } 
        
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 16) {
            System.out.println("Ett skelett dyker upp!");
        }

        result = ThreadLocalRandom.current().nextInt(min, max); 
        if (result >0 && result < 11) {
            System.out.println("En orc dyker upp!");
        } 

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 6) {
            System.out.println("Ett troll dyker upp!");
        } 
    }

    public static void randomizeTreasure() {
        
        int result = 0;
        int min = 1;
        int max = 100;
        boolean treasure = false;
        
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 51) {
            System.out.println("Wow, en hel näve lösa slantar!");
            treasure = true;
        } 

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 21) {
            System.out.println("Wow, en hel pengapung!");
            treasure = true;
        } 

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 16) {
            System.out.println("Wow, guldsmycken!");
            treasure = true;
        } 

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 11) {
            System.out.println("Wow, en fin ädelsten!");
            treasure = true;
        } 

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result >0 && result < 6) {
            System.out.println("Wow, en liten skattkista!");
            treasure = true;
        } 

        if (treasure == false) {
            System.out.println("Rummet är tomt ...");
        }

    }

}

/*
public class main {

    public static void main(String[] args) {


        Character riddaren = new Hero(5,9,6,4);
        Character trollkarl = new Hero(6,4,9,5);
        Character tjuven = new Hero(6,5,5,7);

        Character jättespindel = new Monster(7,1,2,3, 0.2);
        Character skelett = new Monster(4,2,3,3, 0.15);
        Character orc = new Monster(6,3,4,4, 0.1);
        Character troll = new Monster(2,4,7,2, 0.05);

        System.out.println("Du har valt trollkarl. Du har följande attribut: " + trollkarl.toString());
        System.out.println("Du har valt riddaren. Du har följande attribut: " + riddaren.toString());
        System.out.println("Du har valt tjuven. Du har följande attribut: " + tjuven.toString());

        System.out.println();
        System.out.println("Det är spindel. Den har följande attribut: " + jättespindel.toString());
        System.out.println("Det är skelett. Den har följande attribut: " + skelett.toString());
        System.out.println("Det är orc. Den har följande attribut: " + orc.toString());
        System.out.println("Det är troll. Den har följande attribut: " + troll.toString());


    }
}
*/