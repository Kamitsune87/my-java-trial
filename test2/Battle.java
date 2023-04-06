import java.util.Random;

public class Battle {
    private Player player;
    private Monster monster;
    private Random random;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        random = new Random();
    }

    public void start() {
        System.out.println("A " + monster.getName() + " appears!");
    
        boolean playerTurn = true;
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            if (playerTurn) {
                System.out.println("Your turn!");
                int playerAttack = random.nextInt(player.getAttack());
                monster.takeDamage(playerAttack);
                System.out.println("You attack for " + playerAttack + " damage.");
                System.out.println(monster.getName() + " has " + monster.getHealth() + " health remaining.");
            } else {
                System.out.println("Monster's turn!");
                int monsterAttack = random.nextInt(monster.getAttack());
                player.takeDamage(monsterAttack);
                System.out.println(monster.getName() + " attacks for " + monsterAttack + " damage.");
                System.out.println(player.getName() + " has " + player.getHealth() + " health remaining.");
            }
            playerTurn = !playerTurn;
        }
    
        if (player.getHealth() > 0) {
            System.out.println("You defeated the " + monster.getName() + "!");
            int xpReward = monster.getXpReward();
            player.gainXp(xpReward);
            System.out.println("You gained " + xpReward + " XP!");
        } else {
            System.out.println("You were defeated by the " + monster.getName() + "...");
        }
    }
}