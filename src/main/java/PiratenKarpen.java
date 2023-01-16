import pk.Dice;
import pk.Faces;

import java.util.ArrayList;
import java.util.Scanner;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");

        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println(myDice.rollEight());
        

        System.out.println("That's all folks!");
    }

}
