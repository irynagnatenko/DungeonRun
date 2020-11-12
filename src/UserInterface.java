package src;

import java.util.concurrent.ThreadLocalRandom;
 
/**
 * Created by Iryna Gnatenko Date 10/27/2020 Time 1:32 PM Project untitled1
 */
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
 
class UserInterface {
 
    static String checkName;
    static Scanner input = new Scanner(System.in);
    static Character hero = null;
    static ArrayList<Character> heroes = new ArrayList<>();
    static String fileName = "data.ser";
    static int choice;
    static boolean runAgain = true;
    static final int LITEN = 1, LAGOM = 2, STOR = 3;
    static boolean testName;
    static boolean addName;
    static boolean runMenu = true;
    static boolean stillAlive = true;
 
    public static void mapMenu() {
        System.out.println("Hur stort äventyr vill du ha?");
        System.out.println("----");
        System.out.println("1. litet");
        System.out.println("2. lagom");
        System.out.println("3. stort");
        Map map = getMap();
 
        System.out.println("Kartan du valde: ");
        map.printMap();
        System.out.println("----");
 
        choice = getStartingPoint();
        map.setStartingPoint(choice);
        Randomize random = new Randomize();
 
        stillAlive = true;
        while (stillAlive) {
            map.printMap();
            stillAlive = random.randomizeMonster();
            if (stillAlive == true) {
                random.randomizeTreasure();
                map.navigateThroughMap();
            } else {
                stillAlive = false;
                Monster.gameOver();
            }
        }
    }
 
    public static Map getMap() {
        choice = Integer.parseInt(input.nextLine());
 
        Map map = null;
 
        switch (choice) {
            case LITEN:
                map = new Map(4);
                break;
            case LAGOM:
                map = new Map(5);
                break;
            case STOR:
                map = new Map(8);
                break;
        }
        return map;
    }
 
    public static int getStartingPoint() {
        System.out.println("Var vill du börja?");
        System.out.println("1. Nordväst");
        System.out.println("2. Nordöst");
        System.out.println("3. Sydväst");
        System.out.println("4. Sydöst");
 
        return Integer.parseInt(input.nextLine());
    }
 
    public static void menu() {
 
        System.out.println("Hej och välkommen till Dungeon Run! Låt äventyret börja!");
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
            case 0:
                saveToFile();
                runMenu = false;
                //output som talar om att det du gjort sparats?
                break;
        }
    }
 
    public static void checkName(String name) {
        testName = true;
 
        for (Character c : heroes) {
            if (name.equalsIgnoreCase(c.getName())) {
                testName = false;
            }
        }
    }
 
    public static void createHero() {
        input.nextLine();
 
        System.out.println("Välj en hjälte: ");
 
        System.out.print("1. Riddare");
        System.out.print("\t2. Trollkarl");
        System.out.print("\t3. Tjuv\n");
 
        choice = input.nextInt();
        input.nextLine();
 
        addName = true;
        while (addName) {
            System.out.println("Ange ett namn för din hjälte: ");
            String name = input.nextLine();
            checkName(name);
 
            if (testName == true) {
                addName = false;
                switch (choice) {
                    case 1:
                        hero = new Warrior(name, 5, 9, 6, 4);
                        break;
 
                    case 2:
                        hero = new Mage(name, 6, 4, 9, 5);
                        break;
 
                    case 3:
                        hero = new Thief(name, 6, 5, 5, 7);
                        break;
                }
            } else {
                System.out.println("Namnet är upptaget, välj ett nytt");
 
            }
        }
 
        System.out.println("Du har valt: " + hero.toString());
 
        heroes.add(hero);
        mapMenu();
 
        //Maps mapsObjects = new Maps();  // skapa oblekt av klassen Maps
        //mapsObjects.mapsMenu();         // ropa på objektets metod mapsMenu
    }
 
    public static void saveToFile() { //Jag behöver få in en arrayList eller ett object i metoden.
 
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(heroes); //Objectet ska in hit.
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public static void loadExistingHero() {
        input.nextLine();
        System.out.println("Ange namnet för din hjälte: ");
        checkName = input.nextLine();
 
        for (Character c : heroes) {
            if (checkName.equals(c.getName())) {
                hero = c;
            }
        }
        System.out.println("Du har laddat hjälten: " + hero.toString());
        mapMenu();
    }
 
    public static void importFromFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
 
            heroes = (ArrayList<Character>) is.readObject();
            is.close();
 
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
 