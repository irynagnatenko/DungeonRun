package src;

// DENNA ÄR DET SOM GÄLLER
import java.util.Scanner;

/**
 * Created by Iryna Gnatenko Date 10/27/2020 Time 3:20 PM Project untitled1
 */
public class Map {

    static Scanner input = new Scanner(System.in);
    static boolean stillAlive = true;
    private static String[][] crosses = new String[0][0];
    private static Object[][] rooms = new Object[0][0];
    private static final String PURPLEFONT = "\u001B[35m";
    private static final String REGULARFONT = "\u001B[0m";
    private static final String GREENFONT = "\u001B[32m";
    public static final String REDFONT = "\u001B[31m";
    private static String yourPosition = "[" + PURPLEFONT + "O" + REGULARFONT + "]";
    private static String visitedRoom = "[" + GREENFONT + "*" + REGULARFONT + "]";
    private static String roomWithMonster = "[" + REDFONT + "M" + REGULARFONT + "]";
    private static String invalidDirections = REDFONT + "--------" + REGULARFONT;

    private int mapSize;

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Map(int a) {
        mapSize = a;
        crosses = new String[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                crosses[i][j] = "[X]";
            }
        }
    }

    public void mapInstructions() {

        System.out.println("****************************");
        System.out.println(yourPosition + " = din position");
        System.out.println("[X] = obesökt rum");
        System.out.println(visitedRoom + " = besökt rum");
        System.out.println(roomWithMonster + " = monster kvar i rummet");
        System.out.println("****************************");

    }

    public void printMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.print(crosses[i][j]);
            }
            System.out.println();
        }
    }

    public void setStartingPoint(int a) {
        switch (a) {
            case 1:
                crosses[0][0] = yourPosition;
                break;
            case 2:
                crosses[0][mapSize - 1] = yourPosition;
                break;
            case 3:
                crosses[mapSize - 1][0] = yourPosition;
                break;
            case 4:
                crosses[mapSize - 1][mapSize - 1] = yourPosition;
                break;
        }
    }

    public void navigateThroughMap(Character hero) {

        while (stillAlive) {
            int[] currentPosition = getPosition();
            int positionI = currentPosition[0];
            int positionJ = currentPosition[1];
            // boolean continueInMap = false;
            int choiceUseDoor = 0;

            if (yourPosition == crosses[0][0] || yourPosition == crosses[4][2]) {
                System.out.println("Du är vid en utgång.");
                System.out.println("Vill du fortsätta [1], avsluta [2]?");
                choiceUseDoor = input.nextInt();
                input.nextLine();
            }
            if (choiceUseDoor == 2) {
                System.exit(0);
            } else if(choiceUseDoor == 1){
                if (positionI - 1 >= 0) {
                    System.out.println("1.Upp");
                } else {
                    System.out.println("1." + invalidDirections);
                }
                if (positionJ + 1 < mapSize) {
                    System.out.println("2.Höger");
                } else {
                    System.out.println("2." + invalidDirections);
                }
                if (positionI + 1 < mapSize) {
                    System.out.print("3.Ner");
                } else {
                    System.out.println("3." + invalidDirections);
                }
                if (positionJ - 1 >= 0) {
                    System.out.println("4.Vänster");
                } else {
                    System.out.println("4." + invalidDirections);
                }
            }
            int choice = input.nextInt();
            //boolean flightSuccessful;
            //Randomize randomFlight = new Randomize();
            //flightSuccessful = randomFlight.randomizeFlight();

            switch (choice) {
                case 1:
                    crosses[positionI - 1][positionJ] = yourPosition;
                    break;
                case 2:
                    crosses[positionI][positionJ + 1] = yourPosition;
                    //crosses[positionI][positionJ] = visitedRoom;
                    //if (flightSuccessful) {
                    //    crosses[positionI][positionJ] = roomWithMonster;
                    //}
                    break;
                case 3:
                    crosses[positionI + 1][positionJ] = yourPosition;
                    break;
                case 4:
                    crosses[positionI][positionJ - 1] = yourPosition;
                    break;
            }

            stillAlive = Combat.checkMonsters(stillAlive, hero);

            // Slumpa monster
            // om monster fråga om combat eller fly
            // om combat
            //// om hjälten är vid liv slumpa skatt

            // om väljer fly
            // om lyckas fly
            // skriv ut position "roomWithMonster"     
            // flyttas till föregående rum
            // annars strid

            // skriv ut position "visited room"

        }
    }
    

    

    public int[] getPosition() {
        int[] currentPosition = new int[2];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (crosses[i][j].contains(yourPosition)) {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }
        return currentPosition;
    }
}