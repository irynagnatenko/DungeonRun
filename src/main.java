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

        boolean runMenu = true;
        UserInterface userMenu = new UserInterface();
        userMenu.importFromFile();
        while (runMenu) {
            userMenu.menu();
        }
    }
}