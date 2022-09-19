public class Battle {
    public static String fight(Hero h, Monster m) {
        String returnVal = "There is No Winner";
        while ((m.hitPoints > 0) && (h.hitPointsRemaining > 0)) { //This while loop runs so long that both classes have
            m.receiveAttack(h.attackRating);                      //HP greater than 0
            h.receiveAttack(m.attackRating);
            if ((h.hasHPRemaining() == true) && (m.isDefeated() == false)){ //This if statement checks to see that both
                h.useHealingPotion();                                       //classes are still alive and if so
            }                                                               //the hero class uses a healingpotion
        }
        if (h.hasHPRemaining() == false) { //This sets the return statement if the Hero dies
            returnVal = ("The " + m.type + " has defeated " + h.name + ". Game Over.");
        }
        else if (m.isDefeated() == true) { //This sets the return statement if the Monster dies
            int levelsGained;
            int OldLevel = h.currentLevel;
            h.receiveXP(m.xpValue); //This gives the hero the XP reward after they killed the monster
            levelsGained = h.currentLevel - OldLevel; //This gives the amount of levels gained in this fight
            h.healingPotions += m.goldValue / 3; //This gives the amount of healing potions the Hero receives
            returnVal = (h.name + " has defeated the " + m.type + " earning " + m.goldValue + " gold and "
                    + m.xpValue + " XP leveling up " + levelsGained + " times.");
        }
        return returnVal;
    }
}