
public class Run {

    static boolean running = true;
    static boolean stillAlive = true;
    static boolean flightSuccesfull;

    public static void Game() {
        UserData.importFromFile();

        UserInterface.welcomeMessage();

        while (running) {
            int choice = UserInterface.createOrLoadHero();
            switch (choice) {
                case 1:
                    choice = UserInterface.selectHero();
                    Hero.createSelectedHero(choice);
                    break;
                case 2:
                    Hero.loadExistingHero();
                    break;
                case 0:
                    System.out.println("Din hjälte har sparats!");
                    UserData.saveToFile();
                    running = false;
                    break;
            }
            if (running) {
                UserInterface.enterToContinue();

                choice = UserInterface.selectMapSize();
                Map map = Map.createMap(choice);
                map.printMap();
                choice = UserInterface.getStartingPoint();
                map.setStartingPoint(choice);
                map.mapInstructions();
                map.printMap();

                Randomize random = new Randomize();
                Character hero = Hero.hero;

                while (stillAlive) {
                    map.navigateThroughMap();
                    map.printMap();
                    Combat.checkIfMonsters(hero);
                    stillAlive = Combat.stillAlive();
                    int fightOrFlight = UserInterface.fightOrFlight();

                    switch (fightOrFlight) {
                        case 1:
                            Combat.turnOrder();
                            Combat.attack(Combat.getCombatants());
                            break;
                        case 2:
                            flightSuccesfull = Randomize.randomizeFlight();
                    }
                    if (flightSuccesfull) {

                    }
                }
            }
        }
    }
}
