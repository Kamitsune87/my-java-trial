import java.util.Random;

public class Player {
    private String name;
    private int level;
    private int maxHp;
    private int hp;
    private int attack;
    private int defense;
    private int xp;
    private int xpNeeded;
    private Random random;

    public Player(String name, int level, int maxHp, int attack, int defense) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.xp = 0;
        this.xpNeeded = level * 10;
        this.random = new Random();
    }

    public void levelUp() {
        level++;
        maxHp += 10;
        hp = maxHp;
        attack += 2;
        defense += 2;
        xpNeeded = level * 10;
        System.out.println("Congratulations! You've leveled up to level " + level + ".");
        System.out.println("Your max HP has increased to " + maxHp + ".");
        System.out.println("Your attack has increased to " + attack + ".");
        System.out.println("Your defense has increased to " + defense + ".");
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

public int getLevel() {
    return level;  
}

    public int getHealth() {
        return hp;  
    }

    public int getAttack() {
        return attack;
    }

    public int takeDamage(int damage) {
     hp -= damage;
     return hp;
    }

    public String getName() {
        return name;
    }

    public void rest() {
        System.out.println("You rest and regain your strength.");
        hp = maxHp;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }
   
    public int gainXp(int xpGained) {
        xp += xpGained;
        if (xp >= xpNeeded) {
            levelUp();
        }
        return xpGained;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpNeeded() {
        return xpNeeded;
    }

    public void setXpNeeded(int xpNeeded) {
        this.xpNeeded = xpNeeded;
    }
}