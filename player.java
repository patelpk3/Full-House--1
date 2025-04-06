package fullHouse;

public class player {
    private int moves;
    private int cluesFound;

    public void setCluesFound(int cluesFound) {
        this.cluesFound = cluesFound;
    }

    public int getCluesFound() {
        return cluesFound;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getMoves() {
        return moves;
    }

    public void intro() {
        System.out.println("This is the intro method.");
    }

    public void help() {
        System.out.println("This is the help method.");
    }

    public boolean win() {
        return false;
    }

    public boolean lose() {
        return false;
    }
}
