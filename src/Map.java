import java.util.Scanner;

/**
 * Created by Iryna Gnatenko Date 10/27/2020 Time 3:20 PM Project untitled1
 */
public class Map {

    static Scanner input = new Scanner(System.in);
    public static String[][] crosses = new String[0][0];
    public static final String purpleFont = "\u001B[35m";
    public static final String regularFont = "\u001B[0m";
    public static String yourPosition ="[" + purpleFont + "O" + regularFont + "]";
    public static String visitedRoom = "";
//    static int [] checkDirections = new int[4];
    private int mapSize;

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Map(int a) {
        mapSize = a;
        crosses = new String[mapSize][mapSize];                   //skapar en 'a' stor array
        for (int i = 0; i < mapSize; i++) {                       //nested foor loo för att sätta alla värden i 2darrayen till X
            for (int j = 0; j < mapSize; j++) {
                crosses[i][j] = "[X]";
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < mapSize; i++) {                       //skriver ut alla positioner i arrayen
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

    public void navigateThroughMap() {  
        int[] currentPosition = getPosition();
        int positionI = currentPosition[0];
        int positionJ = currentPosition[1];
        System.out.println("Vilket håll vill du gå?");
        int[] checkDirections = {0, 0, 0, 0};

        if (positionI -1 < 0) {
                System.out.println("KAN EJ GÅ UPPÅT!");
            }
        if (positionJ +2 > mapSize) {
                System.out.println("KAN EJ GÅ HÖGER!");         //FUNKAR
            }
        if (positionI +2 > mapSize) {
                System.out.println("KAN EJ GÅ NERÅT!");         //FUNKAR
            }
        if (positionJ -1 < 0) {
                System.out.println("KAN EJ GÅ VÄNSTER!");       
            }
        try {
            crosses[positionI - 1][positionJ] = "[X]";            //Case prova gå uppåt
            System.out.println("1. Uppåt");
            checkDirections[0] = 1;
        } catch (Exception e) {
        }
        try {
            crosses[positionI][positionJ + 1] = "[X]";            //Case prova gå höger
            System.out.println("2. Höger");
            checkDirections[1] = 2;
        } catch (Exception e) {
        }
        try {
            crosses[positionI + 1][positionJ] = "[X]";            //Case prova gå neråt
            System.out.println("3. Neråt");
            checkDirections[2] = 3;
        } catch (Exception e) {
        }
        try {
            crosses[positionI][positionJ - 1] = "[X]";            //Case prova gå vänster
            System.out.println("4. Vänster");
            checkDirections[3] = 4;
        } catch (Exception e) {
        }

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                crosses[positionI - 1][positionJ] = yourPosition;
                crosses[positionI][positionJ] = "[O]";
                break;
            case 2:
                crosses[positionI][positionJ + 1] = yourPosition;
                crosses[positionI][positionJ] = "[O]";
                break;
            case 3:
                crosses[positionI + 1][positionJ] = yourPosition;
                crosses[positionI][positionJ] = "[O]";
                break;
            case 4:
                crosses[positionI][positionJ - 1] = yourPosition;
                crosses[positionI][positionJ] = "[O]";
                break;
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
