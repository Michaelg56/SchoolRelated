public class Hero {
    public String name;
    public int hitPointsRemaining, hitPointsMax, healingPotions;
    public int attackRating, defenseRating;
    public int currentXP, currentLevel;
    public int XPgained = 0;

    public Hero(String name, int hpMax, int ar, int dr, int potions) { //This code constructs the class Hero with the
        this.name = name;                                              //inputs given
        this.hitPointsRemaining = hpMax;
        this.hitPointsMax = hpMax;
        this.attackRating = ar;
        this.defenseRating = dr;
        this.healingPotions = potions;
        this.currentLevel = 1;
        this.currentXP = 0;
    }

    public boolean hasHPRemaining() { //This returns true or false if the object Hero has HP greater than 0
        if (hitPointsRemaining > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public void receiveAttack(int incAttack) {        //This is how the Hero takes damage
        int attackValue = incAttack - defenseRating;  //This line of code takes the defense rating and subtracts the
                                                      //attack given by it
        if (attackValue > 0) {
            hitPointsRemaining -= attackValue;
        }
    }
    public void receiveXP(int xpReceived) {  //This is how the Hero recieves XP and how that XP is transmiited
        XPgained += xpReceived;              // into levels
        currentXP += xpReceived;
        while(XPgained >= 10) {
            XPgained -= 10;
            currentLevel += 1;
            hitPointsMax += 5;
            hitPointsRemaining = hitPointsMax;
        }
    }
    public void useHealingPotion() {   //This is how the Hero uses their HealingPotions
        if (healingPotions > 0) {
            hitPointsRemaining = hitPointsMax;
            healingPotions -= 1;
        }
    }
}