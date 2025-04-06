package fullHouse;

import javax.swing.*;
import java.awt.*;

/**
 * Class: Clue
 * @author Parth, Kyle, Josh, Kengo
 * @version 1.0
 * Course: CSE 201 Spring 2025
 * Written: April 6, 2025
 *
 * Purpose: All the clues in the Full House game.
 * A clue can be a puzzle, an image, and/or a textual description.
 */
public class Clue {
    private boolean hasPuzzle; // Shows if the clue has a puzzle
    private boolean puzzleComplete; // Tracks if the puzzle has been completed
    private String imagePath; // Path to the clue image
    private String description; // Text description of the clue

    /**
     * Constructor to show a Clue object.
     *
     * @param hasPuzzle whether the clue has a puzzle
     * @param imagePath file path to the clue image
     * @param description text description of the clue
     */
    public Clue(boolean hasPuzzle, String imagePath, String description) {
        this.hasPuzzle = hasPuzzle;
        this.puzzleComplete = false;
        this.imagePath = imagePath;
        this.description = description;
    }

    /**
     * Returns whether the puzzle with the clue is complete.
     *
     * @return true if the puzzle is complete, false if otherwise
     */
    public boolean isPuzzleComplete() {
        return puzzleComplete;
    }

    /**
     * Marks the puzzle as complete if it exists and displays the clue image in the room.
     */
    public void completePuzzle() {
        if (hasPuzzle) {
            this.puzzleComplete = true;
            System.out.println("Puzzle solved! You found a clue!");
            showClueImage();
        } else {
            System.out.println("This clue doesn't have a puzzle.");
        }
    }

    /**
     * Shows the description of the clue.
     */
    public void clueDescription() {
        System.out.println("Clue Description: " + description);
    }

    /**
     * Shows the clue image in the game.
     */
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

    /**
     * Main method for testing the Clue class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Clue kingSuiteClue = new Clue(
            true,
            "images/kingsuite_clue.png",
            "A folded piece of paper under the nightstand. It reads: 'The last card lies in velvet.'"
        );

        kingSuiteClue.clueDescription();

        // Simulates solving the puzzle
        kingSuiteClue.completePuzzle();
    }
}
