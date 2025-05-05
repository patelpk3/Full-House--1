

/**
 * Class: Player
 * @author Parth, Kyle, Josh, Kengo
 * @version 1.0
 * Course: CSE 201 Spring 2025
 * Written: April 6, 2025
 *
 * Purpose: Represents the player in the Full House game.
 * Tracks the player progress through the moves made with the clues found.
 */
public class Player {
    private int moves;
    private int cluesFound;
    private static final int WIN_CLUES = 5;
    private static final int MAX_MOVES = 15;

    public Player() {
        this.moves = 0;
        this.cluesFound = 0;
    }

    public void setCluesFound(int cluesFound) {
        this.cluesFound = cluesFound;
    }

    public int getCluesFound() {
        return cluesFound;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    /**
     * Gets the number of moves made by the player.
     *
     * @return number of moves
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Shows the introduction for the player.
     */
    public void intro() {
        System.out.println("Full House: A Game of Luck and Mystery.");
        System.out.println("---------------------------------------");
        System.out.println("\nThis game will test your mystery solving skills along with your luck in general.");
        System.out.println("The goal of the game is to solve the mystery of what happened to your missing friend.");
        System.out.println("The setting of your story is at a sketchy casino that seems to have everything work in favor of the house.");
        System.out.println("\nYour friend has always been lucky, but this time he might have gotten too lucky.");
        System.out.println("You will have to traverse through the rooms of the casino and find clues that lead you to the answer.");
        System.out.println("But be careful: when you move around more and more throughout the casino, you will catch the suspection of security.");
        System.out.println("As you gather clues, you will eventually be able to track down the disappearance of your friend and discover the truth.");
        System.out.println("\nGood luck.\n");
    }

    public void help() {
        System.out.println("Commands you can use:");
        System.out.println("- go [room name]: move to a new room");
        System.out.println("- look: look around the room");
        System.out.println("- investigate: search for a clue");
        System.out.println("- hint: receive a hint (limited use)");
        System.out.println("- help: show this help message");
        System.out.println("- exit: exit the game");
    }

    public boolean win() {
        return cluesFound >= WIN_CLUES;
    }

    public boolean lose() {
        return moves >= MAX_MOVES;
    }
}
