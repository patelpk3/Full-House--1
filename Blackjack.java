package fullHouse;

import java.util.*;

public class blackjack {
    /**
     * string arrays for the individual suits and values of 
     * possible card combonations for the blackjack game
     */
    private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    
    private List<card> deck;
    private Random random;
    private int userWins;
    private int dealerWins;
    private boolean gameOver;
    
    /**
     * constructor method for the blackjack class
     */
    public blackjack() {
        this.deck = new ArrayList<>();
        this.random = new Random();
        this.userWins = 0;
        this.dealerWins = 0;
        this.gameOver = false;
    }
    
    // card class
    private static class card {
        String suit;
        String value;
        
        card(String suit, String rank) {
            this.suit = suit;
            this.value = rank;
        }
        
        public String toString() {
            return value + " of " + suit;
        }
    }
    
    /**
     * this method sets the deck for all possible card
     * combonations for all the suits
     * 
     * this method also shuffles the deck so that the cards
     * can be dealt in random
     */
    private void initializeDeck() {
        deck.clear();
        for(String suit : suits) {
            for (String value : values) {
                deck.add(new card(suit, value));
            }
        }

        for(int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }
    
    /**
     * this method returns the value of the card
     * 
     * @param card - class that assigns a suit and value to each card
     * @return - int value of the card
     */
    private int getCardValue(card card) {
        switch(card.value) {
            case "10":
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11;
            case "9":
                return 9;
            case "8":
                return 8;
            case "7":
                return 7;
            case "6":
                return 6;
            case "5":
                return 5;
            case "4":
                return 4;
            case "3":
                return 3;
            case "2":
                return 2;
            default: 
                return 0;
        }
    }
    
    /**
     * this method calculates the value of each hand for the dealer and user
     * 
     * this method also handles the excpetion for when the aces switch from a
     * value of 11 to a value of 1
     * 
     * @param hand - list of cards in the user's or dealer's hand
     * @return - int value of the total value of the cards in a hand
     */
    private int calculateHandValue(List<card> hand) {
        int value = 0;
        int aces = 0;
        
        for(card card : hand) {
            value += getCardValue(card);
            if (card.value.equals("A")) {
                aces++;
            }
        }
        
        /*
         * if the value is greater than 21 with an ace in the hand the value
         * decreases by 10 shifting the ace value from 11 to 1
         * 
         * if you had an A, 7, and a 5 the initial value would be 23
         * with 1 A, so with the while method it would shift the total value 
         * to 13
         * 
         * if the user/dealer had 2 A and a 9 the inital value would be 31
         * so the value would then shift only once to 21 by only decreasing one A by 10
         * 
         * lastly if the user/dealer was dealt all 4 A then the initial value would be 44,
         * then the while loop would shift the value down 30 until the value was less than 21
         * and there were no A left accounted for 
         */
        while(value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        
        return value;
    }
    
    /**
     * this method simply draws a card from the deck meaning that it would remove it
     * completely from use until the deck were reshuffled which statistically should not
     * happen since the user only needs to win 2/3 games
     * 
     * @return - the card that was drawn/removed from the deck of possible cards
     */
    private card drawCard() {
        return deck.remove(deck.size() - 1);
    }
    
    /**
     * this method plays a singular hand versus the user and dealer
     */
    private void playHand() {
        Scanner key = new Scanner(System.in);
        initializeDeck();
        
        List<card> userHand = new ArrayList<>();
        List<card> dealerHand = new ArrayList<>();
        
        userHand.add(drawCard());
        dealerHand.add(drawCard());
        userHand.add(drawCard());
        dealerHand.add(drawCard());
        
        int playerValue = calculateHandValue(userHand);
        int dealerValue = calculateHandValue(dealerHand);
        System.out.println("User's hand shows " + userHand.get(0) + " and " + userHand.get(1) + ". (" + playerValue + ")");
        System.out.println("Dealer's hand shows " + dealerHand.get(0) + " and one not turned.");
        
        String holder;
        if(playerValue == 21) {
            System.out.println("USER HAS BLACKJACK!");
        } else {   
            do {
                System.out.println("Would you like to hit or stay?");
                holder = key.next();

                if(holder.equals("hit")) {
                    card temp = drawCard();
                    userHand.add(temp);
                    playerValue = calculateHandValue(userHand);
                    System.out.println(temp.toString() + " is played.");
                    System.out.println("User's hand value is " + playerValue + ".");

                    if(playerValue > 21) {
                        System.out.println("User busted!");
                        break;
                    }
                }
            } while(!holder.equals("stay") && playerValue <= 21);
        }
        
        System.out.println("Dealer shows " + dealerHand.get(0) + " and " + dealerHand.get(1) + ". (" + dealerValue + ")");
        // dealer must hit on 16 and below, stand on 17 and above
        while(dealerValue < 17) {
            card temp = drawCard();
            dealerHand.add(temp);
            dealerValue = calculateHandValue(dealerHand);
            System.out.println(temp.toString() + " is played.");
            System.out.println("Dealer's hand value is " + dealerValue + ".");
        }
        
        // determine winner
        if(playerValue > 21 && dealerValue > 21) {
            System.out.println("Both busted! Push.");
        } else if(playerValue > 21) {
            System.out.println("User busted! Dealer wins.");
            dealerWins++;
        } else if(dealerValue > 21) {
            System.out.println("Dealer busted! User wins.");
            userWins++;
        } else if(playerValue > dealerValue) {
            System.out.println("User wins!");
            userWins++;
        } else if(dealerValue > playerValue) {
            System.out.println("Dealer wins!");
            dealerWins++;
        } else {
            System.out.println("Push! It's a tie.");
        }
        
        System.out.println("Current score - User: " + userWins + ", Dealer: " + dealerWins);
        System.out.println("------------------------");
    }
    
    /**
     * this method simulates the hands in a best of 2/3 series
     */
    public void playGame() {
        System.out.println("=== Blackjack: Best of 3 ===");
        userWins = 0;
        dealerWins = 0;
        gameOver = false;
        
        int handsPlayed = 0;
        while(!gameOver) {
            System.out.println("\nHand " + (handsPlayed + 1) + ":");
            playHand();
            handsPlayed++;
            
            // check if someone has won the 2/3
            if(userWins >= 2 || dealerWins >= 2) {
                gameOver = true;
            }
        }
        
        announceWinner();
    }
    
    /**
     * this method uses the userWins and determines who the winner of 
     * the series is when the desired win total is reached
     */
    private void announceWinner() {
        System.out.println("\n=== FINAL RESULTS ===");
        System.out.println("Player: " + userWins + " wins");
        System.out.println("CPU: " + dealerWins + " wins");
        
        if(userWins >= 2) {
            System.out.println("USER WINS THE SERIES!");
        } else {
            System.out.println("DEALER WINS THE SERIES!");
        }
    }

    public boolean getUserWins() {
        return userWins >= 2;
    }
}
