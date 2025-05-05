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
    Scanner key = new Scanner(System.in);
    
    private int moves; // The number of moves the player has made
    private int cluesFound; // The number of clues the player has found

    /**
    * constructor
    */
    public Player(int moves, int cluesFound) {
        this.cluesFound = cluesFound;
        this.moves = moves;
    }

    /**
     * Sets the number of clues found by the player.
     *
     * @param cluesFound number of clues found
     */
    public void setCluesFound(boolean clueFound) {
        if(clueFound) {
            cluesFound++;
        }
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
     */
    public void setMoves() {
        moves++;
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
        System.out.println("\nGood luck.");
    }

    /**
     * Shows help information for the player.
     */
    public void help(String help) {
        if(help.equals("?") || help.equals("help")) {
            
        }
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
