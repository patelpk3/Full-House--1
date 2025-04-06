package fullHouse;

public class basicClue {
    private boolean found;

    // constructor
    public basicClue(boolean found) {
        this.found = found;
    }

    public boolean clueFound(boolean found) {
        boolean clueFound = false;

        if(found) {
            clueFound = true;
        } else {
            clueFound = false;
        }

        return clueFound;
    } 
}
