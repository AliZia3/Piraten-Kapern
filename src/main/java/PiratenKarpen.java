import pk.CheckSkulls;
import pk.Dice;
import pk.Faces;

import java.util.ArrayList;
import java.util.Scanner;

public class PiratenKarpen {

    public static void main(String[] args) {
        // Initial Vars
        String player1 = "Player1";
        String player2 = "Player1";
        String currPlayer = player1;
        boolean gameOver = false;

        // Object Instantiation
        Dice myDice = new Dice();

        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");

        // Initial roll
        ArrayList<Faces> initialRoll = myDice.rollEight();
        ArrayList<Faces> newRoll = myDice.nextRoll(initialRoll);

        System.out.println("Initial Roll: " + initialRoll);
        System.out.println("New Roll: " + newRoll);

        System.out.println("That's all folks!");
    }

}
