import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    // Initialize monsters inside of a constructor or method
    List<Monster> monsters = new ArrayList<>();

    public Game() {
        monsters.add(new Goblin("Goblin", 1, 50, 5, 2));
        monsters.add(new Orc("Orc", 2, 80, 7, 3));
    }
    
    public class Goblin extends Monster {
        public Goblin(String name, int level, int maxHp, int attack, int defense) {
            super(name, level, maxHp, attack, defense);
        }
    }

    public class Orc extends Monster {
        public Orc(String name, int level, int maxHp, int attack, int defense) {
            super(name, level, maxHp, attack, defense);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player("Player", 1, 10, 5, 1);
        CharacterSheet characterSheet = new CharacterSheet(player);
        Game game = new Game(); // Instantiate the Game class to initialize the monsters list

        System.out.println("Welcome to the game!");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Battle");
            System.out.println("2. Rest");
            System.out.println("3. View character sheet");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            if (choice == 1) { // Move the monster selection and battle start inside the if block
                while (player.getHealth() > 0) {
                    Random random = new Random();
                    Monster monster = game.monsters.get(random.nextInt(game.monsters.size()));

                    Battle battle = new Battle(player, monster);
                    battle.start();

                    System.out.println("Do you want to continue playing? (Y/N)");
                    String input = scanner.nextLine().toUpperCase();
                    if (!input.equals("Y")) {
                        break;
                    }
                }
            } else if (choice == 2) {
                player.rest();
            } else if (choice == 3) {
                characterSheet.display();
            } else if (choice == 4) {
                System.out.println("Thanks for playing!");
                break; // Exit the while loop and end the program
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            if (player.getHealth() < player.getMaxHp() * 0.2) {
                System.out.println("Your health is low. Do you want to rest? (Y/N)");

                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("Y")) {
                    player.rest();
                }
            }
        }
    }
}