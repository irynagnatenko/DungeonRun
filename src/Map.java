
/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 3:20 PM
 * Project untitled1
 */

public class Map {

    public static String[][] crosses = new String[0][0];

    private int mapSize;
//    public static ArrayList<Boolean> startPosition = new ArrayList<>();
    static boolean northWest, northEast, southWest, southEast = false;

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
                crosses[0][0] = "[O]";
                northWest = true;
//                startPosition.add(northWest);
                break;
            case 2:
                crosses[0][mapSize - 1] = "[O]";
                northEast = true;
//                startPosition.add(northEast);
                break;
            case 3:
                crosses[mapSize - 1][0] = "[O]";
                southWest = true;
//                startPosition.add(southWest);
                break;
            case 4:
                crosses[mapSize - 1][mapSize - 1] = "[O]";
                southEast = true;
//                startPosition.add(southEast);
                break;
        }
    }

    public void navigateThroughMap(int choice) {
        /* Behöver startpositionen 
      om startpositionen är ett hämta vilket hörn
      om hörn sydväst  kan gå höger eller upp
      uppåt = 1 minussteg i raden (första hakparantesen), samma poistion i andra hakparantesen
      höger = 1 plussteg i kolumner (andra hakparantesen),samma poistion i första hakparantesen*/
        int [] currentPosition = getPosition();
        int positionI = currentPosition[0];
        int positionJ = currentPosition[1];
        
        if (southWest == true) {

            switch (choice) {
                case 1:
                    crosses[positionI][positionJ + 1] = "[O]";
                    crosses[mapSize - 1][0] = "[P]";
                    break;
                case 2:
                    crosses[3][0] = "[O]";
                    break;
            }
        }
    }

    public int[] getPosition() {
        int [] currentPosition = new int[2];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (crosses[i][j].equals("[O]")) {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }
        return currentPosition;
    }
//                crosses[2][0] = "[O]";
//                System.out.println("Go up!");
    //crosses[0][1] = "[O]";
//               System.out.println("Go right!");        
}