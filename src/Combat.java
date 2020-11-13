package src;

import java.util.ArrayList;

public class Combat {
    
    static ArrayList<Integer> attackOrder = new ArrayList<>();
    static int orderSum = 0;
    
    public static int diceRoll(){
        int diceRoll = 0;
        diceRoll = rand.nextInt(6 - 1 + 1) + 1;
        return diceRoll;
    }
    
    public static void attackOrder() {
        attackOrder.clear();
        Character tempChar = null;
        //Slår tärningar baserat på initiativ och hur många karaktärer som läses in
        for(int i = 0; i < combatArray.size(); i++) {
            orderSum = 0;
            for(int x = 0; x < combatArray.get(i).getInitiative(); x++) {
                orderSum += diceRoll();
            }
            attackOrder.add(orderSum);
            System.out.println(orderSum);
        }
        
        //Sortera upp ordningen så det sammankopplar med karaktärerna som läses in
        for(int i = 0; i < attackOrder.size(); i++) {
            for(int j = i + 1; j < attackOrder.size(); j++) {
               if(attackOrder.get(i) < attackOrder.get(j)) {
                   
                   int temp = attackOrder.get(i);
                   attackOrder.set(i, attackOrder.get(j));
                   attackOrder.set(j, temp);
                   
                   //Sorterar upp karaktärerna i samband med sorteringen av slagna tärningar
                   tempChar = combatArray.get(i);
                   combatArray.set(i, combatArray.get(j));
                   combatArray.set(j, tempChar);                 
               }
            }
        }
        
        System.out.println("Stiden sker i följande turordning:  ");
        for(int i = 0; i < attackOrder.size(); i++) {
                System.out.println();
                System.out.println(combatArray.get(i).getName() + " (" + attackOrder.get(i).toString() + ")");
                //Printar ut informationen om karaktären
                System.out.println(combatArray.get(i).toString());
                    }
            attack();
    }
           
    public static void attack() {
        int attackSum = 0;
        int defenceSum = 0;
        boolean monster = true;
        boolean heros = true;
        //Loopa arraylisten (combatArray)
            //Kolla om objektet innehåller monsterinstance eller inte
                //Om monster intance, kör en viss attack i metoden mot hero
                //Annaras kör en viss attack i metoden mot monster
        for(int i = 0; i < combatArray.size(); i++) {
            if(combatArray.get(i) instanceof Monster) {
                monster = true;
                heros = false;
            }
            
            else {
                monster = false;
                heros = true;
            }
            
            while(heros) {
                for(int j = 0; j < combatArray.size(); j++) {
                    if(combatArray.get(j) instanceof Monster && combatArray.get(j).getEndurance() != 0) {
                        
                        for(int x = 1; x <= hero.getAttack(); x++) {
                        attackSum += diceRoll();
                        System.out.println("Tärning " + i + " slog ");
                        }
                        System.out.println("Totalen av (" + hero.getAttack() +") slagna tärningar är: " + attackSum);
        
                        for(int y = 0; y < combatArray.get(j).getFlexibility(); y++) {
                        defenceSum += diceRoll();
                        System.out.println("Dice " + j + " rolled ");
                        }
                        System.out.println("Totalen av (" + combatArray.get(j).getFlexibility() + ") slagna tärningar är: " + defenceSum);
                    }            
                }
            heros = false;
            }
            
        
        }
     }  
}    