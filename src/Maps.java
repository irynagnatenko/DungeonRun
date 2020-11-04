import java.util.Scanner;

/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 3:20 PM
 * Project untitled1
 */
public class Maps {

        public static void mapsMenu() {
            System.out.println("Nu är det dags att välja äventyr.");
            System.out.println("Hur stort äventyr vill du ha? Stort, litet eller mittemellan?");

            System.out.println("[1] Karta storlek Liten");
            System.out.println("[2] Karta storlek Lagom");
            System.out.println("[3] Karta storlek Stor");

            Scanner sc = new Scanner(System.in);

            int mapChoice = sc.nextInt();
            sc.nextLine();
            switch (mapChoice) {
                case 1:
                    System.out.println("Du valde ett litet äventyr - en liten karta kommer här: ");
                    for (int i = 0; i < 4; i++) { //Antal rader i kartan
                        for (int j = 0; j < 4; j++) { //Antal kolumner i kartan
                            System.out.print("[X]");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Du valde ett lagom äventyr - en lagom stor karta kommer här: ");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print("[X]");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Du valde ett stort äventyr - en stor karta kommer här: ");
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            System.out.print("[X]");
                        }
                        System.out.println("");
                    }
                    break;
                default:
                    System.out.println("Du måste välja 1-3! Försök igen!");
            }
        }
    }

