
/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.NullPointerException;

class main {

    static String checkName;
    static Scanner input = new Scanner(System.in);
    static Character hero = null;
    static ArrayList<Character> heroes = new ArrayList<>();
    static String fileName = "data.ser";
    static int choice;
    static boolean runAgain = true;
    static boolean testName;

    public static void main(String[] args) {

        importFromFile();
        while (runAgain) {
            menu();
        }
    }

    public static void menu() {

        System.out.println("\nHej och välkommen till Dungeon Run! Låt äventyret börja!");
        System.out.println("1. Skapa en ny hjälte");
        System.out.println("2. Ladda en befintligt");
        System.out.println("0. Avsluta programmet");

        choice = input.nextInt();
        switch (choice) {
            case 1:
                createHero();
                break;
            case 2:
                loadExistingHero();
                break;
            case 3:
                displayAll();
                break;
            case 0:
                saveToFile();
                runAgain = false;
                break;
        }
    }

    public static void createHero() {
        System.out.println("Välj en hjälte: ");
        System.out.print("1. Riddare");
        System.out.print("\t2. Trollkarl");
        System.out.print("\t3. Tjuv");
        choice = input.nextInt();
        input.nextLine();
        while (runAgain) {

            System.out.println("Ange ett namn för din hjälte: ");
            String name = input.nextLine();
            checkName(name); // kollar om namnet finns
            if (testName == true) {
                switch (choice) {
                    case 1:
                        hero = new Warrior(name, 5, 9, 6, 4);
                        runAgain = false;
                        break;

                    case 2:
                        hero = new Mage(name, 6, 4, 9, 5);
                        runAgain = false;
                        break;

                    case 3:
                        hero = new Thief(name, 6, 5, 5, 7);
                        runAgain = false;
                        break;
                }
            } else {
                System.out.println("\nNamnet finns redan! Testa ett annat namn \n");
            }
        }
        System.out.println("\nDu har valt: " + hero.toString());
        heroes.add(hero);
        runAgain = true;

        //Maps mapsObjects = new Maps();  // skapa oblekt av klassen Maps
        //mapsObjects.mapsMenu();         // ropa på objektets metod mapsMenu
    }

    public static void saveToFile() {

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(heroes);
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Du har inga laddade karakrärer ");
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            System.out.println(" testar denna ");
        }
    }

    public static void loadExistingHero() {
        input.nextLine();
        System.out.println("Ange namnet för din hjälte: ");
        checkName = input.nextLine();
        try {
            for (Character c : heroes) {
                if (checkName.equals(c.getName())) {
                    hero = c;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(" testar denna ");
        }

        System.out.println("\nDu har laddat hjälten: " + hero.toString());
    }

    public static void importFromFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));

            heroes = (ArrayList<Character>) is.readObject();
            is.close();

        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("testar");
        } catch (NullPointerException e) {
            System.out.println(" testar denna ");
        }
    }

    public static void displayAll() {
        System.out.println(heroes);
    }

    public static void checkName(String name) {
        testName = true;

        for (Character c : heroes) {
            if (name.equalsIgnoreCase(c.getName())) {
                testName = false;
            }
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
