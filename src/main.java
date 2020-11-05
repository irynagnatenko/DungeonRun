/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */

import java.util.Scanner;

class main {
    
    static private Character hero = null;
    static private int choice;
    static private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        System.out.println("Hej och välkommen till Dungeon Run Låt äventyret börja!");
        
        System.out.println("1. Skapa en ny hjälte");
        System.out.println("2. Ladda in befintlig hjälte");
        
        choice = input.nextInt();
        
        switch(choice) {
            case 1:
                //createHero
                break;
            case 2:
                //loadSpecificHero
                break;
        }
    }
    
    public static void createHero() {
        
        System.out.println("1. Riddare");
        System.out.print("\t2. Trollkarl");
        System.out.print("\t3. Tjuv");
        System.out.println("");
        
        choice = input.nextInt();
        input.nextLine();
        
        System.out.println("Ange ett namn till din hjälte: ");
        String name = input.nextLine();

        switch(choice) {
            case 1:
                hero = new Warrior(name,5, 9, 6, 4);
                System.out.println("Du har valt riddaren. Du har följande attribut: " + hero.toString());
                break;
            case 2:
                hero = new Mage(name,6, 4, 9, 5);
                System.out.println("Du har valt trollkarl. Du har följande attribut: " + hero.toString());
                break;
            case 3:
                hero = new Thief(name,6, 5, 5, 7);
                System.out.println("Du har valt tjuven. Du har följande attribut: " + hero.toString());
        }
    }


        //Maps mapsObjects = new Maps();  // skapa oblekt av klassen Maps
        //mapsObjects.mapsMenu();         // ropa på objektets metod mapsMenu
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