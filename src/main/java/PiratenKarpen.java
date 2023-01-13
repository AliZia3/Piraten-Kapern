import pk.Dice;
import pk.EndTurn;
import pk.Faces;

import java.util.ArrayList;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        ArrayList<Faces> results = Dice.roll();
        System.out.println(results);

        EndTurn game = new EndTurn();
        game.turn_condition(results);

        System.out.println("That's all folks!");
    }
    
}
