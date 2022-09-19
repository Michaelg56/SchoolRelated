public class Monster {
    public String type;
    public int hitPoints, attackRating, xpValue, goldValue;

    public Monster(String type, int hp, int attackR, int xp, int gold){ //This code constructs the class Monster if
        this.type = type;                                               //values are inputted in
        this.hitPoints = hp;
        this.attackRating = attackR;
        this.xpValue = xp;
        this.goldValue = gold;
    }
    public Monster(){          //This code constructs the class Monster if no values are inputted
        this.type = "goblin";
        this.hitPoints = 10;
        this.attackRating = 1;
        this.xpValue = 1;
        this.goldValue = 1;
    }
    public boolean isDefeated(){  //This returns true or false depending on if the Monster has health less than 1
        if (hitPoints < 1) {
            return true;
        }
        else{
            return false;
        }
    }
    public void receiveAttack(int incAttack) {  //This is how the Monster class recieves damage
        hitPoints -= incAttack;
    }
}