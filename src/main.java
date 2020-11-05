/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */

import java.util.Scanner;

class main {

    public static void main(String[] args) {

        readUserInput();

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