import java.util.List;
import java.util.ArrayList;

public class CharacterSheet {
    private Player player;
    private List<Item> inventory;

    public CharacterSheet(Player player) {
        this.player = player;
        this.inventory = new ArrayList<Item>();
    }

    public void display() {
        System.out.println("------ Character Sheet ------");
        System.out.println("Name: " + player.getName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Experience: " + player.getXp());
        System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHp());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        System.out.println("Inventory: " + inventory.toString());
        System.out.println("-----------------------------");
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }
}
