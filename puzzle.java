package fullHouse;

/**
 * Class: Puzzle
 * @author Parth, Kyle, Josh, Kengo
 * @version 1.0
 * Course: CSE 201 Spring 2025
 * Written: April 6, 2025
 *
 * Purpose: A puzzle object within a room in our Full House game.
 * Keeping track if the puzzle has been completed.
 */
public class Puzzle {
    private boolean puzzleComplete; // Shows if the puzzle is complete

    /**
     * Sets the status of the puzzle.
     *
     * @param puzzleComplete boolean showing whether the puzzle is complete
     * @return boolean status that was set
     */
    public boolean setPuzzleComplete(boolean puzzleComplete) {
        this.puzzleComplete = puzzleComplete;
        return puzzleComplete;
    }

    /**
     * Gets the completion status of the puzzle.
     *
     * @return boolean showing the puzzle's current completion status
     */
    public boolean getPuzzleComplete() {
        return this.puzzleComplete;
    }

    /**
     * Method representing a puzzle interaction.
     *
     * @param puzzleComplete 
     */
    public void puzzle(boolean puzzleComplete) {
        System.out.println("This is the puzzle method");
    }
}
