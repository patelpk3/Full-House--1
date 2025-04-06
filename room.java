package fullHouse;

public class room {
    private clue roomClue;
    private String location;
    private String roomDescription;
    private boolean roomComplete;

    // constructor
    public room(clue roomClue, String location, String roomDescription) {
        this.roomClue = roomClue;
        this.location = location;
        this.roomDescription = roomDescription;
        this.roomComplete = false;
    }

    public void startingRoom() {
        //clue start = new clue(roomComplete, location, roomDescription);
        room startingRoom = new room(roomClue, "This is the starting room.", 
        "You may find clues here but you can manuver around to find out.");
    }

    public void describeRoom() {
        System.out.println("This is the describeRoom method.");
    }

    public void giveClue() {
        System.out.println("This is the giveClue method.");
    }

    public void dialogue() {
        System.out.println("This is the dialogue method.");
    }

    public boolean investigate() {
        return false;
    }
}
