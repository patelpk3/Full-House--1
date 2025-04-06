package fullHouse;

public class puzzle {
    private boolean puzzleComplete;

    boolean setPuzzleComplete(boolean puzzleComplete) {
        this.puzzleComplete = puzzleComplete;
        return puzzleComplete;
    }

    boolean getPuzzleComplete(boolean puzzleComplete) {
        return puzzleComplete;
    }

    void puzzle(boolean puzzleComplete) {
        System.out.println("This is the puzzle method");
    }
}
