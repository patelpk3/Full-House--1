package fullHouse;

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
    private int moves; // The number of moves the player has made
    private int cluesFound; // The number of clues the player has found

    /**
     * Sets the number of clues found by the player.
     *
     * @param cluesFound number of clues found
     */
    public void setCluesFound(int cluesFound) {
        this.cluesFound = cluesFound;
    }

    /**
     * Gets the number of clues found by the player.
     *
     * @return number of clues found
     */
    public int getCluesFound() {
        return cluesFound;
    }

    /**
     * Sets the number of moves made by the player.
     *
     * @param moves number of moves made
     */
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
        System.out.println("This is the intro method.");
    }

    /**
     * Shows help information for the player.
     */
    public void help() {
        System.out.println("This is the help method.");
    }

    /**
     * Determines if the player has won the game.
     *
     * @return boolean shows the win status
     */
    public boolean win() {
        return false;
    }

    /**
     * Determines if the player has lost the game.
     *
     * @return boolean shows the loss status
     */
    public boolean lose() {
        return false;
    }
}
