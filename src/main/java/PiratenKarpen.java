import pk.Dice;
import pk.Faces;

import java.util.ArrayList;
import java.util.Scanner;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");

        ArrayList<Faces> roll_results = Dice.rollEight();

        System.out.println(roll_results);
        

        System.out.println("That's all folks!");
    }

}
