package fullHouse;

import java.util.*;

public class dice {
    private Random random;
    private int userWins;
    private int ownerWins;
    private boolean gameOver;
    private Scanner scanner;
    
    /**
     * constructor
     */
    public dice() {
        this.random = new Random();
        this.userWins = 0;
        this.ownerWins = 0;
        this.gameOver = false;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * rolls a die and returns the result
     * @return the dice result
     */
    private int rollDice() {
        return random.nextInt(6) + 1;
    }
    
    /**
     * plays a single round of the game
     */
    private void playRound() {
        System.out.println("\nPress Enter to roll your dice...");
        scanner.nextLine();
        
        // user rolls
        int userRoll1 = rollDice();
        int userRoll2 = rollDice();
        int userTotal = userRoll1 + userRoll2;
        boolean userDoubles = (userRoll1 == userRoll2);
        
        System.out.println("User rolled: " + userRoll1 + " and " + userRoll2 + " (Total: " + userTotal + ")");
        if (userDoubles) {
            System.out.println("User rolled doubles!");
        }
        
        System.out.println("\nPress Enter to see the Owner's roll...");
        scanner.nextLine();
        
        // owner rolls
        int ownerRoll1 = rollDice();
        int ownerRoll2 = rollDice();
        int ownerTotal = ownerRoll1 + ownerRoll2;
        boolean ownerDoubles = (ownerRoll1 == ownerRoll2);
        
        System.out.println("Owner rolled: " + ownerRoll1 + " and " + ownerRoll2 + " (Total: " + ownerTotal + ")");
        if (ownerDoubles) {
            System.out.println("Owner rolled doubles!");
        }
        
        // determine winner
        if (userDoubles && ownerDoubles) {
            if (userRoll1 > ownerRoll1) {
                System.out.println("\nUser win with the higher doubles!");
                userWins++;
            } else if (ownerRoll1 > userRoll1) {
                System.out.println("\nOwner wins with the higher doubles!");
                ownerWins++;
            } else {
                System.out.println("\nIt's a tie! Both rolled the same doubles.");
            }
        } else if (userDoubles) {
            System.out.println("\nUser win with doubles!");
            userWins++;
        } else if (ownerDoubles) {
            System.out.println("\nOwner wins with doubles!");
            ownerWins++;
        } else {
            if (userTotal > ownerTotal) {
                System.out.println("\nUser win with the higher total!");
                userWins++;
            } else if (ownerTotal > userTotal) {
                System.out.println("\nOwner wins with the higher total!");
                ownerWins++;
            } else {
                System.out.println("\nIt's a tie! Both rolled the same total.");
            }
        }
        
        System.out.println("Current score - User: " + userWins + ", Owner: " + ownerWins);
        System.out.println("------------------------");
    }
    
    /**
     * play game to 3/5
     */
    public void playGame() {
        System.out.println("=== Dice Game: Best of 5 ===");
        System.out.println("Rules:");
        System.out.println("1. Each player rolls two dice");
        System.out.println("2. Doubles automatically win");
        System.out.println("3. If both roll doubles, higher pair wins");
        System.out.println("4. Otherwise, higher total wins");
        System.out.println("5. First to win 3 rounds wins the game");
        
        userWins = 0;
        ownerWins = 0;
        gameOver = false;
        
        int roundsPlayed = 0;
        while (!gameOver) {
            System.out.println("\nRound " + (roundsPlayed + 1) + ":");
            playRound();
            roundsPlayed++;
            
            // checks if someone has won the 3/5
            if (userWins >= 3 || ownerWins >= 3) {
                gameOver = true;
            }
        }
        
        announceWinner();
    }
    
    /**
     * displays the final winner of the game
     */
    private void announceWinner() {
        System.out.println("\n=== FINAL RESULTS ===");
        System.out.println("User: " + userWins + " wins");
        System.out.println("Owner: " + ownerWins + " wins");
        
        if (userWins >= 3) {
            System.out.println("USER WINS THE GAME!");
        } else {
            System.out.println("OWNER WINS THE GAME!");
        }
    }

    /**
     * getter method for userWins to help functionality in puzzle class
     * 
     * @return - true if user wins series
     */
    public boolean getUserWins() {
        return userWins >= 3;
    }
}
