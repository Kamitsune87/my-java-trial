public class Monster {
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int xpReward;

    public Monster(String name, int health, int attack, int defense, int xpReward) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.xpReward = xpReward;
    }

    public class Goblin extends Monster {
        public Goblin(String name, int level, int maxHp, int attack, int defense) {
            super(name, level, maxHp, attack, defense);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    // Other methods for the Monster class
}
