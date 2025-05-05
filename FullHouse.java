import java.util.HashMap;
import java.util.Scanner;

/**
 * Class: FullHouse
 * @author Parth, Kyle, Josh, Kengo
 * @version 1.0
 * Course: CSE 201 Spring 2025
 * Written: April 6, 2025
 *
 * Purpose: This is the main class for our Full House game.
 * It is where the program starts.
 */




public class FullHouse {

    private Player player;
    private Room currentRoom;
    private static final int WIN_CLUES = 5;
    private static final int MAX_MOVES = 15;
    Scanner scanner = new Scanner(System.in);
    Room[] rooms = new Room[5];
    
    /**
     * Main method to start the Full House game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FullHouse game = new FullHouse();
        game.startGame();
    }
    
    public FullHouse() {
        player = new Player();

        Clue clue1 = new Clue(false);
        Clue clue2 = new Clue(false);
        Clue clue3 = new Clue(true);
        Clue clue4 = new Clue(false);
        Clue clue5 = new Clue(true);
        
        
        Room puzzleRoom1 = new Room(clue3, clue3.getClueDesc());
        Room puzzleRoom2 = new Room(clue5, clue5.getClueDesc());
        Room ranRoom1 = new Room(clue1, clue1.getClueDesc());
        Room ranRoom2 = new Room(clue2, clue2.getClueDesc());
        Room ranRoom3 = new Room(clue4, clue4.getClueDesc());
        
        rooms[0] = ranRoom1;
        rooms[1] = ranRoom2;
        rooms[2] = puzzleRoom1;
        rooms[3] = ranRoom3;
        rooms[4] = puzzleRoom2;
        
    }
    
    @SuppressWarnings("static-access")
    public void startGame() {
        System.out.println("Welcome to Full House!");
        player.intro();
        int i = 0;
        currentRoom = rooms[i];

        while (true) {

            if (player.getMoves() >= MAX_MOVES) {
                System.out.println("Too many moves taken. You've lost the game!");
                break;
            }

            if (player.getCluesFound() >= WIN_CLUES) {
                System.out.println("You've gathered enough clues and made it to the end of your investigation");
                System.out.println("You confront the culprit and solve the mystery! You win!");
                break;
            }
            
            if (currentRoom.roomComplete) {
                i++;
                
                System.out.println("\n--- You enter a new area ---");
            }
            
            currentRoom.describeRoom();
            System.out.print("What will you do now? ");
            String command = scanner.nextLine().toLowerCase();
            handleCommand(command);
            
        }
    }
    
    public void handleCommand(String command) {
        switch (command) {
            case "?":
                System.out.println("Commands: go [room], look, investigate, hint, help, exit");
                break;
            case "look":
                currentRoom.describeRoom();
                break;
            case "investigate":
                boolean found = currentRoom.investigate(currentRoom.getRoomClue());
                if (found) {
                    player.setCluesFound(player.getCluesFound() + 1);
                } else {
                    System.out.println();
                }
                break;
            case "hint":
                System.out.println("Use your surroundings wisely. Pay attention to oddities.");
                break;
            case "help":
                player.help();
                break;
            case "exit":
                System.out.println("Thanks for playing Full House - 1!");
                System.exit(0);
                break;
            default:
        }
        player.setMoves(player.getMoves() + 1);
    }
}
