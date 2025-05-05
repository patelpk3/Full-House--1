import java.util.*;

/**
 * Class: Room
 * @author Parth, Kyle, Josh, Kengo
 * @version 1.0
 * Course: CSE 201 Spring 2025
 * Written: April 6, 2025
 *
 * Purpose: Represents a room in the Full House game.
 * Each room can contain a clue, have a description, and
 * track whether it has been completed.
 */
public class Room {
    private Clue roomClue; // Clue object in the room
    private String location; // Name of the room
    private String roomDescription; // Description of the room's environment
    public static boolean roomComplete; // Indicates if the room has been completed
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor to initialize a Room object.
     *
     * @param roomClue The clue in the room
     * @param location The room's location identifier
     * @param roomDescription A brief description of the room
     */
    public Room(Clue roomClue, String roomDescription) {
        this.roomClue = roomClue;
        this.roomDescription = roomDescription;
        this.roomComplete = false;
    }

    /**
     * Method to describe the room.
     */
    public void describeRoom() {
        System.out.println(roomDescription);
    }
    
    public Clue getRoomClue() {
        return roomClue;
    }


    /**
     * Method to replicate investigating the room.
     *
     * @return boolean showing whether something was found
     */
    public boolean investigate(Clue clue) {
        System.out.print("What would you like to investigate: ");
        if (sc.hasNextLine() && sc.nextLine().contains(clue.getClueKey())) {
            System.out.println(" --You've found a clue!-- ");
            roomComplete = true;
            return true;
        } else {
            System.out.println("No clue here...");
            return false;
        }
    }
}
