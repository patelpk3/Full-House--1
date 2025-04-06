package fullHouse;

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
    private boolean roomComplete; // Indicates if the room has been completed

    /**
     * Constructor to initialize a Room object.
     *
     * @param roomClue The clue in the room
     * @param location The room's location identifier
     * @param roomDescription A brief description of the room
     */
    public Room(Clue roomClue, String location, String roomDescription) {
        this.roomClue = roomClue;
        this.location = location;
        this.roomDescription = roomDescription;
        this.roomComplete = false;
    }

    /**
     * Method to create the starting room.
     */
    public void startingRoom() {
        Room startingRoom = new Room(roomClue, 
            "This is the starting room.", 
            "You may find clues here but you can maneuver around to find out.");
    }

    /**
     * Method to describe the room.
     */
    public void describeRoom() {
        System.out.println("This is the describeRoom method.");
    }

    /**
     * Method to give a clue in the room.
     */
    public void giveClue() {
        System.out.println("This is the giveClue method.");
    }

    /**
     * Method to replicate talking in the room.
     */
    public void dialogue() {
        System.out.println("This is the dialogue method.");
    }

    /**
     * Method to replicate investigating the room.
     *
     * @return boolean showing whether something was found
     */
    public boolean investigate() {
        return false;
    }
}
