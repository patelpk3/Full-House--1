package fullHouse;

/**
 * Class: BasicClue
 * @author Parth, Kyle, Josh, Kengo
 * @version 1.0
 * Course: CSE 201 Spring 2025
 * Written: April 6, 2025
 *
 * Purpose: Shows a basic clue that tracks whether it has been found or not.
 */
public class BasicClue {
    private boolean found; // Shows if the clue has been found

    /**
     * Constructor to show the BasicClue object.
     *
     * @param found boolean showing if the clue has been found
     */
    public BasicClue(boolean found) {
        this.found = found;
    }

    /**
     * Determines if the clue has been found.
     *
     * @param found the current found status
     * @return true if the clue has been found, false if not
     */
    public boolean clueFound(boolean found) {
        boolean clueFound = false;

        if (found) {
            clueFound = true;
        } else {
            clueFound = false;
        }

        return clueFound;
    }
}
