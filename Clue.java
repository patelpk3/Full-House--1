

import javax.swing.*;
import java.util.Random;
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
    private String clueDesc; // Paragraph description of room clue is in
    private String clueKey; // One word description of clue
    
    private String[][] roomMap = new String[12][2]; {
    
    
    roomMap[0][0] = "You enter the VIP bathroom. Soft jazz echoes off"
            + " the tiled walls. A roll of expensive hand towels is perfectly"
            + " folded on the counter, one corner slightly askew. A gold"
            + " lipstick tube lies near the sink drain, its cap off. The soap"
            + " dish glistens, though the bar itself looks untouched. In the"
            + " trash bin, among tissues and blotting papers, there’s a receipt"
            + " folded with mechanical precision.";
    roomMap[0][1] = "receipt"; 
    
    roomMap[1][0] = "You make your way into what seems to be the Surveillance"
            + " Room. Black-and-white feeds show looping hallways and"
            + " ghost-like patrons. A coffee-stained keyboard clacks with"
            + " static discharge when touched. One monitor is draped with a"
            + " post-it note reading “DO NOT TOUCH.” An old remote, missing its"
            + " battery cover, lies on the console. A loose AA battery sits by"
            + " a cup, sitting atop a uniquely flat coaster, full of red and"
            + " black pens one of which is missing its cap.";
    roomMap[1][1] = "cup";
    
    roomMap[2][0] = "You enter a lounge chock-full of attendees in swanky"
            + " attire. Thick cigar smoke clings to velvet curtains and"
            + " the air is heavy with silence and the scent of money."
            + " A half-finished drink sits on a side table, sweating into a"
            + " napkin. Gold-trimmed playing chips are scattered across a low"
            + " glass table, and a single cufflink lies forgotten near the"
            + " base. A matchbook from \"The Velvet Ace\" rests neatly beside"
            + " a coaster, slightly lifted on one edge like it’s hiding"
            + " a secret.";
    roomMap[2][1] = "matchbook";
    
    roomMap[3][0] = "You've wormed your way into the Counting room. Machines"
            + " hum in practiced rhythm, spitting bills into tidy stacks. A"
            + " poorly banded stack seems to be missing a few bills. It seems"
            + " whoever embezzled a few bills left a note in the sorts.  A"
            + " clipboard dangles from a hook on the wall, pages curling with"
            + " age. Near the back, a calculator with a cracked display still"
            + " blinks. Someone left a pack of gum beside a paperweight shaped"
            + " like a horse, and one stick has clearly been pulled free—then"
            + " replaced slightly crooked in the foil.";
    roomMap[3][1] = "stack";
    
    roomMap[4][0] = "You've made it to the Cigar Lounge. The air is thick with"
            + " stale smoke and velvet. A long-forgotten lighter clicks"
            + " underfoot as you step inside. A whiskey glass sits on a"
            + " short table with the faintest lipstick print on its rim."
            + " A painting of a greyhound above the fireplace hangs perfectly"
            + " straight—maybe too perfect. A vent cover is loose on one edge,"
            + " but a closer look reveals nothing but dust and old screws. A"
            + " rolled-up tabloid newspaper is stuffed into an umbrella stand"
            + " next to a walking cane with a silver grip.";
    roomMap[4][1] = "newspaper";
    
    roomMap[5][0] = "You find yourself in what seems to be a Dice Storage"
            + " room. Metal shelves hold rows of plastic containers labeled"
            + " “WEIGHED,” “REJECTED,” and “TO INSPECT.” A clipboard hangs"
            + " crookedly by the door, its paper wrinkled and curling."
            + " One box has been taped shut twice, the top layer sloppier"
            + " than the first. A pile of unused dice bags sits in a bin,"
            + " one tied off with a bright green string. Near the back,"
            + " a cardboard sleeve meant for game instructions is folded"
            + " and slipped behind a stack of used dice trays.";
    roomMap[5][1] = "sleeve";
    
    
    roomMap[6][0] = "You mistakenly end up in the Janitor's Closet, it reeks."
            + " The light buzzes overhead, casting long shadows from mop"
            + " handles leaning like spears. A bucket filled with brown water"
            + " sits beneath a leaking pipe. You can make out a faint"
            + " rectangular silhouette at the bottom. The shelves are packed"
            + " with unlabeled boxes. One has been resealed with duct tape,"
            + " badly. A plunger lies on top of a stack of paper towel rolls."
            + " A bundle of rags is crumpled in a plastic bin, but one of them"
            + " is tightly folded into a precise square, wedged flat beneath"
            + " the others.";
    roomMap[6][1] = "rag";
    
    roomMap[7][0] = "You make your way into the Poker Room. The low hum of"
            + " conversation and the shuffle of cards fills the poker room."
            + " A few empty chairs sit around the table, one slightly askew"
            + ". A cocktail napkin, half-crumpled, rests at the corner of"
            + " the table, the edges darkened with a stain. Nearby, several"
            + " poker chips lie scattered—some are stacked neatly, others"
            + " abandoned. Beneath the table, you notice a pile of old playing"
            + " cards, some of them slightly bent, others piled up in a"
            + " half-hearted heap.";
    roomMap[7][1] = "pile";
    
    roomMap[8][0] = "You wound up at a craps table. Dice scatter across the"
            + " table with a sharp clatter, some bouncing off the edges,"
            + " while others rest frozen in place. A pile of yellow casino"
            + " chips is stacked off to one side, their edges worn from"
            + " years of use. A dealer stands motionless, watching the game"
            + " unfold. Behind him, a drink has spilled across the corner of"
            + " the table, its contents spreading over the felt. But beneath"
            + " the stack of chips, the table dips slightly—just enough to"
            + " hide something thin and rectangular out of sight.";
    roomMap[8][1] = "stack";
    
    roomMap[9][0] = "You make it to a Black Jack game, something's different than usual. The table hums with life, but no one laughs here. Five players sit in tight silence, eyes darting, fingers twitching near their chips. The dealer—an older man in a spotless white shirt and red cuffs—moves with eerie precision, flipping cards like clockwork. The felt is deep charcoal, not green, and the printed text is in dark crimson—so dark you almost miss it. Every hand feels too smooth, too deliberate. You decide you want a closer look at what's happening here.";
    roomMap[9][1] = "blackJack";
    
    roomMap[10][0] = "You're here, you know it. The door creaks open to reveal"
            + " a suite dripping in quiet opulence. Soft jazz leaks from a Bluetooth speaker resting on the nightstand, where a half-empty bottle of top-shelf bourbon leans against a sweating glass. A velvet robe has been tossed across the armchair near the balcony, its belt coiled like a snake. The oversized bed is immaculately made—except for one corner, where the blanket is turned down ever so slightly. A deck of cards, mid-shuffle, lies fanned across the writing desk, though one is missing from the sequence. At the foot of the bed, a silver tray holds the remains of room service—cracked crab shells, lemon wedges, and a folded linen napkin stiff with dried butter. Suddenly, a man approaches you with dice in hand and asks for a game. You comply.";
    roomMap[10][1] = "dice";

    
    }
            

    /**
     * Constructor to show a Clue object.
     *
     * @param hasPuzzle whether the clue has a puzzle
     * @param description text description of the clue
     */
    public Clue(boolean hasPuzzle) {
        if (!hasPuzzle) {
            int roomNum = (int)(Math.random() * 8);
            this.hasPuzzle = hasPuzzle;
            this.puzzleComplete = false;
            this.clueDesc = roomMap[roomNum][0];
            this.clueKey = roomMap[roomNum][1];
        } else {
            int roomNum = ((int) ((Math.random() * 8)) + 1);
            this.hasPuzzle = hasPuzzle;
            this.puzzleComplete = false;
            this.clueDesc = roomMap[roomNum][0];
            this.clueKey = roomMap[roomNum][1];
        }

    }
    
    public static void blackJack() {
        blackjack puzzle = new blackjack();
        puzzle.playGame();
        if(puzzle.getUserWins()) {
            System.out.println("Puzzle solved! You found a clue!");
        } else {
            System.out.println("You lost...");
        }
    }
    
    public static void dice() {
        dice puzzle = new dice();
        puzzle.playGame();
        if(puzzle.getUserWins()) {
            System.out.println("Puzzle solved! You found a clue!");
        } else {
            System.out.println("You lost...");
        }
    }
    /**
     * Marks the puzzle as complete if it exists and displays the clue image in the room.
     */
    public void completePuzzle() {
        if (hasPuzzle) {
            this.puzzleComplete = true;
            System.out.println("Puzzle solved! You found a clue!");
        } else {
            System.out.println("You found a clue!"); // "This clue doesn't have a puzzle."
        }
    }

    /**
     * Shows the description of the clue.
     */
    public String getClueKey() {
        return this.clueKey;
    }
    
    public String getClueDesc() {
        return this.clueDesc;
    }
}
