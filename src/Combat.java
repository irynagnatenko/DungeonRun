package src;

import java.util.ArrayList;
import java.util.Random;
public class Combat {
    
    static ArrayList<Integer> turnOrder = new ArrayList<>();
    static ArrayList<Character> combatants = new ArrayList<>();
    static int orderSum = 0;
    static Randomize random = new Randomize();
    static Random rand = new Random();
    static Character hero = null;

    //Tärnings-metod?!
    public static int diceRoll(){
    int diceRoll = 0;
    diceRoll = rand.nextInt(6 - 1 + 1) + 1;
    return diceRoll;
}

//Checkmonster metod i Combat
public static boolean checkMonsters(boolean stillAlive, Character hero) {
    combatants.clear();
    combatants = random.randomizeMonster();
        combatants.add(hero);
        setHero(combatants);
        
        for(int i = 0; i < combatants.size(); i++) {
            
            if(combatants.get(i) instanceof Monster) {
            Combat.attackOrder(combatants);
            break; 
            }
            else if(i == combatants.size() -1) {
                System.out.println("Pew! Inga monster här inte!");
            }
            
        }
        if(hero.getEndurance() == 0) {
                stillAlive = false;
            }
    return stillAlive;
}


//Set hero metod, sätta attributen hero i combat-klassen baserat på arrayn
public static void setHero(ArrayList<Character> combatants) {
    for(int y = 0; y < combatants.size(); y++) {
        if(combatants.get(y) instanceof Warrior) {
            hero = combatants.get(y);
            break;
        }
        else if(combatants.get(y) instanceof Thief) {
            hero = combatants.get(y);
            break;
        }
        else if(combatants.get(y) instanceof Mage) {
            hero = combatants.get(y);
            break;
        }
    }
}


//Turordningsmetod
public static void attackOrder(ArrayList<Character> combatants) {
    turnOrder.clear();
    setHero(combatants);
    Character tempChar = null;
    //Slår tärningar baserat på initiativ och hur många karaktärer som läses in
    for(int i = 0; i < combatants.size(); i++) {
        orderSum = 0;
            
            for(int x = 0; x < combatants.get(i).getInitiative(); x++) {
            orderSum += diceRoll();
            }
        
        //Adderar in i en array, den slagna summan för index i 
        turnOrder.add(orderSum);
    }
    
    //Sortera upp ordningen så det sammankopplar med karaktärerna som läses in
    for(int i = 0; i < turnOrder.size(); i++) {
        for(int j = i + 1; j < turnOrder.size(); j++) {
           if(turnOrder.get(i) < turnOrder.get(j)) {
               
               int temp = turnOrder.get(i);
               turnOrder.set(i, turnOrder.get(j));
               turnOrder.set(j, temp);
               
               //Sorterar upp karaktärerna i samband med sorteringen av slagna tärningar
               tempChar = combatants.get(i);
               combatants.set(i, combatants.get(j));
               combatants.set(j, tempChar);                 
           }
        }
    }
    
    //Skriver ut turordningen för striden
    System.out.println("Stiden sker i följande turordning:  ");
    for(int i = 0; i < turnOrder.size(); i++) {
            System.out.println();
            System.out.println(combatants.get(i).getName() + " (" + turnOrder.get(i).toString() + ")");
            //Printar ut informationen om karaktären
            System.out.println(combatants.get(i).toString());
                }
    
        //Hoppar in i stridsfassen i den turordning som angetts
        attack(combatants);
}
       


//Attack metod
public static void attack(ArrayList<Character> combatants) {
    int attackSum = 0;
    int defenceSum = 0;
    boolean monster;
    boolean heros;
    boolean combat = true;
    //Loopa arraylisten (combatArray)
        //Kolla om objektet innehåller monsterinstance eller inte
            //Om monster intance, kör en viss attack i metoden mot hero
            //Annaras kör en viss attack i metoden mot monster
    
    while(combat) {        
    for(int i = 0; i < combatants.size(); i++) {
        
        //Kollar om index är monster eller hero
        if(combatants.get(i) instanceof Monster) {
            monster = true;
            heros = false;
        }
        else {
            monster = false;
            heros = true;
        }
        
        //Hjältens attack
        while(heros) {
            for(int j = 0; j < combatants.size(); j++) {
                    attackSum = 0; //Nollställer attacksumman och försvarssumman
                    defenceSum = 0; // ^
                if(combatants.get(j) instanceof Monster && combatants.get(j).getEndurance() != 0) {
                    
                    //Slår tärningar baserat på hjältens attack och summerar den
                    for(int x = 0; x <= hero.getAttack(); x++) {
                    attackSum += diceRoll();
                    }
                    //Skriver ut summeringen för attacken
                    System.out.println("\nTotalen av (" + hero.getAttack() +") slagna tärningar är: " + attackSum);
    
                    //Monstret slår tärning baserat på smidighetsvärdet och summerar det i försvarssummering
                    for(int y = 0; y < combatants.get(j).getFlexibility(); y++) {
                    defenceSum += diceRoll();
                    }
                    //Skriver ut summeringen för försvaret
                    System.out.println("Totalen av monster: " + combatants.get(j).getName() + "  (" + combatants.get(j).getFlexibility() + ") slagna tärningar är: " + defenceSum);
                
                    //Reducerar tålighet med 1 hos hjälten ifall attacken är större än försvaret, annars missar attacken
                    if(attackSum > defenceSum) {
                        combatants.get(j).setEndurance(combatants.get(j).getEndurance() - 1);
                        System.out.println("Monster (" + combatants.get(j).getName() + ") förlora 1 liv, monstret har nu " + combatants.get(j).getEndurance() + " liv!");
                    }
                    else {
                        System.out.println("Du missa din attack!");
                    }
                }                           
           }
            //Sätter heros till false efter ha loopat igenom listan för karaktärerna
            heros = false;
         } 
        
        //Monstrets attack
        while(monster) {
                //Nollställer attacksumman och försvarssumman
                attackSum = 0;
                defenceSum = 0;
                
                //Kollar om index(monstret) har mer än 0 liv kvar
                if(combatants.get(i).getEndurance() != 0) {
                    
                    //Slår tärningar baserat på monstrets attack och summerar den i attacksumman
                    for(int x = 0; x <= combatants.get(i).getAttack(); x++) {
                    attackSum += diceRoll();
                    }
                    
                    //Skriver ut summering för attacken
                    System.out.println("\nMonstrets attack (" + combatants.get(i).getAttack() +") slog: " + attackSum);
    
                    //Slår tärningar baserat på hjältens smidighet och summerar den i försvarssumman
                    for(int y = 0; y < hero.getFlexibility(); y++) {
                    defenceSum += diceRoll();
                    }
                    
                    //Skriver ut summering för försvaret
                    System.out.println("Totalen av " + hero.getName() + "  (" + hero.getFlexibility() + ") slagna tärningar är: " + defenceSum);
                
                    //Reducerar tålighet med 1 hos hjälten ifall attacken är större än försvaret, annars missar attacken
                    if(attackSum > defenceSum) {
                        hero.setEndurance(hero.getEndurance() - 1);
                        System.out.println(hero.getName() + " förlora 1 liv, du har nu " + hero.getEndurance() + " liv!");
                        }
                    else{
                        System.out.println("Monstret missa sin attack!");
                    }
               }
             //Sätter monster till false efter att ha loopat igenom listan
             monster = false;
            } 
        }
    
            //Kollar ifall alla monster eller hjälten har liv kvar, för att se ifall striden ska fortsätta
            for(int p = 0; p < combatants.size(); p++) {
                if(combatants.get(p) instanceof Monster && combatants.get(p).getEndurance() == 0) {
                    combat = false;
                }
                else if(combatants.get(p) instanceof Monster && combatants.get(p).getEndurance() != 0) {
                    combat = true;
                    break;
                }
                else if(hero.getEndurance() == 0) {
                    combat = false;
                    break;
                }    
            }
        }
    }
}

