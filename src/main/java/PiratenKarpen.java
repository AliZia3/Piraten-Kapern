import pk.CheckSkulls;
import pk.Dice;
import pk.Faces;
import pk.ScorePoints;

import java.util.ArrayList;
import java.util.Scanner;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");

        Dice myDice = new Dice();
        CheckSkulls skulls = new CheckSkulls();
        ScorePoints points = new ScorePoints();

        ArrayList<Faces> roll_results = myDice.rollEight();

        System.out.println(myDice.roll());
        System.out.println(roll_results);
        System.out.println("Skulls: " + skulls.checkSkulls(roll_results));
        System.out.println("Points: " + points.Points(roll_results));
        

        System.out.println("That's all folks!");
    }

}
