import javax.swing.*;
import java.awt.*;

package fullHouse;

public class clue {
    private boolean hasPuzzle;
    private boolean puzzleComplete;
    private String imagePath;  // Path to clue image
    private String description; // Clue text description

    // Constructor
    public Clue(boolean hasPuzzle, String imagePath, String description) {
        this.hasPuzzle = hasPuzzle;
        this.puzzleComplete = false;
        this.imagePath = imagePath;
        this.description = description;
    }

    // Getter for puzzleComplete
    public boolean isPuzzleComplete() {
        return puzzleComplete;
    }

    // Set puzzle as complete
    public void completePuzzle() {
        if (hasPuzzle) {
            this.puzzleComplete = true;
            System.out.println("Puzzle solved! You found a clue!");
            showClueImage();
        } else {
            System.out.println("This clue doesn't have a puzzle.");
        }
    }
    
    
}
