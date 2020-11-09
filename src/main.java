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

class Main {

    //TRASSSJSJSJ!
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
    

    public static void main(String[] args) {
        
        importFromFile();
        while (runMenu) {
            menu();
        }

    }

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

        // readUserInput();
        // Monster.troll();
        // Monster.foundTreasure();
        // Monster.gigantSpider();
        map.setStartingPoint(choice);

        while (stillAlive) {
            map.printMap();
            randomizeMonster();
            if (stillAlive == true) {
                randomizeTreasure();
                map.mapNavigator();
            } else {
                stillAlive = false;
                Monster.gameOver();
            }
        }

        /*  while (true) {
            map.mapNavigator();
            
            map.printMap();
        }*/
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
        System.out.print("\t3. Tjuv");

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

    public static void randomizeMonster() {

//Randomiseat Spindel dyker upp
        int result = 0;
        int min = 1;
        int max = 100;
        boolean monsterTest = false;
        stillAlive = true;

        result = ThreadLocalRandom.current().nextInt(min, max);

        if (result > 0 && result < 21) {
            System.out.println("En jättespindel dyker upp!");
            randomLose();
            monsterTest = true;
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 16 && stillAlive == true) {
            System.out.println("Ett skelett dyker upp!");
            randomLose();
            monsterTest = true;
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 11 && stillAlive == true) {
            System.out.println("En orc dyker upp!");
            randomLose();
            monsterTest = true;
        }
        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 6 && stillAlive == true) {
            System.out.println("Ett troll dyker upp!");
            randomLose();
            monsterTest = true;
        }

        if (monsterTest == false) {
            System.out.println("Åhhh skönt det finns inge monster! ");
        }
    }

    public static void randomizeTreasure() {

        int result = 0;
        int min = 1;
        int max = 100;
        boolean treasure = false;

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 51) {
            System.out.println("Wow, en hel näve lösa slantar!");
            treasure = true;
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 21) {
            System.out.println("Wow, en hel pengapung!");
            treasure = true;
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 16) {
            System.out.println("Wow, guldsmycken!");
            treasure = true;
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 11) {
            System.out.println("Wow, en fin ädelsten!");
            treasure = true;
        }

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 6) {
            System.out.println("Wow, en liten skattkista!");
            treasure = true;
        }

        if (treasure == false) {
            System.out.println("Tyvärr, ingen skatt för dig den här gången...");
        }

    }

    public static void randomLose() {
        int result = 0;
        int min = 1;
        int max = 100;
        stillAlive = true;

        result = ThreadLocalRandom.current().nextInt(min, max);
        if (result > 0 && result < 76) {
            System.out.println("WOW du överlevde");
        } else {
            System.out.println("OUPS du dog!");
            stillAlive = false;
        }
    }
}

/*
public class Main {

    public static void Main(String[] args) {


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
