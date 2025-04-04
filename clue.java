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
    
    // Shows clue description
    public void clueDescription() {
        System.out.println("Clue Description: " + description);
    }
    
    // Show image in popup
    private void showClueImage() {
        JFrame frame = new JFrame("Clue Found!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon clueIcon = new ImageIcon(imagePath);
        JLabel label = new JLabel(clueIcon);

        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);  // center of screen
        frame.setVisible(true);
    }

    // For testing
    public static void main(String[] args) {
        Clue kingSuiteClue = new Clue(true, "images/kingsuite_clue.png",
                "A folded piece of paper under the nightstand. It reads: 'The last card lies in velvet.'");

        kingSuiteClue.clueDescription();

        // Simulate solving the puzzle
        kingSuiteClue.completePuzzle();
    }
    
    
}
